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

        public void LocarJogo(int idJogo, Cliente cliente)
        {
            var jogo = this.jogoRepositrio.BuscarPorId(idJogo);
    
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
                Jogo = jogo,
                Cliente = cliente,
                Valor = this.GetValorLocacao(jogo),
                DataLocacao = DateTime.Now,
                DataParaDevolucao = DateTime.Now.AddDays(this.GetDiasDevolucao(jogo)),
                Status = StatusLocacao.PRAZO
            };

            locacao.Jogo.AlterarDisponibilidade(false);

            this.locacaoRepositorio.Criar(locacao);
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
    }
}
