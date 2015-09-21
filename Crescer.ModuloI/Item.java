
public class Item
{
    private String descricao;
    private int quantidade;
    
    public Item(String desc, int quant)
    {
        this.descricao = desc;
        this.quantidade = quant;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public void adicionarMilUnidades()
    {
        this.quantidade += 1000;
    }
    
    public void adicionarUnidadesLikeABoss()
    { 
        int pa = (this.quantidade * (this.quantidade + 1)) / 2;
        this.quantidade += 1000 * pa;
    }
    
    @Override
    public boolean equals(Object obj)
    {
        Item itm = (Item) obj;
        
        return (this.descricao.equals(itm.getDescricao())) && (this.quantidade == itm.getQuantidade());
    }
}

