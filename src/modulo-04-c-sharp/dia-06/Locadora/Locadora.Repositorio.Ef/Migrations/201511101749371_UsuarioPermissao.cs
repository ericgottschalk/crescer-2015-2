namespace Locadora.Repositorio.Ef.Migrations
{
    using Locadora.Infraestrutura.Services;
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
                "dbo.Usuario",
                c => new
                {
                    Id = c.Int(nullable: false, identity: true),
                    NomeCompleto = c.String(nullable: false, maxLength: 250),
                    Email = c.String(nullable: false, maxLength: 250),
                    Senha = c.String(nullable: false, maxLength: 256),
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.UsuarioPermissao",
                c => new
                {
                    IdUsuario = c.Int(nullable: false),
                    IdPermissao = c.Int(nullable: false),
                })
                .PrimaryKey(t => new { t.IdUsuario, t.IdPermissao })
                .ForeignKey("dbo.Usuario", t => t.IdUsuario, cascadeDelete: true)
                .ForeignKey("dbo.Permissao", t => t.IdPermissao, cascadeDelete: true)
                .Index(t => t.IdUsuario)
                .Index(t => t.IdPermissao);

            this.CriarUsuarioAdmin();
        }

        public override void Down()
        {
            DropForeignKey("dbo.UsuarioPermissao", "IdPermissao", "dbo.Permissao");
            DropForeignKey("dbo.UsuarioPermissao", "IdUsuario", "dbo.Usuario");
            DropIndex("dbo.UsuarioPermissao", new[] { "IdPermissao" });
            DropIndex("dbo.UsuarioPermissao", new[] { "IdUsuario" });
            DropTable("dbo.UsuarioPermissao");
            DropTable("dbo.Usuario");
            DropTable("dbo.Permissao");
        }

        private void CriarPermissoes()
        {
            Sql("INSERT INTO Permissao (Texto) VALUES ('ADMIN')");
            Sql("INSERT INTO Permissao (Texto) VALUES ('ATENDENTE')");
        }

        private void CriarUsuarioAdmin()
        {
            Sql("INSERT INTO Usuario (NomeCompleto, Email, Senha) VALUES ('Administrador do Sistema', 'admin@email.com', '" + new Criptografia().Criptografar("admin") + "')");
            Sql("INSERT INTO UsuarioPermissao (IdUsuario, IdPermissao) VALUES (1, 1)");
        }
    }
}
