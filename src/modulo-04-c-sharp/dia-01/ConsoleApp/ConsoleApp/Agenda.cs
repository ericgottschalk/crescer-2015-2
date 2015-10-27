using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp
{
    public class Agenda
    {
        private List<Contato> contatos = new List<Contato>();
        public int Count
        {
            get
            {
                return this.contatos.Count;
            }
        }

        public void AdicionarContato(Contato contato)
        {
            this.contatos.Add(contato);
        }

        public void RemoverContatos(string nome)
        {
            //this.contatos.RemoveAll(t => t.Nome == nome);

            var removerContatos = new List<Contato>();

            foreach (var contato in this.contatos)
            {
                if (contato.Nome == nome)
                    removerContatos.Add(contato);
            }

            foreach (var contato in removerContatos)
            {
                this.contatos.Remove(contato);
            }
        }

        public void RemoverContatos(int numero)
        {
            this.contatos.RemoveAll(t => t.Numero == numero);
        } 

        public string Listar()
        {
            string contatos = "";
            foreach(var contato in this.contatos)
            {
                contatos += contato.Nome + " - " + contato.Numero + "\n";
            }

            return contatos;
        }

        public string ListarOrdenandoPorNome()
        {
            string contatosOrdenados = "";
            for(int i = 0; i < this.Count; i++)
            {
                for (int j = 0; j < this.Count; j++)
                {
                    if (this.contatos[i].Nome.CompareTo(this.contatos[j].Nome) < 0)
                    { 
                        var temp = this.contatos[i];
                        this.contatos[i] = this.contatos[j];
                        this.contatos[j] = temp;
                    }
                }
            }

            foreach(var contato in this.contatos)
            {
                contatosOrdenados += contato.Nome + " - " + contato.Numero + "\n";
            }

            return contatosOrdenados;
        }
    }
}
