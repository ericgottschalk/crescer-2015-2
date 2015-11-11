using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class BaseDbContext : DbContext
    {
        public BaseDbContext()
            : base("LOCADORA")
        {
        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }
        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoJogo());
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoCliente());
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoUsuario());
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoPermissao());
            base.OnModelCreating(modelBuilder);
        }
    }
}
