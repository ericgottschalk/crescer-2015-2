using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloUsuario
{
    public interface IUsuarioRepositorio : IRepositorio<Usuario>
    {
        IList<Usuario> BuscarPorNome(string nome);
        Usuario BuscarPorEmail(string email);
    }
}
