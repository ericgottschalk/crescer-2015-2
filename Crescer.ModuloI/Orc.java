

public class Orc extends Personagem
{
    public Orc(String nome, int hp)
    {
        super(nome, hp);
        this.status = Status.VIVO;
    }
    
    public boolean podeAtacarEspada()
    {
        return (this.inventario.pesquisarItem("Espada") != null) ? true : false;
    }
    
    public boolean podeAtacarArco()
    {
        return (this.inventario.pesquisarItem("Arco") != null && this.inventario.pesquisarItem("Flecha").getQuantidade() > 0) 
                ? true : false; 
    }
    
    public int getDanoAtaque()
    {
        if (this.podeAtacarEspada())
            return 12;         
            
        if (this.podeAtacarArco())
            return 8;
            
        return 0;
    }
    
    public void receberAtaque()
    {
        if (this.status == Status.MORTO)
             return;
        
        this.hp -= this.inventario.pesquisarItem("Escudo Uruk-Hai") == null ? 10 : 6;
        this.verificarVida();
    }
    
    
    public void realizarAtaque(Personagem p)
    {
       int dano = this.getDanoAtaque();
       if (dano == 0)
       {
           this.status = Status.FUGINDO;
           return;
       }
       
       p.receberAtaqueOrc(this);
       
       if(dano == 8)
       {
           Item itm = this.inventario.pesquisarItem("Flecha");
           itm.perderUmaUnidade();
       }
    }    
    
    @Override
    public void receberAtaqueOrc(Orc or)
    {
        this.receberAtaque();
    }
}