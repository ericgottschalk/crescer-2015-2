using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Mapeamentos
{
    public class MapeamentoUsuario : EntityTypeConfiguration<Usuario>
    {
        public MapeamentoUsuario()
        {
            this.ToTable("Usuario");

            this.HasKey(t => t.Id);

            this.Property(t => t.NomeCompleto).IsRequired().HasMaxLength(250);

            this.Property(t => t.Email).IsRequired().HasMaxLength(250);

            this.Property(t => t.Senha).IsRequired().HasMaxLength(256);

            this.HasMany(t => t.Permissoes).WithMany(p => p.Usuarios)
                                           .Map(m => 
                                                { m.ToTable("UsuarioPermissao");
                                                  m.MapLeftKey("IdUsuario");
                                                  m.MapRightKey("IdPermissao");
                                                });                                 
        }
    }
}
