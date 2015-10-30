using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;
using System.Collections.Generic;

namespace DbTest
{
    [TestClass]
    public class UnitTest1
    {
        //b
        [TestMethod]
        public void BuscarPorNome()
        {
            var dbContext = new BaseDeDados();

            var arnold = dbContext.BuscarPorNome("nold");

            //Deve haver 1 funcionario na lista
            Assert.IsTrue(arnold.Count == 1);
        }

        //c
        [TestMethod]
        public void BuscaRapida()
        {
            var dbContext = new BaseDeDados();

            Assert.IsTrue(dbContext.BuscaRapida().Count == 11);
        }

        //d
        [TestMethod]
        public void BuscarPorTurno()
        {
            var dbContext = new BaseDeDados();

            var porTurno = dbContext.BuscarPorTurno(TurnoTrabalho.Noite, TurnoTrabalho.Manha, TurnoTrabalho.Tarde);

            //Deve haver todos funcionarios
            Assert.IsTrue(porTurno.Count == 11);
        }

        //e
        [TestMethod]
        public void QtdFuncionariosPorTurnoTest()
        {
            var bbContext = new BaseDeDados();
            var list = bbContext.QtdFuncionariosPorTurno();

            Assert.IsTrue(list[0].ToString() == "{ Turno = Manha, Quantidade = 5 }");
            Assert.IsTrue(list[1].ToString() == "{ Turno = Tarde, Quantidade = 4 }");
            Assert.IsTrue(list[2].ToString() == "{ Turno = Noite, Quantidade = 2 }");
        }

        //f
        [TestMethod]
        public void BuscarPorCargo()
        {
            var dbContext = new BaseDeDados();

            var porCargo = dbContext.BuscarPorCargo(new Cargo("Desenvolvedor", 190));

            //Deve haver 8 funcionarios Desenvolvedor
            Assert.IsTrue(porCargo.Count == 8);
        }

        //g
        [TestMethod]
        public void FiltrarPorIdadeAproximada25()
        {
            var dbContext = new BaseDeDados();

            var idadeAproximadamente = dbContext.FiltrarPorIdadeAproximada(25);

            //Deve haver 7 nascidos de 1985 a 1995, pois o ano da idade informada é 1990
            Assert.IsTrue(idadeAproximadamente.Count == 7);
        }

        //g
        [TestMethod]
        public void FiltrarPorIdadeAproximada35()
        {
            var dbContext = new BaseDeDados();

            var idadeAproximadamente = dbContext.FiltrarPorIdadeAproximada(35);

            //Deve haver 1 nascido entre 1975 a 1990, pois o ano da idade informada é 1980
            Assert.IsTrue(idadeAproximadamente.Count == 1);
        }

        //i
        [TestMethod]
        public void AniversariantesDoMes()
        {
            var dbContext = new BaseDeDados();

            var aniverDoMes = dbContext.AniversariantesDoMes();

            //Deve haver 1 aniversariante do mes 10
            Assert.IsTrue(aniverDoMes.Count == 1);
        }
    }
}
