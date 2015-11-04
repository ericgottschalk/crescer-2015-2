using Locadora.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis()
        {
            var relatrio = new RelatorioModel();
            return View(relatrio);
        }
    }
}