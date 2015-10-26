using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    class Program
    {
        private const string ADICIONAR = "1";
        private const string REMOVER_PORNOME = "2";
        private const string REMOVER_PORNUMERO = "3";
        private const string LISTAR = "4";
        private const string LISTAR_ORDENADO = "5";
        private const string SAIR = "6";

        public static void Menu()
        {
            Console.WriteLine("1 - Adicionar contato");
            Console.WriteLine("2 - Remover contato por nome");
            Console.WriteLine("3 - Remover contato por numero");
            Console.WriteLine("4 - Listar contatos");
            Console.WriteLine("5 - Listar contatos ordenado por nome");
            Console.WriteLine("6 - Sair\n");
        }

        public static void AdicionarContato(Agenda agenda)
        {
            Console.WriteLine("Digite o nome:");
            string nome = Console.ReadLine();
            Console.WriteLine("Digite o numero:");
            int numero = Convert.ToInt32(Console.ReadLine());
            var contato = new Contato(nome, numero);
            agenda.AdicionarContato(contato);
        }

        public static void RemoverContatoPorNome(Agenda agenda)
        {
            Console.WriteLine("Digite o nome: ");
            string nomeRemover = Console.ReadLine();
            agenda.RemoverContatos(nomeRemover);
        }

        public static void RemoverContatoPorNumero(Agenda agenda)
        {
            Console.WriteLine("Digite o numero: ");
            int numRemover = Convert.ToInt32(Console.ReadLine());
            agenda.RemoverContatos(numRemover);
        }


        public static bool Escolha(Agenda agenda)
        {
            string enter = Console.ReadLine();
            switch (enter)
            {
                case ADICIONAR:
                    AdicionarContato(agenda);
                    return false;

                case REMOVER_PORNOME:
                    RemoverContatoPorNome(agenda);
                    return false;

                case REMOVER_PORNUMERO:
                    RemoverContatoPorNumero(agenda);
                    return false;

                case LISTAR:
                    Console.WriteLine(agenda.Listar());
                    return false;

                case LISTAR_ORDENADO:
                    Console.WriteLine(agenda.ListarOrdenandoPorNome());
                    return false;

                case SAIR:
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
