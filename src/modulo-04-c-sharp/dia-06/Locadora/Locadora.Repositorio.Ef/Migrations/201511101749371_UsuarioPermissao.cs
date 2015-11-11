namespace Locadora.Repositorio.Ef.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class UsuarioPermissao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Permissao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Texto = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);

            this.CriarPermissoes();
            
            CreateTable(
                "dbo.Usuarios",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        NomeCompleto = c.String(),
                        Email = c.String(nullable: false, maxLength: 250),
                        Senha = c.String(nullable: false, maxLength: 256),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                    {
                        IdUsuraio = c.Int(nullable: false),
                        IdPermissao = c.Int(nullable: false),
                    })
                .PrimaryKey(t => new { t.IdUsuraio, t.IdPermissao })
                .ForeignKey("dbo.Usuarios", t => t.IdUsuraio, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuraio)
                .Index(t => t.IdPermissao);
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuraio", "dbo.Usuarios");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuraio" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuarios");
            DropTable("dbo.Permissao");
        }

        private void CriarPermissoes()
        {
            Sql("INSERT INTO Permissao (Texto) VALUES ('ADMIN')");
            Sql("INSERT INTO Permissao (Texto) VALUES ('ATENDENTE')");
        }
    }
}
