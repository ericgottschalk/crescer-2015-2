import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens;
    
    public Inventario()
    {
        this.itens = new ArrayList<Item>();
    }
    
    public void adicionarItem(Item item)
    {
        this.itens.add(item);
    }
    
    public void perderItem(Item item)
    {
        if (this.itens.contains(item))
            this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens()
    {
        return this.itens;
    }
    
    public Item getItem(int index)
    {
        return this.itens.get(index);
    }
    
    public String getDescricoesItens()
    {   
        String descricao = new String();
        
        for (Item item : itens)
            descricao += item.getDescricao() + ",";
            
        return descricao;
    }
    
    public Item getItemComMaiorQuantidade()
    {
        Item itm = new Item("", 0);
        
        for (Item item : this.itens)
            if (item.getQuantidade() > itm.getQuantidade())
                itm = item;
                
        return itm;
    }
    
    public void ordenarInventario()
    {
        Item temp = null;
        
        for (int i = 0; i < this.itens.size(); i++)
            for (int j = 0; j < this.itens.size(); j++)
            {
                if (this.getItem(i).getQuantidade() < this.getItem(j).getQuantidade())
                {
                    temp = this.getItem(i);
                    this.itens.set(i, this.getItem(j));
                    this.itens.set(j, temp);
                }
            }
    }
}