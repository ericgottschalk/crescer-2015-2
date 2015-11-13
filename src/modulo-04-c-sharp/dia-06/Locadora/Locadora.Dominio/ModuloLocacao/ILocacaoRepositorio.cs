using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloLocacao
{
    public interface ILocacaoRepositorio : IRepositorio<Locacao>
    {
        IList<Locacao> BuscarPendentesPorNomeJogo(string nome);

        IList<Locacao> BuscarPendentes();

        IList<Locacao> BuscarEntregues();

        int GetCountJogosDoCliente(int id);
    }
}
