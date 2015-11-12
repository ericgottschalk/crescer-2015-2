using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloJogo.Queries
{
    public class BuscarJogosDisponiveisQuery : IQuery<Jogo>
    {
        public IQueryable<Jogo> CriarQuery(IQueryable<Jogo> src)
        {
            return src.Where(t => t.Available);
        }
    }
}
