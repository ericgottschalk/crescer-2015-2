using Locadora.Dominio;
using Locadora.Web.MVC.Authentictions;
using Locadora.Web.MVC.Helpers;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class HomeController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        public JsonResult JogoAutocomplete(string term)
        {
            var jogoRepositorio = ModuleBuilder.CriarJogoRepositorio();
            IList<Jogo> jogos = string.IsNullOrWhiteSpace(term) ? jogoRepositorio.Buscar() : jogoRepositorio.BuscarPorNome(term);

            var json = jogos.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}