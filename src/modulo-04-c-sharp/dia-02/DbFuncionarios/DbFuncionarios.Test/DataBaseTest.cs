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
        public void BuscaRapida()
        {
            var dbContext = new BaseDeDados();

            var carlos = dbContext.BuscaRapida("Carlos Henrique");

            //Deve haver 1 retorno
            Assert.IsTrue(carlos.Count == 1);
        }

        [TestMethod]
        public void BuscarPorTurno()
        {
            var dbContext = new BaseDeDados();

            var porTurno = dbContext.BuscarPorTurno(TurnoTrabalho.Noite, TurnoTrabalho.Manha, TurnoTrabalho.Tarde);

            //Deve haver todos funcionarios
            Assert.IsTrue(porTurno.Count == 11);
        }
    }
}
