using Locadora.Dominio;
using Locadora.Dominio.ModuloLocacao;
using Locadora.Web.MVC.Models;
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
    public class LocarController : Controller
    {
        [HttpGet]
        public ActionResult Index(string nome)
        {
            var locacaoRepositorio = ModuleBuilder.CriarLocacaoRepositorio();
            IList<Locacao> lista;

            if (!string.IsNullOrWhiteSpace(nome))
            {
                lista = locacaoRepositorio.BuscarPendentesPorNomeJogo(nome);
            }
            else
            {
                lista = locacaoRepositorio.BuscarPendentes();
            }

            var model = new RelatorioLocacaoModel(lista);
            return View(model);
        }

        [HttpGet]
        public ActionResult MostrarEntregues()
        {
            var locacaoRepositorio = ModuleBuilder.CriarLocacaoRepositorio();
            IList<Locacao> lista = locacaoRepositorio.BuscarEntregues();

            var model = new RelatorioLocacaoModel(lista);
            return View(model);
        }

        [HttpGet]
        public ActionResult LocarJogo(int? id)
        {
            var jogoRepositorio = ModuleBuilder.CriarJogoRepositorio();

            if(!id.HasValue)
            {
                TempData["Mensagem"] = "Ocorreu um erro!";
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            var jogo = jogoRepositorio.BuscarPorId(id.Value);

            if (jogo == null)
            {
                TempData["Mensagem"] = "Ocorreu um erro!";
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            var model = new LocacaoModel()
            {
                IdJogo = id.Value,
                ImagemJogo = jogo.Imagem,
                Selo = jogo.Selo.ToString(),
                NomeJogo = jogo.Nome,
            };

            model.Valor = model.GetValor();
            model.DataPrevista = model.GetDataPrevista();

            return View(model);
        }

        [HttpGet]
        public ActionResult DevolverJogo(LocacaoModel locacao)
        {
            var diasAtraso = DateTime.Now.Day - locacao.DataPrevista.Day;
            var juros = diasAtraso * 5;

            if (diasAtraso > 0)
            {
                locacao.Valor += diasAtraso;
            }

            return View(locacao);
        }

        [HttpPost]
        public ActionResult Salvar(LocacaoModel model)
        {
            if (ModelState.IsValid)
            {
                var clienteRepositorio = ModuleBuilder.CriarClienteRepositorio();
                var locacaoRepositorio = ModuleBuilder.CriarLocacaoRepositorio();
                var cliente = clienteRepositorio.BuscarPorIdPorNome(model.NomeCliente);
                var servico = ModuleBuilder.CriarServicoLocacao();
                

                if (cliente == null)
                {
                    TempData["ClienteNull"] = "Cliente não encontrado!";
                    return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
                }

                var numeroDeJogosCliente = locacaoRepositorio.GetCountJogosDoCliente(cliente.Id);
                if (numeroDeJogosCliente >= 3)
                {
                    TempData["ClienteNull"] = "Cliente possui o limite de locações!";
                    return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
                }

                servico.LocarJogo(model.IdJogo, cliente.Id);

                TempData["Mensagem"] = "Jogo locado com sucesso!";
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            ModelState.AddModelError("", "Ocorreu um erro!");
            return RedirectToAction("LocarJogo", "Locar", model.IdJogo);
        }

        public ActionResult ServicoDevolucao(LocacaoModel model)
        {
            if (model.IdLocacao.HasValue)
            {
                var servico = ModuleBuilder.CriarServicoLocacao();

                servico.DevolverJogo(model.IdLocacao.Value);

                TempData["Mensagem"] = "Jogo devolvido com sucesso";
                return RedirectToAction("Index", "Locar");
            }

            TempData["Mensagem"] = "Ocorreu um erro!";
            return RedirectToAction("Index", "Locar");
        }

        public JsonResult ClienteAutocomplete(string term)
        {
            var clienteRepositorio = ModuleBuilder.CriarClienteRepositorio();
            IList<Cliente> clientes = string.IsNullOrWhiteSpace(term) ? clienteRepositorio.Buscar() : clienteRepositorio.BuscarPorNome(term);

            var json = clientes.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
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