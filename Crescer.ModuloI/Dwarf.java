public class Dwarf
{
    protected String nome;
    protected int hp;  
    protected int exp;
    protected Status status;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;
    
    public Dwarf(String n)
    {
        this.nome = n;
        this.hp = 110;
        this.status = Status.VIVO;
        this.exp = 0;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public Dwarf(String n, DataTerceiraEra data)
    {
        this(n);
        this.dataNascimento = data;
    }
    
    public void realizarAtaque(Orc orc)
    {
        orc.receberAtaqueDeDwarf(); 
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
    
    public void receberFlechada()
    {
        if ((this.hp > 0))
        {
            double num = this.getNumeroSorte();
            
            if(num < 0)
            {
                this.exp += 2;
                return;
            }
            
            if (num <= 100)
                return;
                
            this.hp -= 10;
        }
        
        if (this.hp == 0)
            this.status = Status.MORTO;
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
    
    public DataTerceiraEra getDataNascimento()
    {
        return  this.dataNascimento;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public void adicionarItem(Item item)
    {
        this.inventario.adicionarItem(item);
    }
    
    public double getNumeroSorte()
    {
        double numeroSorte = 101.0;
        
        if ((this.dataNascimento.ehBissexto()) && (this.hp >= 80 && this.hp <= 90))
            return numeroSorte * -33;
             
        if ((!this.dataNascimento.ehBissexto()) && (this.nome != null && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))))
            return (numeroSorte * 33) % 100;
        
        return numeroSorte;
    }
    
    public void tentarSorte()
    {
        if (this.getNumeroSorte() == -3333.0)
        {
            for (Item item : this.inventario.getItens())
                item.adicionarMilUnidades();
        }
    }
}