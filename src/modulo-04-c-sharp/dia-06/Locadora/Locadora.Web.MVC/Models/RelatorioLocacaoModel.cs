using Locadora.Dominio.ModuloLocacao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioLocacaoModel
    {
        public IList<LocacaoModel> Locacoes { get; set; }

        public RelatorioLocacaoModel(IList<Locacao> lista)
        {
            this.Locacoes = new List<LocacaoModel>();

            if (lista.Count > 0)
            {
                this.CriarListaLocacaoModel(lista);
            }    
        }

        private void CriarListaLocacaoModel(IList<Locacao> lista)
        {
            foreach (var locacao in lista)
            {
                var model = new LocacaoModel()
                {
                    IdLocacao = locacao.Id,
                    Valor = locacao.Valor,
                    NomeJogo = locacao.Jogo.Nome,
                    NomeCliente = locacao.Cliente.Nome,
                    DataPrevista = locacao.DataParaDevolucao,
                    DataEntrega = locacao.DataDevolucao,
                    Status = locacao.Status.ToString()
                };

                this.Locacoes.Add(model);
            }
        }
    }
}