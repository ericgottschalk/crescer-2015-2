using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.Ef
{
    public class ClienteDbContext : DbContext
    {
        public ClienteDbContext()
            : base("LOCADORA")
        {
        }

        public DbSet<Cliente> DbSetCliente
        {
            get
            {
                return this.Set<Cliente>();
            }
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new Mapeamentos.MapeamentoCliente());
            base.OnModelCreating(modelBuilder);
        }
    }
}
