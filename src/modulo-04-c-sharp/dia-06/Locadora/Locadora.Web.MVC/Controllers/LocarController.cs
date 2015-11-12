using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class LocarController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }
    }
}