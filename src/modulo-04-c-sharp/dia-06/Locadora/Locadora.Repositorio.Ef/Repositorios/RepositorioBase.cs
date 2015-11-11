using Locadora.Dominio;
using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class RepositorioBase<TEntity> : IRepositorio<TEntity> where TEntity : EntidadeBase
    {
        public int Criar(TEntity item)
        {
            using (var dbContext = new BaseDbContext())
            {
                dbContext.Set<TEntity>().Add(item);
                return dbContext.SaveChanges();
            }
        }

        public int Atualizar(TEntity item)
        {
            using (var dbContext = new BaseDbContext())
            {
                dbContext.Entry(item).State = System.Data.Entity.EntityState.Modified;
                return dbContext.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var dbContext = new BaseDbContext())
            {
                var item = this.BuscarPorId(id);
                dbContext.Set<TEntity>().Remove(item);
                return dbContext.SaveChanges();
            }
        }

        public virtual TEntity BuscarPorId(int id)
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Set<TEntity>().Find(id);
            }
        }

        public IList<TEntity> Buscar(params IQuery<TEntity>[] queries)
        {
            using (var dbContext = new BaseDbContext())
            {
                IQueryable<TEntity> query = dbContext.Set<TEntity>();

                foreach (var q in queries)
                {
                    query = q.CriarQuery(query);
                }

                return query.ToList();
            }
        }
    }
}
