using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloLocacao
{
    public class BuscarLocacaoPendentePorNomeDoJogoQuery : IQuery<Locacao>
    {
        private readonly string nomeJogo;

        public BuscarLocacaoPendentePorNomeDoJogoQuery(string nomeJogo)
        {
            this.nomeJogo = nomeJogo;
        }

        public IQueryable<Locacao> CriarQuery(IQueryable<Locacao> src)
        {
            return src.Where(t => t.Status != StatusLocacao.ENTREGUE && t.Jogo.Nome.StartsWith(nomeJogo));
        }
    }
}
