using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleApp;

namespace ConsoleApp.Test
{
    [TestClass]
    public class TesteAgenda
    {
        [TestMethod]
        public void AdicionarUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato("Test", 82374643);

            agenda.AdicionarContato(contato);

            Assert.IsTrue(agenda.Count == 1);
        }

        [TestMethod]
        public void RemoverUmContatoPorNome()
        {
            var agenda = new Agenda();
            var contato = new Contato("Test", 209381);
            agenda.AdicionarContato(contato);

            agenda.RemoverContatos("Test");

            Assert.IsTrue(agenda.Count == 0);
        }

        [TestMethod]
        public void RemoverUmContatoPorNumero()
        {
            var agenda = new Agenda();
            var contato = new Contato("Test", 209381);
            agenda.AdicionarContato(contato);

            agenda.RemoverContatos(209381);

            Assert.IsTrue(agenda.Count == 0);
        }
    }
}
