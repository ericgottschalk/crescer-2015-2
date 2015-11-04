using Locadora.Domain.Commom;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Domain.GameModule
{
    public class Game : Base
    {
        public string Name { get; set; }

        public double Price { get; set; }

        public GameCategory Category { get; set; }

        public bool Available { get; set; }

        public override string ToString()
        {
            return String.Format("Id: {0} - Nome: {1} - Preço: {2:C} - Categoria: {3}", 
                                     this.Id, this.Name.Truncate(25).ToUpper(), this.Price, this.Category);
        }
    }
}
