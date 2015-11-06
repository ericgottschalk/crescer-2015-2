using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Descricao { get; set; }

        [Required]
        public string Selo { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public string Categoria { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }
    }
}