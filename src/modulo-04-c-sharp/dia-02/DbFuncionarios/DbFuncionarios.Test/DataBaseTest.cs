using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using DbFuncionarios;

namespace DbTest
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void OrdernarPorNome()
        {
            var dbContext = new BaseDeDados();

            var arnold = dbContext.BuscarPorNome("nold");

            //Deve haver 1 funcionario na lista
            Assert.IsTrue(arnold.Count == 1);
        }

        [TestMethod]
        public void BuscarPorTurno()
        {
            var dbContext = new BaseDeDados();

            var porTurno = dbContext.BuscarPorTurno(TurnoTrabalho.Noite, TurnoTrabalho.Manha, TurnoTrabalho.Tarde);

            //Deve haver todos funcionarios
            Assert.IsTrue(porTurno.Count == 11);
        }

        [TestMethod]
        public void BuscarPorCargo()
        {
            var dbContext = new BaseDeDados();

            var porCargo = dbContext.BuscarPorCargo(new Cargo("Desenvolvedor", 190));

            //Deve haver todos funcionarios
            Assert.IsTrue(porCargo.Count == 8);
        }

        [TestMethod]
        public void FiltrarPorIdadeAproximada25()
        {
            var dbContext = new BaseDeDados();

            var idadeAproximadamente = dbContext.FiltrarPorIdadeAproximada(25);

            //Deve haver 7 nascidos de 1985 a 1995, pois o ano da idade informada é 1990
            Assert.IsTrue(idadeAproximadamente.Count == 7);
        }

        [TestMethod]
        public void FiltrarPorIdadeAproximada35()
        {
            var dbContext = new BaseDeDados();

            var idadeAproximadamente = dbContext.FiltrarPorIdadeAproximada(35);

            //Deve haver 1 nascido entre 1975 a 1990, pois o ano da idade informada é 1980
            Assert.IsTrue(idadeAproximadamente.Count == 1);
        }

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
