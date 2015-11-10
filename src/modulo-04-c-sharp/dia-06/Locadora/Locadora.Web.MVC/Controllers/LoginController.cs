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
        // GET: Login
        public ActionResult Index()
        {
            return View(new UsuarioModel());
        }

        public ActionResult Login(UsuarioModel usuario)
        {
            if (usuario.Email == "test@email.com" && usuario.Senha == "test")
            {
                var logado = new UsuarioLogado(usuario.Email, new string[] { "DetalhesJogo" });

                FormsAuthentication.SetAuthCookie(logado.Email, true);

                Session["USUARIO_LOGADO"] = logado;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}