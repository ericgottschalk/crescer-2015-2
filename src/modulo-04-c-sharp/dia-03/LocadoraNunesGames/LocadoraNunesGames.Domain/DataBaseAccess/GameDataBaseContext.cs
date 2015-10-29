using System;
using System.Collections.Generic;
using System.Xml.Linq;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LocadoraNunesGames.Domain.GameModule;

namespace LocadoraNunesGames.Domain.DataBaseAccess
{
    public class GameDataBaseContext : IDisposable
    {
        //private readonly string path = @"C:\Users\eric.gottschalk\Desktop\Arquivos\game-store.xml";
        private readonly string path = @"C:\Users\bujil_000\Desktop\dia-02\games-store.xml";
        private bool disposed = false;
        private XElement xmlGames;

        public GameDataBaseContext()
        {
        }

        public IList<Game> Get()
        {
            this.Load();
            var list = new List<Game>();

            foreach (XElement jogo in this.xmlGames.Elements("jogo"))
            {
                string name = jogo.Element("nome").Value;
                int id = (int)jogo.Attribute("id");
                double price = Convert.ToDouble(jogo.Element("preco").Value);
                string category = (string)jogo.Attribute("categoria");

                var game = new Game()
                {
                    Id = id,
                    Name = name,
                    Price = price,
                    Category = category
                };

                list.Add(game);
            }

            return list;
        }

        public void Add(Game game)
        {
            this.Load();

            XElement srcTree = new XElement("jogo",
                new XElement("nome", game.Name),
                new XElement("preco", game.Price),
                new XElement("categoria", game.Category));

            srcTree.SetAttributeValue("id", game.Id);

            this.xmlGames.Add(srcTree);
        }

        public void Remove(Game game)
        {
            XElement element = this.xmlGames.Elements("jogo")
                        .First(t => Convert.ToInt32(t.Attribute("id").Value) == game.Id);
            element.Remove();
        }

        public void Update(Game game)
        {
            XElement element = this.xmlGames.Elements("jogo")
                        .First(t => Convert.ToInt32(t.Attribute("id").Value) == game.Id);

            element.Element("nome").Value = game.Name;
            element.Element("preco").Value = game.Price.ToString();
            element.Element("categoria").Value = game.Category;
        }

        public List<Game> FindByName(string name)
        {
            var list = this.Get().ToList();
            return list.FindAll(t => t.Name.StartsWith(name));
        }

        public Game FindById(int id)
        {
            var list = this.Get().ToList();
            return list.Find(t => t.Id == id);
        }

        private void Load()
        {
            this.xmlGames = XElement.Load(path);
        }

        protected void SaveChanges()
        {
            xmlGames.Save(path);
        }

        public void Dispose()
        {
            this.Dispose(true);
            GC.SuppressFinalize(this);
        }

        protected virtual void Dispose(bool disposing)
        {
            if (!disposed)
            {
                if (disposing)
                {
                    this.xmlGames = null;

                }
                
                disposed = true;
            }
        }
    }
}
