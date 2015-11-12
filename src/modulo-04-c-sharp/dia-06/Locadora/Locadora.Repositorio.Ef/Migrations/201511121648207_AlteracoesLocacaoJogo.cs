namespace Locadora.Repositorio.Ef.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlteracoesLocacaoJogo : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente");
            DropIndex("dbo.Jogo", new[] { "IdClienteLocacao" });
            AddColumn("dbo.Jogo", "Available", c => c.Boolean(nullable: false));
            DropColumn("dbo.Jogo", "IdClienteLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "IdClienteLocacao", c => c.Int());
            DropColumn("dbo.Jogo", "Available");
            CreateIndex("dbo.Jogo", "IdClienteLocacao");
            AddForeignKey("dbo.Jogo", "IdClienteLocacao", "dbo.Cliente", "Id");
        }
    }
}
