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
            throw new NotImplementedException();
        }

        public Jogo BuscarPorId(int id)
        {
            throw new NotImplementedException();
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            throw new NotImplementedException();
        }

        public IList<Jogo> BuscarTodos()
        {
            throw new NotImplementedException();
        }

        public int Criar(Jogo jogo)
        {
            throw new NotImplementedException();
        }

        public int Excluir(int id)
        {
            throw new NotImplementedException();
        }

        private DbSet<Jogo> dbContext
        {
            get
            {
                return this.jogoDbContext.Set<Jogo>();
            }
        }
    }
}
