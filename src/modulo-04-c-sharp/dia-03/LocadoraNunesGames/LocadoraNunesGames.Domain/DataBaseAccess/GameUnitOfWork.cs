using LocadoraNunesGames.Domain.Commom;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraNunesGames.Domain.DataBaseAccess
{
    public class GameUnitOfWork : GameDataBaseContext, IUnitOfWork
    {
        public void Commit()
        {
            this.SaveChanges();
        }

        protected override void Dispose(bool disposing)
        {
            base.Dispose(disposing);
        }
    }
}
