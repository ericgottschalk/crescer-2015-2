using Locadora.Dominio;
using Locadora.Dominio.ModuloUsuario;
using Locadora.Dominio.ModuloUsuario.Queries;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Repositorios
{
    public class UsuarioRepositorio : RepositorioBase<Usuario>, IUsuarioRepositorio
    {
        public Usuario BuscarPorEmail(string email)
        {
            using (var dbContext = new BaseDbContext())
            {
                return dbContext.Usuario.Include("Permissoes").FirstOrDefault(t => t.Email.Equals(email));
            }
        }

        public IList<Usuario> BuscarPorNome(string nome)
        {
            return this.Buscar(new BuscarUsuarioPorNomeQuery(nome));
        }
    }
}
