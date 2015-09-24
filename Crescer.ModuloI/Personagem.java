

public abstract class Personagem
{
    protected final String nome;
    protected int exp;
    protected int hp;
    protected Status status;
    protected final Inventario inventario;
    
    public Personagem(String nome, int hp)
    {
        this.nome = nome;
        this.hp = hp;
        this.exp = 0;
        this.status = Status.VIVO;
        this.inventario = new Inventario();
    }
      
    public String getNome()
    {
        return this.nome;
    }
    
    public int getExp()
    {
        return this.exp;
    }
    
    public int getHp()
    {
        return this.hp;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public void adicionarItem(Item item)
    {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item)
    {
        this.inventario.perderItem(item);
    }
    
    public void verificarVida()
    {
        if (this.hp <= 0)
            this.status = Status.MORTO;
    }
    
    public void receberAtaqueOrc(Orc orc)
    {
        if (this.hp > 0)
        {
            this.hp -= orc.getDanoAtaque();
        }
        
        if (this.hp <= 0)
            this.status = Status.MORTO;
    }
}
