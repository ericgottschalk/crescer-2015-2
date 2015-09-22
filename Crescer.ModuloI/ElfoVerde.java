
public class ElfoVerde extends Elfo
{
   public ElfoVerde(String nome)
   {
       super(nome);
   }
   
   public ElfoVerde(String nome, int flechas)
   {
       super(nome, flechas);
   }
   
   @Override
   public void adicionarItem(Item item)
   {
       if (item.getDescricao().equals("Espada de aço valiriano") || item.getDescricao().equals("Arco e Flecha de Vidro"))
            this.inventario.adicionarItem(item);
   }
   
   @Override
   public void atirarFlechas(Dwarf dwarf)
   {
       if (this.flechas > 0)
       {
           this.flechas--;
           dwarf.receberFlechada();
           this.exp += 2;
           return;
       }
   }
    
   @Override
   public void atirarFlechas(Orc orc)
   {
       if (this.flechas > 0)
       {
           this.flechas--;
           orc.receberAtaqueDeElfo();
           this.exp += 2;
           return;
       }
   }
}
