﻿using Locadora.Dominio.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Infraestrutura.Services
{
    public class Criptografia : ICriptografia
    {
        public string Criptografar(string texto)
        {
            MD5 md5 = MD5.Create();

            byte[] inputBytes = Encoding.ASCII.GetBytes(texto + "%$LOCADORA_CWI_CRESCER$%");
            byte[] hash = md5.ComputeHash(inputBytes);
            var criptografado = new StringBuilder();

            foreach (var b in hash)
            {
                criptografado.Append(b.ToString("X2"));
            }

            return criptografado.ToString();
        }
    }
}
