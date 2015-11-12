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
    public class RelatorioJogoController : Controller
    {
        [HttpGet]
        public ActionResult JogosDisponiveis(string nome)
        {
            var repositorio = new JogoRepositorio();
            var model = new RelatorioJogoModel();
            IList<Jogo> list;

            if (!String.IsNullOrWhiteSpace(nome))
            {
                list = repositorio.BuscarPorNome(nome);
            }
            else
            {
                list = repositorio.Buscar();
            }

            if (list.Count == 0)
            {
                return View("NenhumRegistroEncontrado");
            }

            foreach (var jogo in list)
            {
                var jogoDisponivel = new JogoDisponivelModdel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria.ToString(),
                    Selo = jogo.Selo.ToString()
                };

                model.ListaJogos.Add(jogoDisponivel);
            }

            model.ListaJogos = model.ListaJogos.OrderBy(t => t.Nome).ToList();
            var lista = model.ListaJogos;
            model.QuantidadeJogos = lista.Count;

            return View(model);
        }
    }
}