using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult DetalhesJogo(int id)
        {
            var db = new Locadora.Repositorio.ADO.JogoRepositorio();
            var jogo = db.BuscarPorId(id);

            if (jogo == null)
            {
                return View("NenhumRegistroEncontrado");
            }

            var jogoModel = new JogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria.ToString(),
                Preco = jogo.Preco,
                Selo = jogo.Selo.ToString(),
                Descricao = jogo.Descricao,
                Imagem = jogo.Imagem,
                Video = jogo.Video
            };

            return View(jogoModel);
        }

        public ActionResult Manter()
        {
            return View();
        }
    }
}