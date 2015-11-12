using Locadora.Dominio.ModuloLocacao;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Mapeamentos
{
    public class MapeamentoLocacao : EntityTypeConfiguration<Locacao>
    {
        public MapeamentoLocacao()
        {
            this.ToTable("Locacao");

            this.HasKey(t => t.Id);

            this.Property(t => t.DataLocacao).IsRequired();

            this.Property(t => t.DataParaDevolucao).IsRequired();

            this.Property(t => t.DataDevolucao).IsOptional();

            this.Property(t => t.Status).IsOptional();

            this.HasRequired(t => t.jogo).WithOptional().Map(m => m.MapKey("IdJogo"));

            this.HasRequired(t => t.cliente).WithOptional().Map(m => m.MapKey("IdCliente"));
        }
    }
}
