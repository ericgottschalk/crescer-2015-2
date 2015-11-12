namespace Locadora.Repositorio.Ef.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class Locacao : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Valor = c.Decimal(nullable: false, precision: 18, scale: 2),
                        DataLocacao = c.DateTime(nullable: false),
                        DataParaDevolucao = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(),
                        Status = c.Int(),
                        IdCliente = c.Int(nullable: false),
                        IdJogo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.IdCliente)
                .ForeignKey("dbo.Jogo", t => t.IdJogo)
                .Index(t => t.IdCliente)
                .Index(t => t.IdJogo);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "IdJogo", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "IdCliente", "dbo.Cliente");
            DropIndex("dbo.Locacao", new[] { "IdJogo" });
            DropIndex("dbo.Locacao", new[] { "IdCliente" });
            DropTable("dbo.Locacao");
        }
    }
}
