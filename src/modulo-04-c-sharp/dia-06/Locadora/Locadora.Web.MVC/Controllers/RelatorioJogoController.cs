using Locadora.Dominio;
using Locadora.Repositorio.Ef;
using Locadora.Web.MVC.Authentictions;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class RelatorioJogoController : Controller
    {
        [HttpGet]
        public ActionResult JogosDisponiveis(string nome)
        {
            var repositorio = ModuleBuilder.CriarJogoRepositorio();
            
            IList<Jogo> list;

            if (!String.IsNullOrWhiteSpace(nome))
            {
                list = repositorio.BuscarPorNome(nome);
            }
            else
            {
                list = repositorio.BuscarDisponiveis();
            }

            if (list.Count == 0)
            {
                return View("NenhumRegistroEncontrado");
            }

            var model = this.GerarModel(list);           

            return View(model);
        }

        [HttpGet]
        public ActionResult Jogos()
        {
            var repositorio = ModuleBuilder.CriarJogoRepositorio();

            IList<Jogo> list = repositorio.Buscar();

            if (list.Count == 0)
            {
                return View("NenhumRegistroEncontrado");
            }

            var model = this.GerarModel(list);

            return View("JogosDisponiveis", model);
        }

        private RelatorioJogoModel GerarModel(IList<Jogo> list)
        {
            var model = new RelatorioJogoModel();

            foreach (var jogo in list)
            {
                var jogoDisponivel = new JogoDisponivelModdel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria.ToString(),
                    Selo = jogo.Selo.ToString(),
                    Disponivel = jogo.Available
                };

                model.ListaJogos.Add(jogoDisponivel);
            }

            model.ListaJogos = model.ListaJogos.OrderBy(t => t.Nome).ToList();
            var lista = model.ListaJogos;
            model.QuantidadeJogos = lista.Count;

            return model;
        }
    }
}