using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef.Mapeamentos
{
    public class MapeamentoJogo : EntityTypeConfiguration<Jogo>
    {
        public MapeamentoJogo()
        {
            this.ToTable("Jogo");
            this.HasKey(t => t.Id);

            this.Property(t => t.Nome).IsRequired().HasMaxLength(250);

            this.Property(t => t.Descricao).IsRequired();

            this.Property(t => t.Imagem).IsOptional().HasMaxLength(500);

            this.Property(t => t.Video).IsOptional().HasMaxLength(500);

            this.Property(t => t.Available).IsRequired();

            this.Property(t => t.Categoria).IsRequired().HasColumnName("IdCategoria");

            this.Property(t => t.Selo).IsRequired().HasColumnName("IdSelo");
        }
    }
}
