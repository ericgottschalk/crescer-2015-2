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
    
    public String getDescricoesItens()
    {   
        String descricao = new String();
        
        for (Item item : itens)
            descricao += item.getDescricao() + ",";
            
        return descricao.substring(0, descricao.length() - 1);
    }
    
    public Item getItemComMaiorQuantidade()
    {
        Item itm = new Item("", 0);
        
        for (Item item : this.itens)
            if (item.getQuantidade() > itm.getQuantidade())
                itm = item;
                
        return itm;
    }
    
    public Item pesquisarItem(String name)
    {
        for (Item item : this.itens)
            if (name.equals(item.getDescricao()))
                return item;
        
        return null;
    }
    
    public void ordenarInventario()
    {
        Item temp = null;
        int j;
        
        for (int i = 0; i < this.itens.size(); i++)
        {
            for (j = 0; j < this.itens.size(); j++)
            {
                if (this.itens.get(i).getQuantidade() < this.itens.get(j).getQuantidade())
                {
                    temp = this.itens.get(i);
                    this.itens.set(i, this.itens.get(j));
                    this.itens.set(j, temp);
                }
            }
            
            j = i;
        }
    }
}