using Locadora.Domain.Commom;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Domain.DataBaseAccess
{
    public class GameUnitOfWork : GameDataBaseContext, IUnitOfWork
    {
        public GameUnitOfWork()
        {
        }
        
        public GameUnitOfWork(string path)
            : base(path)
        {
        }

        public void Commit()
        {
            this.SaveChanges();
        }
    }
}
