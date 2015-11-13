using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloLocacao
{
    public class BuscarLocacaoEntregueQuery : IQuery<Locacao>
    {
        public IQueryable<Locacao> CriarQuery(IQueryable<Locacao> src)
        {
            return src.Where(t => t.Status == StatusLocacao.ENTREGUE);
        }
    }
}
