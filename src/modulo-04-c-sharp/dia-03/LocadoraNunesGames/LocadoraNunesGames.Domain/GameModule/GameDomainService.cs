﻿using LocadoraNunesGames.Domain.Commom;
using LocadoraNunesGames.Domain.DataBaseAccess;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraNunesGames.Domain.GameModule
{
    public class GameDomainService
    {
        private GameUnitOfWork unitOfWork;
        public GameDomainService(GameUnitOfWork unitOfWork)
        {
            this.unitOfWork = unitOfWork;
        }

        public void Insert(Game game)
        {
            try
            {
                this.unitOfWork.Add(game);
            }
            catch(Exception e)
            {
                throw new Exception(e.Message);
            }
        }

        public void Update(Game game)
        {
            this.unitOfWork.Update(game);  
        }

        public void Delete(Game game)
        {
            this.unitOfWork.Remove(game);
        }

        public List<Game> Get()
        {
            return this.unitOfWork.Get().ToList();
        }

        public List<Game> FindByName(string name)
        {
            return this.unitOfWork.FindByName(name);
        }

        public Game FindById(int id)
        {
            return this.unitOfWork.FindById(id);
        }

        public void SaveTxt()
        {
            this.unitOfWork.SaveTxt();
        }
    }
}
