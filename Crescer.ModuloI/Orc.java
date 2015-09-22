

public class Orc extends Personagem
{
    public Orc(String nome, int hp)
    {
        super(nome, hp);
        this.inventario = new Inventario();
        this.status = Status.VIVO;
    }
    
    private void perderFlecha(Item item)
    {
        int temp = this.inventario.getItens().indexOf(item);
        this.inventario.getItens().set(temp, new Item("Flecha", item.getQuantidade() - 1));
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
            Item flechas = this.inventario.pesquisarItem("Flecha");
            if (flechas.getQuantidade() > 0)
            {
                elfo.receberAtaqueOrc(danoArco);
                this.perderFlecha(flechas);
                return;
            }
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
            Item flechas = this.inventario.pesquisarItem("Flecha");
            if (flechas.getQuantidade() > 0)
            {
                dwarf.receberAtaqueOrc(danoArco);
                this.perderFlecha(flechas);
                return;
            }
        }
        
        this.status = Status.FUGINDO;
    }    
}