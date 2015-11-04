using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioModel
    {
        public int QuantidadeJogos { get; set; }

        public decimal MediaValor { get; set; }

        public string NomeJogoMaisCaro { get; set; }

        public string NomeJogoMaisBarato { get; set; }

        public List<JogoModel> ListaJogos { get; set; }

        public RelatorioModel()
        {
            this.ListaJogos = new List<JogoModel>();
        }
    }
}