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
        public ActionResult Index()
        {
            var locacaoRepositorio = ModuleBuilder.CriarLocacaoRepositorio();
            var pendentes = locacaoRepositorio.BuscarPendentes();
            var entregues = locacaoRepositorio.BuscarEntregues();

            var model = new RelatorioLocacaoModel(pendentes, entregues);
            return View(model);
        }

        [HttpGet]
        public ActionResult LocarJogo(int id)
        {
            var jogoRepositorio = ModuleBuilder.CriarJogoRepositorio();

            var jogo = jogoRepositorio.BuscarPorId(id);

            if (jogo == null)
            {
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            var model = new LocacaoModel()
            {
                IdJogo = id,
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
                var cliente = clienteRepositorio.BuscarPorIdPorNome(model.NomeCliente);

                if (cliente == null)
                {
                    TempData["ClienteNull"] = "Cliente não encontrado!";
                    return RedirectToAction("LocarJogo", "Locar", model.IdJogo);
                }

                var servico = ModuleBuilder.CriarServicoLocacao();

                servico.LocarJogo(model.IdJogo, cliente.Id);

                TempData["Mensagem"] = "Jogo locado com sucesso!";
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            ModelState.AddModelError("", "Ocorreu um erro!");
            return RedirectToAction("LocarJogo", "Locar", model.IdJogo);
        }

        public ActionResult ServicoDevolucao(LocacaoModel model)
        {
            var servico = ModuleBuilder.CriarServicoLocacao();

            servico.DevolverJogo(model.IdLocacao.Value);

            TempData["Mensagem"] = "Jogo devolvido com sucesso";
            return RedirectToAction("Index", "Locar");
        }

        public JsonResult ClienteAutocomplete(string term)
        {
            var clienteRepositorio = ModuleBuilder.CriarClienteRepositorio();
            IList<Cliente> clientes = string.IsNullOrWhiteSpace(term) ? clienteRepositorio.Buscar() : clienteRepositorio.BuscarPorNome(term);

            var json = clientes.Select(x => new { label = x.Nome });

            return Json(json, JsonRequestBehavior.AllowGet);
        }
    }
}