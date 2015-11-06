using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis(string nome)
        {
            var db = new Locadora.Repositorio.ADO.JogoRepositorio();
            IList<Jogo> list;

            if (!String.IsNullOrWhiteSpace(nome))
            {
                list = db.BuscarPorNome(nome);
            }
            else
            {
                list = db.BuscarTodos();
            }

            if (list.Count == 0)
            {
                return RedirectToAction("JogosDisponiveis");
            }
            
            var model = new RelatorioModel();

            foreach (var jogo in list)
            {
                var jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Nome = jogo.Nome,
                    Categoria = jogo.Categoria.ToString(),
                    Preco = jogo.Preco,
                    Selo = jogo.Selo.ToString()
                };

                model.ListaJogos.Add(jogoModel);
            }

            model.ListaJogos = model.ListaJogos.OrderBy(t => t.Nome).ToList();
            var lista = model.ListaJogos;
            model.MediaValor = lista.Average(t => t.Preco);
            model.QuantidadeJogos = lista.Count;
            model.NomeJogoMaisCaro = lista.First(t => t.Preco == list.Max(x => x.Preco)).Nome;
            model.NomeJogoMaisBarato = lista.First(t => t.Preco == list.Min(x => x.Preco)).Nome;

            return View(model);
        }

        public ActionResult DetalhesJogo(int id)
        {
            var db = new Locadora.Repositorio.ADO.JogoRepositorio();
            var jogo = db.BuscarPorId(id);

            if (jogo == null)
            {
                return RedirectToAction("JogosDisponiveis");
            }

            var jogoModel = new DetalheModel()
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
    }
}