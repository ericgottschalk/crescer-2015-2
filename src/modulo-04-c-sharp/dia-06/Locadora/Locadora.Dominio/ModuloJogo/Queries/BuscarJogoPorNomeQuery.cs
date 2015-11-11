using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloJogo.Queries
{
    public class BuscarJogoPorNomeQuery : IQuery<Jogo>
    {
        private readonly string nome;

        public BuscarJogoPorNomeQuery(string nome)
        {
            this.nome = nome;
        }

        public IQueryable<Jogo> CriarQuery(IQueryable<Jogo> src)
        {
            return src.Where(t => t.Nome.StartsWith(nome));
        }
    }
}
