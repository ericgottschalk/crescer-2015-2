using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LocadoraNunesGame.UI
{
    public class Menu
    {
        private const string INSERT = "1";
        private const string SHOWALL = "2";
        private const string FINDBYNAME = "3";
        private const string FINDBYID = "4";
        private const string UPDATE = "5";
        private const string DELETE = "6";
        private const string TXT = "7";
        private const string EXIT = "8";

        public void CWMenu()
        {
            Console.WriteLine("1 - Inserir novo jogo");
            Console.WriteLine("2 - Mostrar todos");
            Console.WriteLine("3 - Pesquisar jogo por nome");
            Console.WriteLine("4 - Pesquisar jogo por id");
            Console.WriteLine("5 - Editar jogo");
            Console.WriteLine("6 - Deletar jogo");
            Console.WriteLine("7 - Salvar relatorio em txt");
            Console.WriteLine("8 - Sair");
            Console.WriteLine();
        }

        public bool Select(Operations operations)
        {
            string userEnter = Console.ReadLine();
            switch (userEnter)
            {
                case INSERT:
                    operations.Insert();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case SHOWALL:
                    operations.Show();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case FINDBYNAME:
                    operations.FindByName();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case FINDBYID:
                    operations.FindById();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case UPDATE:
                    operations.Update();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case DELETE:
                    operations.Delete();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case TXT:
                    operations.SaveTxt();
                    Console.WriteLine("Press any key to continue...");
                    return false;

                case EXIT:
                    Console.WriteLine("Press any key to exit...");
                    return true;

                default:
                    Console.WriteLine("Invalid operation...");
                    return false;
            }
        }

        public void Run()
        {
            var operations = new Operations();
            bool exit = false;
            while(!exit)
            {
                Console.Clear();
                CWMenu();
                exit = Select(operations);
                Console.ReadKey();
            }
        }
    }
}
