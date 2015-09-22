import java.util.Random;

public class Orc
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected String nome;
    protected int hp;
    protected Inventario inventario;
    protected Status status;

    public Orc(String nome, int hp)
    {
        this.nome = nome;
        this.hp = hp;
        this.inventario = new Inventario();
        this.status = Status.VIVO;
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
   
    public void adicionarItem(Item itm) 
    {
        this.inventario.adicionarItem(itm);
    }
    
    public void receberAtaqueDeElfo()
    {
        if (this.status == Status.MORTO)
             return;
        
        this.hp -= 8;   
          
        if (this.hp <= 0)
            this.status = Status.MORTO;
    }
    
    public void receberAtaqueDeDwarf() 
    {
        if (this.status == Status.MORTO)
            return;
            
        if (this.inventario.pesquisarItem("Escudo Uruk-Hai") != null)
            this.hp -= 5;
        else
            this.hp -= 10;
            
        if (this.hp <= 0)
            this.status = Status.MORTO;
    }
    
    public void realizarAtaque(Elfo elfo)
    {
        int danoEspada = 12, danoArco = 8;
        
        if (this.inventario.pesquisarItem("Espada") != null)
        {
            elfo.receberAtaqueOrc(danoEspada);
            return;
        } 
            
        if (this.inventario.pesquisarItem("Arco") != null)
        {
            if (this.inventario.pesquisarItem("Flecha").getQuantidade() > 0)
                elfo.receberAtaqueOrc(danoArco);
        }
        
        this.status = Status.FUGINDO;
    }
    
    public void realizarAtaque(Dwarf dwarf) 
    {
    int danoEspada = 12, danoArco = 8;
        
        if (this.inventario.pesquisarItem("Espada") != null)
        {
            dwarf.receberAtaqueOrc(danoEspada);
            return;
        } 
            
        if (this.inventario.pesquisarItem("Arco") != null)
        {
            if (this.inventario.pesquisarItem("Flecha").getQuantidade() > 0)
                dwarf.receberAtaqueOrc(danoArco);
        }
        
        this.status = Status.FUGINDO;
    }
    
}