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
                    Preco = jogo.Preco,
                    Selo = jogo.Selo.ToString()
                };

                model.ListaJogos.Add(jogoDisponivel);
            }

            model.ListaJogos = model.ListaJogos.OrderBy(t => t.Nome).ToList();
            var lista = model.ListaJogos;
            model.MediaValor = lista.Average(t => t.Preco);
            model.QuantidadeJogos = lista.Count;
            model.NomeJogoMaisCaro = lista.First(t => t.Preco == list.Max(x => x.Preco)).Nome;
            model.NomeJogoMaisBarato = lista.First(t => t.Preco == list.Min(x => x.Preco)).Nome;

            return View(model);
        }
    }
}