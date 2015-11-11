using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloUsuario.Queries
{
    public class BuscarUsuarioPorEmailQuery : IQuery<Usuario>
    {
        private readonly string email;

        public BuscarUsuarioPorEmailQuery(string email)
        {
            this.email = email;
        }

        public IQueryable<Usuario> CriarQuery(IQueryable<Usuario> src)
        {
            return src.Where(t => t.Email.Equals(email));
        }
    }
}
