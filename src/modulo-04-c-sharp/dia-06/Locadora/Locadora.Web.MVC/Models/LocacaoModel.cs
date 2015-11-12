using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocacaoModel
    {
        public int IdJogo { get; set; }

        public int IdCliente { get; set; }

        public string NomeJogo { get; set; }

        [Required]
        public string NomeCliente { get; set; }

        public string Selo { get; set; }

        public string ImagemJogo { get; set; }

        public DateTime DataPrevista { get; set; }

        public decimal Valor { get; set; }

        public decimal GetValor()
        {
            if (Selo == "OURO")
                return 15;

            if (Selo == "PRATA")
                return 10;

            return 10;
        }

        public DateTime GetDataPrevista()
        {
            if (Selo == "OURO")
                return DateTime.Now.AddDays(1);

            if (Selo == "PRATA")
                return DateTime.Now.AddDays(2);

            return DateTime.Now.AddDays(3);
        }
    }
}