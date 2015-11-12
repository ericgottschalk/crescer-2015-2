using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloLocacao
{
    public class Locacao : EntidadeBase
    {
        public Jogo Jogo { get; set; }

        public Cliente Cliente { get; set; }

        public decimal Valor { get; set; }

        public DateTime DataLocacao { get; set; }

        public DateTime DataParaDevolucao { get; set; }

        public DateTime? DataDevolucao { get; set; }

        public StatusLocacao Status { get; set; }
    }
}
