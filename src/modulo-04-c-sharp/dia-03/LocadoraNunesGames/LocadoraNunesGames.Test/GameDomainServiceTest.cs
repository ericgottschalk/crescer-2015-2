using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LocadoraNunesGames.Domain.DataBaseAccess;
using LocadoraNunesGames.Domain.GameModule;

namespace LocadoraNunesGames.Test
{
    [TestClass]
    public class GameDomainServiceTest
    {
        [TestMethod]
        public void Insert()
        {
            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                var game = new Game()
                {
                    Name = "Test",
                    Price = 100,
                    Category = GameCategory.RPG
                };

                service.Insert(game);
                unitOfWork.Commit();

                //Deve haver ao menos 1 game que o nome inicie com Tes
                Assert.IsTrue(service.FindByName("Tes").Count > 0);
            }
        }

        [TestMethod]
        public void Update()
        {
            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                var game = new Game()
                {
                    Name = "Test",
                    Price = 100,
                    Category = GameCategory.RPG
                };

                service.Insert(game);
                unitOfWork.Commit();

                game.Name = "Modfied";
                service.Update(game);
                unitOfWork.Commit();

                //Deve haver ao menos 1 game que o nome inicie com Mod
                Assert.IsTrue(service.FindByName("Mod").Count > 0);
            }
        }

        [TestMethod]
        public void Delete()
        {
            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                var game = new Game()
                {
                    Name = "Delete",
                    Price = 100,
                    Category = GameCategory.RPG
                };

                service.Insert(game);
                unitOfWork.Commit();

                //Deve haver 1 registro (adicionado acima)
                Assert.IsTrue(service.FindByName("Delet").Count > 0);

                service.Delete(game);
                unitOfWork.Commit();

                //Nao deve haver registros
                Assert.IsTrue(service.FindByName("Delet").Count == 0);
            }
        }
    }
}
