using Locadora.Dominio;
using Locadora.Dominio.Comum;
using Locadora.Dominio.ModuloCliente.Queries;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class ClienteRepositorio : RepositorioBase<Cliente>, IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            return this.Buscar(new BuscarClientesPorNomeQuery(nome));
        }

        public Cliente BuscarPorIdPorNome(string nome)
        {
            return this.Buscar(new BuscarClientePorNomeQuery(nome)).FirstOrDefault();
        }
    }
}
