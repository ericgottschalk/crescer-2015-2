using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Repositorio
{
    public interface IJogoRepositorio : IRepositorio<Jogo>
    {
        IList<Jogo> BuscarDisponiveis();

        IList<Jogo> BuscarIndisponiveis();

        IList<Jogo> BuscarPorNome(string nome);
    }
}
