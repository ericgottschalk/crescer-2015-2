using Locadora.Domain.DataBaseAccess;
using Locadora.Domain.GameModule;
using Locadora.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.Controllers
{
    public class RelatorioController : Controller
    {
        public ActionResult JogosDisponiveis()
        {
            var listJogoModel = new List<JogoModel>();

            string path = @"C:\Users\bujil_000\Documents\CWICrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-06\Locadora\Locadora.Web\files\game-store.xml";
            var unit = new GameUnitOfWork(path);
            var service = new GameDomainService(unit);
            var list = service.Get().ToList();

            foreach (var jogo in list)
            {
                var jogoModel = new JogoModel()
                {
                    Id = jogo.Id,
                    Name = jogo.Name,
                    Category = jogo.Category,
                    Price = jogo.Price,
                    Available = jogo.Available
                };

                listJogoModel.Add(jogoModel);
            }

            var relatrio = new RelatorioModel(listJogoModel);
            return View(relatrio);
        }
    }
}