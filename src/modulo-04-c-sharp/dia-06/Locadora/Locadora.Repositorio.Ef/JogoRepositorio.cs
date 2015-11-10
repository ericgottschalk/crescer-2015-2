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
        private JogoDbContext jogoDbContext;

        public JogoRepositorio(JogoDbContext dbContext)
        {
            this.jogoDbContext = dbContext;
        }

        public int Atualizar(Jogo jogo)
        {
            var jogoDb = this.BuscarPorId(jogo.Id);
            var entry = this.jogoDbContext.Entry(jogoDb);
            entry.CurrentValues.SetValues(jogo);
            entry.State = EntityState.Modified;

            return this.Commit();
        }

        public Jogo BuscarPorId(int id)
        {
            return this.DbContext.Find(id);
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            IQueryable<Jogo> query = this.DbContext;

            var jogos = query.Where(t => t.Nome.StartsWith(nome)).ToList();

            return jogos;
        }

        public IList<Jogo> BuscarTodos()
        {
            return this.DbContext.ToList();
        }

        public int Criar(Jogo jogo)
        {
            this.DbContext.Add(jogo);
            return this.Commit();
        }

        public int Excluir(int id)
        {
            var jogo = this.BuscarPorId(id);
            this.DbContext.Remove(jogo);

            return this.Commit();
        }

        private int Commit()
        {
            return this.jogoDbContext.SaveChanges();
        }

        private DbSet<Jogo> DbContext
        {
            get
            {
                return this.jogoDbContext.Set<Jogo>();
            }
        }
    }
}
