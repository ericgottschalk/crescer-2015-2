using Locadora.Dominio.Servicos;
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
            var encode = new UTF8Encoding();
            byte[] byteTexto = encode.GetBytes(texto);
            SHA512Managed sha = new SHA512Managed();
            byte[] hash = sha.ComputeHash(byteTexto);
            var criptografado = new StringBuilder();

            foreach (var b in hash)
            {
                criptografado.Append((Char)b);
            }

            return criptografado.ToString();
        }
    }
}
