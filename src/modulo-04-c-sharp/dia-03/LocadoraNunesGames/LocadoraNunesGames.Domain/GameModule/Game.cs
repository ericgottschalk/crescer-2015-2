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
    }
}
