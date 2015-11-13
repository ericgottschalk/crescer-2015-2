using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloLocacao
{
    public class LocacaoServicoDominio
    {
        private const decimal JUROS = 5;
        private const decimal OURO_VALOR = 15;
        private const decimal PRATA_VALOR = 10;
        private const decimal BRONZE_VALOR = 5;
        private const int OURO_DIAS = 1;
        private const int PRATA_DIAS = 2;
        private const int BRONZE_DIAS = 3;

        private ILocacaoRepositorio locacaoRepositorio;
        private IClienteRepositorio clienteRepositorio;
        private IJogoRepositorio jogoRepositrio;

        public LocacaoServicoDominio(ILocacaoRepositorio locacaoRepositorio, IClienteRepositorio clienteRepositorio, IJogoRepositorio jogoRepositrio)
        {
            this.locacaoRepositorio = locacaoRepositorio;
            this.clienteRepositorio = clienteRepositorio;
            this.jogoRepositrio = jogoRepositrio;
        }

        public void LocarJogo(int idJogo, int idCliente)
        {
            var jogo = this.jogoRepositrio.BuscarPorId(idJogo);
            var cliente = this.clienteRepositorio.BuscarPorId(idCliente);
    
            if (jogo == null)
            {
                throw new ArgumentNullException("Jogo da locação não pode ser nulo");
            }

            if (cliente == null)
            {
                throw new ArgumentNullException("Cliente da locação não pode ser nulo");
            }

            var locacao = new Locacao()
            {
                IdJogo = jogo.Id,
                IdCliente = cliente.Id,
                Valor = this.GetValorLocacao(jogo),
                DataLocacao = DateTime.Now,
                DataParaDevolucao = DateTime.Now.AddDays(this.GetDiasDevolucao(jogo)),
                Status = StatusLocacao.PRAZO
            };

            jogo.AlterarDisponibilidade(false);

            this.jogoRepositrio.Atualizar(jogo);
            this.locacaoRepositorio.Criar(locacao);
        }

        public void DevolverJogo(int idLocacao)
        {
            var locacao = this.locacaoRepositorio.BuscarPorId(idLocacao);
            var jogo = this.jogoRepositrio.BuscarPorId(locacao.IdJogo);

            locacao.DataDevolucao = DateTime.Now;
            locacao.Valor = this.GetValorFinal(locacao);
            locacao.Status = StatusLocacao.ENTREGUE;
            jogo.AlterarDisponibilidade(true);

            this.jogoRepositrio.Atualizar(jogo);
            this.locacaoRepositorio.Atualizar(locacao);
        }

        private decimal GetValorLocacao(Jogo jogo)
        {
            if (jogo.Selo == Selo.OURO)
                return OURO_VALOR;

            if (jogo.Selo == Selo.PRATA)
                return PRATA_VALOR;

            return BRONZE_VALOR;
        }

        private int GetDiasDevolucao(Jogo jogo)
        {
            if (jogo.Selo == Selo.OURO)
                return OURO_DIAS;

            if (jogo.Selo == Selo.PRATA)
                return PRATA_DIAS;

            return BRONZE_DIAS;
        }

        private decimal GetValorFinal(Locacao locacao)
        {
            var diasAtraso = locacao.DataDevolucao.Value.Day - locacao.DataParaDevolucao.Day;
            decimal juros = diasAtraso * JUROS;

            if (diasAtraso > 0)
            {
                return locacao.Valor + juros;
            }

            return locacao.Valor;
        }
    }
}
