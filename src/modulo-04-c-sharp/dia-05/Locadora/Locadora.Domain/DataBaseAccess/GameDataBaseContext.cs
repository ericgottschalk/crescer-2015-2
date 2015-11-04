using System;
using System.Collections.Generic;
using System.Xml.Linq;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Domain.GameModule;
using System.IO;

namespace Locadora.Domain.DataBaseAccess
{
    public class GameDataBaseContext
    {
        private string path = @"C:\Users\bujil_000\Documents\CWICrescer\crescer-2015-2\src\modulo-04-c-sharp\dia-06\Locadora\files\game-store.xml";
        private XElement xmlGames;

        public GameDataBaseContext()
        {
        }

        public GameDataBaseContext(string path)
        {
            this.path = path;
        }

        public IList<Game> Get()
        {
            this.Load();
            var list = new List<Game>();

            foreach (XElement jogo in this.xmlGames.Elements("jogo"))
            {
                string id = jogo.Attribute("id").Value;
                string name = jogo.Element("nome").Value;
                string price = jogo.Element("preco").Value;
                string category = jogo.Element("categoria").Value;
                string available = jogo.Element("disponivel").Value;

                var game = new Game()
                {
                    Id = Convert.ToInt32(id),
                    Name = name,
                    Price = Convert.ToDouble(price),
                    Category = (GameCategory)Enum.Parse(typeof(GameCategory), category),
                    Available = available == "SIM"
                };

                list.Add(game);
            }

            return list;
        }

        public void Add(Game game)
        {
            this.Load();
            game.Id = this.Identity();

            XElement srcTree = new XElement("jogo",
                new XElement("nome", game.Name),
                new XElement("preco", game.Price),
                new XElement("categoria", game.Category),
                new XElement("disponivel", "SIM"));

            srcTree.SetAttributeValue("id", game.Id);

            this.xmlGames.Add(srcTree);
        }

        private int Identity()
        {
            return this.Get().Max(t => t.Id) + 1;
        }

        public void Remove(Game game)
        {
            this.Load();
            XElement element = this.XElementById(game.Id);
            element.Remove();
        }

        public void Update(Game game)
        {
            this.Load();
            XElement element = this.XElementById(game.Id);                    

            element.Element("nome").Value = game.Name;
            element.Element("preco").Value = game.Price.ToString();
            element.Element("categoria").Value = game.Category.ToString();
            element.Element("disponivel").Value = game.Available ? "SIM" : "NÂO";
        }

        private XElement XElementById(int id)
        {
            this.Load();
            return this.xmlGames.Elements("jogo").First(t => (int)t.Attribute("id") == id);
        }

        public List<Game> FindByName(string name)
        {
            return this.Get().Where(t => t.Name.ToUpper().StartsWith(name.ToUpper())).ToList();
        }

        public Game FindById(int id)
        {
            return this.Get().FirstOrDefault(t => t.Id == id);
        }

        public void SaveTxt()
        {
            var list = this.Get();
            string path = Environment.CurrentDirectory + @"..\..\..\..\files\relatorio.txt";
            using (var writer = new StreamWriter(path))
            {
                writer.Flush();
                writer.WriteLine("----------------------------------------------------------------------------------------");
                writer.WriteLine("                                   LOCADORA NUNES GAMES");
                writer.WriteLine("                                    "+ DateTime.Now);
                writer.WriteLine("                                     Relatório de jogos");
                writer.WriteLine("========================================================================================");
                writer.WriteLine("----------------------------------------------------------------------------------------");
                writer.WriteLine("ID       Categoria        Nome                              Preço             Disponivel");

                foreach (var game in list)
                {
                    writer.WriteLine(String.Format("{0,-9}{1,-17}{2,-35}{3,-14}{4,10}",                     
                              game.Id, game.Category, game.Name.Truncate(30).ToUpper(), game.Price.ToString("C"), 
                              game.Available ? "SIM" : "NÃO"));
                }

                writer.WriteLine("-----------------------------------------------------------------------------------");
                writer.WriteLine();
                writer.WriteLine("Quantidade total de jogos > " + list.Count);
                writer.WriteLine("Quantidade de jogos disponíveis > " + list.Count(t => t.Available));
                writer.WriteLine(String.Format("Valor médio por jogo > {0:C}", list.Average(t => t.Price)));
                writer.WriteLine("Jogo mais caro > " + list.First(t => t.Price == list.Max(k => k.Price)).Name);
                writer.WriteLine("Jogo mais barato > " + list.First(t => t.Price == list.Min(k => k.Price)).Name);
            }
        }

        private void Load()
        {
            this.xmlGames = XElement.Load(path);
        }

        protected void SaveChanges()
        {
            this.xmlGames.Save(path);
        }
    }
}
