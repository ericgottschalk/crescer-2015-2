using Locadora.Domain.DataBaseAccess;
using Locadora.Domain.GameModule;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.Models
{
    public class RelatorioModel
    { 
        public List<Game> ObterJogos()
        {
            string path = @"C:\Users\bujil_000\Documents\CWICrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-06\Locadora\Locadora.Web\files\game-store.xml";
            var unitOfWork = new GameUnitOfWork(path);
            var domain = new GameDomainService(unitOfWork);

            return domain.FindByName("");
        }
    }
}