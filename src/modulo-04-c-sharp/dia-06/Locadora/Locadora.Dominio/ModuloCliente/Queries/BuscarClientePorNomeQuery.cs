﻿using Locadora.Dominio.Comum;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.ModuloCliente.Queries
{
    public class BuscarClientePorNomeQuery : IQuery<Cliente>
    {
        private readonly string nome;

        public BuscarClientePorNomeQuery(string nome)
        {
            this.nome = nome;
        }

        public IQueryable<Cliente> CriarQuery(IQueryable<Cliente> src)
        {
            return src.Where(t => t.Nome == this.nome);
        }
    }
}
