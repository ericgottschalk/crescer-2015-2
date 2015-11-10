using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var dbContext = new ClienteDbContext())
            {
                IQueryable<Cliente> query = dbContext.DbSetCliente;

                var clientes = query.Where(t => t.Nome.StartsWith(nome)).ToList();

                return clientes;
            }
        }
    }
}
