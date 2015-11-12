using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public string Descricao { get; set; }

        public Categoria Categoria { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }

        public bool Available { get; set; }
        
        public Jogo()
        {

        }

        public Jogo(int id, bool disponivel)
        {
            this.Id = id;
            this.Available = disponivel;
        }

        public void AlterarDisponibilidade(bool disponivel)
        {
            this.Available = disponivel;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);
            builder.AppendLine("Selo: " + this.Selo);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if(obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.Available == jogoComp.Available
                    && this.Selo == jogoComp.Selo;
            }

            return false;
        }
    }
}
