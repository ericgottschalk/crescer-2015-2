﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Permissao : EntidadeBase
    {
        public string Texto { get; set; }

        public ICollection<Usuario> Usuarios { get; set; }
    }
}
