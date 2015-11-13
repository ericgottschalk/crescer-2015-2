using Locadora.Dominio.ModuloLocacao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioLocacaoModel
    {
        public IList<LocacaoModel> locacoesPendentes { get; set; }

        public IList<LocacaoModel> locacoesEntregues { get; set; }

        public RelatorioLocacaoModel(IList<Locacao> pendentes, IList<Locacao> entregues)
        {
            this.locacoesEntregues = new List<LocacaoModel>();
            this.locacoesPendentes = new List<LocacaoModel>();

            if (pendentes.Count > 0)
            {
                this.CriarListaLocacaoModelPendentes(pendentes);
            }

            if (entregues.Count > 0)
            {
                this.CriarListaLocacaoModelEntregues(entregues);
            }      
        }

        private void CriarListaLocacaoModelEntregues(IList<Locacao> entregues)
        {
            foreach (var locacao in entregues)
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

                this.locacoesEntregues.Add(model);
            }
        }

        private void CriarListaLocacaoModelPendentes(IList<Locacao> pendentes)
        {
            foreach (var locacao in pendentes)
            {
                var model = new LocacaoModel()
                {
                    IdLocacao = locacao.Id,
                    Valor = locacao.Valor,
                    NomeJogo = locacao.Jogo.Nome,
                    NomeCliente = locacao.Cliente.Nome,
                    DataPrevista = locacao.DataParaDevolucao,
                    Status = locacao.Status.ToString()
                };

                this.locacoesPendentes.Add(model);
            }
        }
    }
}