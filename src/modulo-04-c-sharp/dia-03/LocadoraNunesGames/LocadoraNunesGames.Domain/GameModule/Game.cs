using LocadoraNunesGames.Domain.Commom;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraNunesGames.Domain.GameModule
{
    public class Game : Base
    {
        public string Name { get; set; }

        public double Price { get; set; }

        public string Category { get; set; }

        public override string ToString()
        {
            return String.Format("Id: {0} - Nome: {1} - Preço: {2:C} - Categoria: {3}", 
                                     this.Id, this.Name, this.Price, this.Category);
        }
    }
}
