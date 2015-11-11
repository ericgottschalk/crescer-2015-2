namespace Locadora.Repositorio.Ef.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class FIX : DbMigration
    {
        public override void Up()
        {
            //
            //
            //

            //RenameTable(name: "dbo.Usuarios", newName: "Usuario");
            //RenameColumn(table: "dbo.UsuarioPermissao", name: "IdUsuraio", newName: "IdUsuario");
            //RenameIndex(table: "dbo.UsuarioPermissao", name: "IX_IdUsuraio", newName: "IX_IdUsuario");
            //AlterColumn("dbo.Usuario", "NomeCompleto", c => c.String(nullable: false, maxLength: 250));
        }
        
        public override void Down()
        {
            //
            //
            //

            //AlterColumn("dbo.Usuario", "NomeCompleto", c => c.String());
            //RenameIndex(table: "dbo.UsuarioPermissao", name: "IX_IdUsuario", newName: "IX_IdUsuraio");
            //RenameColumn(table: "dbo.UsuarioPermissao", name: "IdUsuario", newName: "IdUsuraio");
            //RenameTable(name: "dbo.Usuario", newName: "Usuarios");
        }
    }
}
