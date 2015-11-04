using Locadora.Domain.GameModule;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Locadora.Web.Models
{
    public class JogoModel
    {
        public int Id { get; set; }

        public string Name { get; set; }

        public double Price { get; set; }

        public GameCategory Category { get; set; }

        public bool Available { get; set; }
    }
}
