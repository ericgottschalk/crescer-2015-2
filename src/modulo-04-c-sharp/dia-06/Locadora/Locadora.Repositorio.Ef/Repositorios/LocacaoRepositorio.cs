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
        public IList<Locacao> BuscarPendentePorNomeDoJogo(string nomeJogo)
        {
            return this.Buscar(new BuscarLocacaoPendentePorNomeDoJogoQuery(nomeJogo));
        }

        public IList<Locacao> BuscarPendentes()
        {
            return this.Buscar(new BuscarLocacaoPendenteQuery());
        }
    }
}
