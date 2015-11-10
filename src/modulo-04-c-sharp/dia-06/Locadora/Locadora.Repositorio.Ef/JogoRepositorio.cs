using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity;

namespace Locadora.Repositorio.Ef
{
    public class JogoRepositorio : IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var dbContext = new JogoDbContext())
            {
                dbContext.Entry(jogo).State = EntityState.Modified;
                return dbContext.SaveChanges();
            }   
        }

        public Jogo BuscarPorId(int id)
        {
            using(var dbContext = new JogoDbContext())
            {
                return dbContext.Set<Jogo>().Find(id);
            }   
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var dbContext = new JogoDbContext())
            {
                IQueryable<Jogo> query = dbContext.Set<Jogo>();

                var jogos = query.Where(t => t.Nome.StartsWith(nome)).ToList();

                return jogos;
            }     
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var dbContext = new JogoDbContext())
            {
                return dbContext.Set<Jogo>().ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var dbContext = new JogoDbContext())
            {
                dbContext.Set<Jogo>().Add(jogo);
                return dbContext.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            using (var dbContext = new JogoDbContext())
            {
                var jogo = this.BuscarPorId(id);
                dbContext.Set<Jogo>().Remove(jogo);

                return dbContext.SaveChanges();
            }
        }
    }
}
