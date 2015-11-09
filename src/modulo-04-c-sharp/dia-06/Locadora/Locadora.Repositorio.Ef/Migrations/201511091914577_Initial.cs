namespace Locadora.Repositorio.Ef.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Descricao = c.String(nullable: false),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        IdCategoria = c.Int(nullable: false),
                        IdSelo = c.Int(nullable: false),
                        Imagem = c.String(maxLength: 500),
                        Video = c.String(maxLength: 500),
                        IdClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Clientes", t => t.IdClienteLocacao)
                .Index(t => t.IdClienteLocacao);
            
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Clientes");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropTable("dbo.Clientes");
            DropTable("dbo.Jogo");
        }
    }
}
