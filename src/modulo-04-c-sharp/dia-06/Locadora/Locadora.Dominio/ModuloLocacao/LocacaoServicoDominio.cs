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

        private ILocacaoRepositorio repositorio;

        public LocacaoServicoDominio(ILocacaoRepositorio repositorio)
        {
            this.repositorio = repositorio;
        }

        public void LocarJogo(Jogo jogo, Cliente cliente)
        {
            jogo.LocarPara(cliente);

            var locacao = new Locacao()
            {
                jogo = jogo,
                cliente = cliente,
                DataLocacao = DateTime.Now,
                DataParaDevolucao = DateTime.Now.AddDays(this.GetDiasDevolucao(jogo)),
                Status = StatusLocacao.PRAZO,
                Valor = this.GetValorLocacao(jogo)
            };

            this.repositorio.Criar(locacao);
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
