using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IClienteRepositorio : IRepositorio<Cliente>
    {
        IList<Cliente> BuscarPorNome(string nome);

        Cliente BuscarPorIdPorNome(string nome);
    }
}
