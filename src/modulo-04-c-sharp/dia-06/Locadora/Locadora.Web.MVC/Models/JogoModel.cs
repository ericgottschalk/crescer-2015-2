using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class JogoModel
    {
        public int? Id { get; set; }

        [Required]
        public string Nome { get; set; }

        [Required]
        public string Descricao { get; set; }

        [Required]
        public Selo Selo { get; set; }

        [Required]
        public decimal Preco { get; set; }

        [Required]
        public Categoria Categoria { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }    

        public JogoModel()
        {
        }

        public JogoModel(Jogo jogo)
        {
            this.Id = jogo.Id;
            this.Nome = jogo.Nome;
            this.Categoria = jogo.Categoria;
            this.Preco = jogo.Preco;
            this.Selo = jogo.Selo;
            this.Descricao = jogo.Descricao;
            this.Imagem = jogo.Imagem;
            this.Video = jogo.Video;
        }
    }
}