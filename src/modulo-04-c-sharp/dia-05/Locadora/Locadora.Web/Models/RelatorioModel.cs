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
        public int QuantidadeJogos { get; private set; }

        public double MediaValor { get; private set; }

        public string NomeJogoMaisCaro { get; private set; }

        public string NomeJogoMaisBarato { get; private set; }

        public List<JogoModel> ListaJogos { get; private set; }

        public RelatorioModel(List<JogoModel> list)
        {
            this.ListaJogos = list;
            this.QuantidadeJogos = list.Count;
            this.MediaValor = list.Average(t => t.Price);
            this.NomeJogoMaisCaro = list.First(t => t.Price == list.Max(k => k.Price)).Name;
            this.NomeJogoMaisBarato = list.First(t => t.Price == list.Min(k => k.Price)).Name;
        }
    }
}