using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Mapeamentos
{
    public class MapeamentoCliente : EntityTypeConfiguration<Cliente>
    {
        public MapeamentoCliente()
        {
            this.ToTable("Cliente");
            this.HasKey(t => t.Id);
            this.Property(t => t.Nome).IsRequired().HasMaxLength(250);
        }
    }
}
