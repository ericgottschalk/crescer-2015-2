using Locadora.Dominio;
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
            return View();
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

        public ActionResult Salvar(LocacaoModel model)
        {
            if (ModelState.IsValid)
            {
                var clienteRepositorio = ModuleBuilder.CriarClienteRepositorio();
                var cliente = clienteRepositorio.BuscarPorNome(model.NomeCliente).FirstOrDefault();

                if (cliente == null)
                {
                    TempData["ClienteNull"] = "Cliente não encontrado!";
                    return RedirectToAction("LocarJogo", "Locar", model.IdJogo);
                }

                var servico = ModuleBuilder.CriarServicoLocacao();

                servico.LocarJogo(model.IdJogo, cliente);

                TempData["Mensagem"] = "Jogo locado com sucesso!";
                return RedirectToAction("JogosDisponiveis", "RelatorioJogo");
            }

            ModelState.AddModelError("", "Ocorreu um erro!");
            return RedirectToAction("LocarJogo", "Locar");
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