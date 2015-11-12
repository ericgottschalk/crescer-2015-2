using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {
        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {
            Jogo jogoA = new Jogo(id: 1, disponivel: true);
            Jogo jogoB = new Jogo(id: 1, disponivel: true);

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo(1, false);

            jogo.AlterarDisponibilidade(true);

            Assert.AreEqual(true, jogo.Available);
        }
    }
}
