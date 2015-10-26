using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        public static void Menu()
        {
            Console.WriteLine("1 - Adicionar contato");
            Console.WriteLine("2 - Remover contato por nome");
            Console.WriteLine("3 - Remover contato por numero");
            Console.WriteLine("4 - Listar contatos");
            Console.WriteLine("5 - Listar contatos ordenado por nome");
            Console.WriteLine("6 - Sair\n");
        }

        public static bool Escolha(Agenda agenda)
        {
            string enter = Console.ReadLine();
            switch (enter)
            {
                case "1":
                    Console.WriteLine("Digite o nome:");
                    string nome = Console.ReadLine();
                    Console.WriteLine("Digite o numero:");
                    int numero = Convert.ToInt32(Console.ReadLine());
                    var contato = new Contato(nome, numero);
                    agenda.AdicionarContato(contato);
                    return false;

                case "2":
                    Console.WriteLine("Digite o nome: ");
                    string nomeRemover = Console.ReadLine();
                    agenda.RemoverContatos(nomeRemover);
                    return false;

                case "3":
                    Console.WriteLine("Digite o numero: ");
                    int numRemover = Convert.ToInt32(Console.ReadLine());
                    agenda.RemoverContatos(numRemover);
                    return false;

                case "4":
                    Console.WriteLine(agenda.Listar());
                    return false;

                case "5":
                    Console.WriteLine(agenda.ListarOrdenandoPorNome());
                    return false;

                case "6":
                    Console.WriteLine("Precione qualquer tecla para sair!");
                    return true;

                default:
                    Console.WriteLine("Operação inválida");
                    return false;

            }
        }

        static void Main(string[] args)
        {
            var agenda = new Agenda();
            bool exit = false;
            while(!exit)
            {
                Console.Clear();
                Menu();
                exit = Escolha(agenda);
                Console.ReadKey();
            }
        }
    }
}
