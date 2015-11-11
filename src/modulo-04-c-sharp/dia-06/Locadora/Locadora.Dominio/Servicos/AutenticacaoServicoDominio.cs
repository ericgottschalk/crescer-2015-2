using Locadora.Dominio.ModuloUsuario;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class AutenticacaoServicoDominio
    {
        private IUsuarioRepositorio usuarioRepositorio;
        private ICriptografia servicoCriptografia;

        public AutenticacaoServicoDominio(IUsuarioRepositorio usuarioRepositorio, ICriptografia servicoCriptografia)
        {
            this.usuarioRepositorio = usuarioRepositorio;
            this.servicoCriptografia = servicoCriptografia;
        }

        public Usuario AutenticacarUsuario(string email, string senha)
        {
            Usuario usuario = this.usuarioRepositorio.BuscarPorEmail(email);

            if(usuario != null)
            {
                string senhaCriptografada = servicoCriptografia.Criptografar(senha);

                if (usuario.Senha != senhaCriptografada)
                {
                    return null;
                }
            }
            
            return usuario;
        }
    }
}
