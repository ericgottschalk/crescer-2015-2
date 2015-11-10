using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Mapeamentos
{
    public class MapeamentoPermissao : EntityTypeConfiguration<Permissao>
    {
        public MapeamentoPermissao()
        {
            this.ToTable("Permissao");

            this.HasKey(t => t.Id);

            this.Property(t => t.Texto).IsRequired().HasMaxLength(250);
        }
    }
}
