using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Comum
{
    public interface IRepositorio<TEntity> where TEntity : EntidadeBase
    {
        int Criar(TEntity item);
        int Atualizar(TEntity item);
        int Excluir(int id);
        TEntity BuscarPorId(int id);
        IList<TEntity> Buscar(params IQuery<TEntity>[] queries);
    }
}
