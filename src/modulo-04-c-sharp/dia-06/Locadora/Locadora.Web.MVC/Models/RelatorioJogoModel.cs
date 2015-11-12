using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioJogoModel
    {
        public int QuantidadeJogos { get; set; }

        public List<JogoDisponivelModdel> ListaJogos { get; set; }

        public RelatorioJogoModel()
        {
            this.ListaJogos = new List<JogoDisponivelModdel>();
        }
    }

    public class JogoDisponivelModdel
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public string Descricao { get; set; }

        public string Selo { get; set; }

        public string Categoria { get; set; }

        public bool Disponivel { get; set; }
    }
}