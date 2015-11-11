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
                .ForeignKey("dbo.Categoria", t => t.IdCategoria)
                .ForeignKey("dbo.Selo", t => t.IdSelo)
                .Index(t => t.IdClienteLocacao)
                .Index(t => t.IdCategoria)
                .Index(t => t.IdSelo);
            
            CreateTable(
                "dbo.Clientes",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(),
                    })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            this.CriarSelos();

            CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Nome = c.String(nullable: false, maxLength: 250),
                })
                .PrimaryKey(t => t.Id);

            this.CriarCategorias();   
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Clientes");
            DropForeignKey("dbo.Jogo", "IdCategoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "IdSelo", "dbo.Selo");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            DropIndex("dbo.Jogo", new[] { "IdCategoria" });
            DropIndex("dbo.Jogo", new[] { "IdSelo" });
            DropTable("dbo.Clientes");
            DropTable("dbo.Selo");
            DropTable("dbo.Categoria");
            DropTable("dbo.Jogo");
        }

        private void CriarSelos()
        {
            Sql("INSERT INTO Selo (Id, Nome) VALUES (1, 'Bronze')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (2, 'Prata')");
            Sql("INSERT INTO Selo (Id, Nome) VALUES (3, 'Ouro')");
        }

        private void CriarCategorias()
        {
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (1, 'RPG')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (2, 'Corrida')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (3, 'Aventura')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (4, 'Luta')");
            Sql("INSERT INTO Categoria (Id, Nome) VALUES (5, 'Esporte')");
        }
    }
}
