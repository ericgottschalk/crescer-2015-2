using Locadora.Dominio;
using Locadora.Repositorio.Ef;
using Locadora.Web.MVC.Authentictions;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class JogoController : Controller
    {
        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }
        
        [HttpGet]
        public ActionResult DetalhesJogo(int id)
        {
            var repositorio = new JogoRepositorio();

            var jogo = repositorio.BuscarPorId(id);

            if (jogo == null)
            {
                return View("NenhumRegistroEncontrado");
            }

            var jogoModel = new JogoModel(jogo);
            return View(jogoModel);
        }

        [Autorizador(Roles = "ADMIN")]
        [HttpGet]
        public ActionResult ManterJogo(int? id)
        {
            if (id.HasValue)
            {
                var repositorio = new JogoRepositorio();
                var jogo = repositorio.BuscarPorId(id.Value);

                if (jogo == null)
                {
                    TempData["Mensagem"] = "Id não encontrado!";
                    return View();
                }

                TempData["TipoManter"] = "Atualizar Jogo";
                var jogoModel = new JogoModel(jogo);
                return View(jogoModel);

            }

            TempData["TipoManter"] = "Cadastrar Jogo";
            return View();
        }

        [Autorizador(Roles = "ADMIN")]
        [ValidateAntiForgeryToken]
        [HttpPost]
        public ActionResult Salvar(JogoModel model)
        {
            if (ModelState.IsValid)
            {
                if (model.Id.HasValue)
                {
                    var repositorio = new JogoRepositorio();

                    var jogo = new Jogo(id: model.Id.Value, disponivel: model.Disponivel)
                    {
                        Nome = model.Nome,
                        Descricao = model.Descricao,
                        Categoria = model.Categoria,
                        Selo = model.Selo,
                        Imagem = model.Imagem,
                        Video = model.Video
                    };

                    repositorio.Atualizar(jogo);

                    TempData["Mensagem"] = "Jogo atualizado com sucesso!";
                }
                else
                {
                    var repositorio = new JogoRepositorio();

                    var jogo = new Jogo()
                    {
                        Nome = model.Nome,
                        Descricao = model.Descricao,
                        Categoria = model.Categoria,
                        Selo = model.Selo,
                        Imagem = model.Imagem,
                        Video = model.Video,
                        Available = true
                    };

                    repositorio.Criar(jogo);

                    TempData["Mensagem"] = "Jogo salvo com sucesso!";
                }

                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            TempData["Mensagem"] = "Ocorreu um erro!";
            return View("ManterJogo", model);
        }
    }
}