using Locadora.Dominio.ModuloLocacao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Repositorios
{
    public class LocacaoRepositorio : RepositorioBase<Locacao>, ILocacaoRepositorio
    {
        public override int Atualizar(Locacao item)
        {
            using (var dbContext = new BaseDbContext())
            {
                var locacao = this.BuscarPorId(item.Id);

                locacao.Status = item.Status;
                locacao.DataDevolucao = item.DataDevolucao;
                locacao.Valor = item.Valor;

                dbContext.Entry(locacao).State = System.Data.Entity.EntityState.Modified;
                return dbContext.SaveChanges();
            }
        }

        public IList<Locacao> BuscarEntregues()
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Locacao.Include("Cliente").Include("Jogo").Where(t => t.Status == StatusLocacao.ENTREGUE).ToList();
            }
        }

        public IList<Locacao> BuscarPendentes()
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Locacao.Include("Cliente").Include("Jogo").Where(t => t.Status != StatusLocacao.ENTREGUE).ToList();
            }
        }

        public IList<Locacao> BuscarPendentesPorNomeJogo(string nome)
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Locacao.Include("Cliente").Include("Jogo")
                    .Where(t => t.Status != StatusLocacao.ENTREGUE && t.Jogo.Nome.StartsWith(nome)).ToList();
            }
        }

        public int GetCountJogosDoCliente(int id)
        {
            return this.BuscarPendentes().Count(t => t.Cliente.Id == id);
        }
    }
}
