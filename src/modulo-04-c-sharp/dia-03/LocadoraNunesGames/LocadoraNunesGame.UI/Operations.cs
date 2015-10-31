using LocadoraNunesGames.Domain.DataBaseAccess;
using LocadoraNunesGames.Domain.GameModule;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraNunesGame.UI
{
    public class Operations
    {
        public bool Availabe()
        {
            Console.Clear();
            Console.WriteLine("ESCOLHA A DISPONIBILIDADE:");
            Console.WriteLine("1 - SIM");
            Console.WriteLine("2 - NA0");
            Console.WriteLine();

            string userEnter = Console.ReadLine();
            switch(userEnter)
            {
                case "1":
                    return true;

                case "2":
                    return false;

                default:
                    Console.WriteLine("Opção inválida! Disponibilidade foi definida como 'NÂO', para alterar vá em editar!");
                    return false;
            }
        }

        public GameCategory Category()
        {
            Console.Clear();
            Console.WriteLine("ESCOLHA A CATEGORIA:");
            Console.WriteLine("1 - RPG");
            Console.WriteLine("2 - CORRIDA");
            Console.WriteLine("3 - AVENTURA");
            Console.WriteLine("4 - LUTA");
            Console.WriteLine("5 - ESPORTE");
            Console.WriteLine();

            string userEnter = Console.ReadLine();
            switch(userEnter)
            {
                case "1":
                    return GameCategory.RPG;

                case "2":
                    return GameCategory.CORRIDA;

                case "3": 
                     return GameCategory.AVENTURA;

                case "4":
                     return GameCategory.LUTA;

                case "5":
                     return GameCategory.ESPORTE;

                default:
                     Console.WriteLine("Opcão invialida. Categoria foi definida como 'INDEFINIDO', para alterar vá em editar!");
                     return GameCategory.INDEFINIDO;
            } 
        }

        private Game Find()
        {
            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                Console.WriteLine("Digite o id a ser pesquisado:");
                int id;
                try
                { 
                    id = Convert.ToInt32(Console.ReadLine());     
                }
                catch(Exception e)
                { 
                    Console.WriteLine("Este campo só aceita numeros! Tente novamente. >>> " + e.Message);
                    return null;
                }
                

                return service.FindById(id);
            }
        }

        public void Insert()
        {
            Console.Clear();

            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                Console.WriteLine("Digite o nome >");
                string name = Console.ReadLine();
                double price;
                try
                {
                    Console.WriteLine("Diite o preco >");
                    price = Convert.ToDouble(Console.ReadLine(),
                                                    System.Globalization.CultureInfo.InvariantCulture);                  
                }
                catch(Exception e)
                {
                    Console.WriteLine("O campo preço aceita somente numeros. Operação abortada, tente novamente! >>>" + e.Message);
                    return;
                }

                var game = new Game()
                {
                    Name = name,
                    Price = price,
                    Category = Category()
                };

                service.Insert(game);
                unitOfWork.Commit();
            }
        }

        public void FindByName()
        {
            Console.Clear();

            List<Game> list;

            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                Console.WriteLine("Digite o nome a ser procurado:");
                string name = Console.ReadLine();
                list = service.FindByName(name);
            }

            if (list == null || list.Count == 0)
            {
                Console.WriteLine("Nenhum registro encontrado!");
                return;
            }

            foreach(var game in list)
            {
                Console.WriteLine(game.ToString());
            }
        }

        public void FindById()
        {
            Console.Clear();

            Game game = Find();

            if (game == null)
            {
                Console.WriteLine("Nenhum registro encontrado!");
                return;
            }

            Console.WriteLine(game.ToString());
        }

        public void Update()
        {
            Console.Clear();

            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                var game = Find();

                if (game == null)
                {
                    Console.WriteLine("Nenhum registro encontrado!");
                    return;
                }

                Console.WriteLine("Digite o nome >");
                game.Name = Console.ReadLine();
                try
                {
                    Console.WriteLine("Diite o preco >");
                    game.Price = Convert.ToDouble(Console.ReadLine(),
                                                  System.Globalization.CultureInfo.InvariantCulture);                  
                }
                catch(Exception e)
                {
                    Console.WriteLine("O campo preço aceita somente numeros. Operação abortada, tente novamente! >>> " + e.Message);
                    return;
                }

                game.Category = Category();
                game.Available = Availabe();

                service.Update(game);
                unitOfWork.Commit();
            }
        }

        public void Delete()
        {
            Console.Clear();

            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);

                var game = Find();

                if (game == null)
                {
                    Console.WriteLine("Nenhum registro encontrado!");
                    return;
                }

                service.Delete(game);
                unitOfWork.Commit();
            }
        }

        public void SaveTxt()
        {
            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);
                service.SaveTxt();
            }
        }

        public void Show()
        {
            Console.Clear();
            List<Game> list;

            using (var unitOfWork = new GameUnitOfWork())
            {
                var service = new GameDomainService(unitOfWork);
                list = service.Get();
            }

            if (list == null || list.Count == 0)
            {
                Console.WriteLine("Nenhum registro encontrado!");
                return;
            }

            foreach (var game in list)
            {
                Console.WriteLine(game.ToString());
            }
        }
    }
}
