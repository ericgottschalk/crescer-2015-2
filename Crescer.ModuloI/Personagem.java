

public class Personagem
{
    protected String nome;
    protected int exp;
    protected int hp;
    protected Status status;
    protected Inventario inventario;
    
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
    
    public void receberAtaqueOrc(int dano)
    {
        if (this.hp > 0)
        {
            if (dano == 12 || dano == 8)
                this.hp -= dano;
        }
        
        if (this.hp <= 0)
            this.status = Status.MORTO;
    }
}
