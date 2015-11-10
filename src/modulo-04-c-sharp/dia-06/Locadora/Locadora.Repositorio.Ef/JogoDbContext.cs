using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class JogoDbContext : DbContext
    {
        public JogoDbContext()
            : base("LOCADORA")
        {
        }

        public DbSet<Jogo> DbSetJogo
        {
            get
            {
                return this.Set<Jogo>();
            }
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoJogo());
            base.OnModelCreating(modelBuilder);
        }
    }
}
