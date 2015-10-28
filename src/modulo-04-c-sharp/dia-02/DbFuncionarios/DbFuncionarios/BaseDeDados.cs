using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class BaseDeDados
    {
        public List<Funcionario> Funcionarios{ get; private set; }

        public BaseDeDados()
        {
            this.CriarBase();
        }

        private void CriarBase()
        {
            Funcionarios = new List<Funcionario>();

            Cargo desenvolvedor = new Cargo("Desenvolvedor", 190);
            Cargo analista = new Cargo("Analista", 250);
            Cargo gerente = new Cargo("Gerente", 550.5);

            Funcionario lucasLeal = new Funcionario(1, "Lucas Leal", new DateTime(1995, 01, 24));
            lucasLeal.Cargo = desenvolvedor;
            lucasLeal.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(lucasLeal);

            Funcionario jeanPinzon = new Funcionario(2, "Jean Pinzon", new DateTime(1991, 04, 25));
            jeanPinzon.Cargo = desenvolvedor;
            jeanPinzon.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(jeanPinzon);

            Funcionario rafaelBenetti = new Funcionario(3, "Rafael Benetti", new DateTime(1991, 08, 15));
            rafaelBenetti.Cargo = desenvolvedor;
            rafaelBenetti.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(rafaelBenetti);

            Funcionario mauricioBorges = new Funcionario(4, "Maurício Borges", new DateTime(1996, 11, 30));
            mauricioBorges.Cargo = desenvolvedor;
            mauricioBorges.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(mauricioBorges);

            Funcionario leandroAndreolli = new Funcionario(5, "Leandro Andreolli", new DateTime(1990, 03, 07));
            leandroAndreolli.Cargo = desenvolvedor;
            leandroAndreolli.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(leandroAndreolli);

            Funcionario felipeNervo = new Funcionario(6, "Felipe Nervo", new DateTime(1994, 01, 12));
            felipeNervo.Cargo = desenvolvedor;
            felipeNervo.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(felipeNervo);

            Funcionario lucasKauer = new Funcionario(7, "Lucas Kauer", new DateTime(1997, 05, 10));
            lucasKauer.Cargo = desenvolvedor;
            lucasKauer.TurnoTrabalho = TurnoTrabalho.Noite;
            Funcionarios.Add(lucasKauer);

            Funcionario eduardoArnold = new Funcionario(8, "Eduardo Arnold", new DateTime(1989, 09, 16));
            eduardoArnold.Cargo = desenvolvedor;
            eduardoArnold.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(eduardoArnold);

            Funcionario gabrielAlboy = new Funcionario(9, "Gabriel Alboy", new DateTime(1990, 02, 25));
            gabrielAlboy.Cargo = analista;
            gabrielAlboy.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(gabrielAlboy);

            Funcionario carlosHenrique = new Funcionario(10, "Carlos Henrique", new DateTime(1965, 12, 02));
            carlosHenrique.Cargo = analista;
            carlosHenrique.TurnoTrabalho = TurnoTrabalho.Tarde;
            Funcionarios.Add(carlosHenrique);

            Funcionario margareteRicardo = new Funcionario(11, "Margarete Ricardo", new DateTime(1980, 10, 10));
            margareteRicardo.Cargo = gerente;
            margareteRicardo.TurnoTrabalho = TurnoTrabalho.Manha;
            Funcionarios.Add(margareteRicardo);
        }

        delegate bool expression(Funcionario item);

        //a
        public IList<Funcionario> OrdenadosPorCargo()
        {
            return this.Funcionarios.OrderBy(t => t.Cargo.Titulo).ToList();
        }

        //b
        public IList<Funcionario> BuscarPorNome(string nome)
        {
            return this.Funcionarios.FindAll(t => t.Nome.Contains(nome)).OrderBy(t => t.Nome).ToList();
        }

        //c
        public IList<dynamic> BuscaRapida()
        {
            return this.Funcionarios.Select(t => (new { Nome = t.Nome, TituloCargo = t.Cargo.Titulo})).ToList<dynamic>();
        }

        //d
        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {
            var query = (from turno in turnos
                        join f in this.Funcionarios
                        on turno equals f.TurnoTrabalho
                        select f).ToList();

            return query;
        }

        //e
        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            IEnumerable<dynamic> query = from f in this.Funcionarios
                                         group f by f.TurnoTrabalho into f
                                         select new
                                         {
                                             Turno = f.Key,
                                             Quantidade = f.Count()
                                         };
            return query.ToList();
        }

        //f
        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            return this.Funcionarios.FindAll(t => t.Cargo.Titulo == cargo.Titulo);
        }

        //g
        public IList<Funcionario> FiltrarPorIdadeAproximada(int idade)
        {
            expression exp = t => DateTime.Now.Year - t.DataNascimento.Year >= idade - 5 && 
                                  DateTime.Now.Year - t.DataNascimento.Year <= idade + 5;

            return this.Funcionarios.FindAll(t => exp(t));
        }

        //h
        public double SalarioMedio()
        {
            return Convert.ToDouble((from f in Funcionarios
                                     group f by f.Cargo.Salario into f
                                     select f.Average(t => t.Cargo.Salario)));
        }

        //i
        public IList<Funcionario> AniversariantesDoMes()
        {
            expression exp = t => t.DataNascimento.Month == DateTime.Now.Month;
            return this.Funcionarios.FindAll(t => exp(t));
        }

        //h
        //public dynamic FuncionarioMaisComplexo()
        //{

        //}
    }
}
