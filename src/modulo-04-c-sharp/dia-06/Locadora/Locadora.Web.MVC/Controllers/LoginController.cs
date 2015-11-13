using Locadora.Dominio.Servicos;
using Locadora.Infraestrutura.Services;
using Locadora.Repositorio.Ef.Repositorios;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View(new UsuarioModel());
        }

        [HttpPost]
        public ActionResult Login(UsuarioModel usuario)
        {
            if (ModelState.IsValid)
            {
                var servico = ModuleBuilder.CriarServicoAutenticacao();

                var usuarioAutentiado = servico.AutenticacarUsuario(usuario.Email, usuario.Senha);

                if (usuarioAutentiado != null)
                {
                    String[] permicoes = new String[2];

                    foreach (var permissao in usuarioAutentiado.Permissoes)
                    {
                        permicoes[permicoes.Count(t => t != null)] = permissao.Texto;
                    }

                    var logado = new UsuarioLogado(usuarioAutentiado.Email, permicoes);
                    FormsAuthentication.SetAuthCookie(logado.Email, true);
                    Session["USUARIO_LOGADO"] = logado;
                    return RedirectToAction("Index", "Home");
                }
            }

            ModelState.AddModelError("INVALID_LOGIN", "Usuário ou senha inválidos.");
            return View("Index", usuario);
        }

        [HttpGet]
        public ActionResult Logout()
        {
            FormsAuthentication.SignOut();
            return RedirectToAction("Index", "Login");
        }
    }
}