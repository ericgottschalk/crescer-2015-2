
using System;
using System.Collections.Generic;
using System.Dynamic;
using System.Linq;

namespace DbFuncionarios
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.Read();
        }

        static void Criarasdasd(int? id)
        {
            if(id.HasValue)
            {
                Console.WriteLine("Tem valor");
            }
            else
            {
                Console.WriteLine(id.Value);
            }
        }

        static dynamic[] BuscarNomeEIdETituloDoCargoDeFuncionarios()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var query = from f in funcionarios
                        select new
                        {
                            Id = f.Id,
                            Nome = f.Nome,
                            TituloCargo = f.Cargo.Titulo
                        };

            return query.ToArray();
        }

        static IList<Funcionario> BuscarOrdenadosPorNome()
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            var resultado = funcionarios.OrderByDescending(funcionario => funcionario.Nome).ToList();

            return resultado;
        }

        static Funcionario BuscarPorId(int id)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;
            //
            //return funcionarios.FirstOrDefault(funcionario => funcionario.Id == id);

            IEnumerable<Funcionario> query = from funcionario in funcionarios
                                             where funcionario.Id == id
                                             select funcionario;
            
            //query = funcionarios.Where(f => f.Id == id).FirstOrDefault();

            return query.FirstOrDefault();
        }

        static IList<Funcionario> BuscarPorCargo(string tituloCargo)
        {
            var baseDeDados = new BaseDeDados();
            List<Funcionario> funcionarios = baseDeDados.Funcionarios;

            return funcionarios.Where(f => CompararIgnoreCase(f.Cargo.Titulo, tituloCargo)).ToList();
        }

        static bool CompararIgnoreCase(string a, string b)
        {
            if (!String.IsNullOrEmpty(a) && !String.IsNullOrEmpty(b))
            {
                return a.ToUpper() == b.ToUpper();
            }

            return a == b;
        }

        static void FazNada()
        {
            Console.WriteLine("Zorra Total");
        }
    }
}