using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity;
using Locadora.Dominio.ModuloJogo.Queries;

namespace Locadora.Repositorio.Ef
{
    public class JogoRepositorio : RepositorioBase<Jogo>, IJogoRepositorio
    {
        public override Jogo BuscarPorId(int id)
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Jogo.Include("Cliente").FirstOrDefault(t => t.Id == id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            return this.Buscar(new BuscarJogoPorNomeQuery(nome));
        }
    }
}
