using Locadora.Dominio.ModuloLocacao;
using Locadora.Dominio.ModuloUsuario;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Infraestrutura.Services;
using Locadora.Repositorio.Ef;
using Locadora.Repositorio.Ef.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Helpers
{
    public class ModuleBuilder
    {
        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IClienteRepositorio CriarClienteRepositorio()
        {
            return new ClienteRepositorio();
        }

        public static ILocacaoRepositorio CriarLocacaoRepositorio()
        {
            return new LocacaoRepositorio();
        }

        public static ICriptografia CriarServicoCriptografia()
        {
            return new Criptografia();
        }

        public static AutenticacaoServicoDominio CriarServicoAutenticacao()
        {
            return new AutenticacaoServicoDominio(CriarUsuarioRepositorio(), CriarServicoCriptografia());
        }

        public static LocacaoServicoDominio CriarServicoLocacao()
        {
            return new LocacaoServicoDominio(CriarLocacaoRepositorio(), CriarClienteRepositorio(), CriarJogoRepositorio());
        }
    }
}