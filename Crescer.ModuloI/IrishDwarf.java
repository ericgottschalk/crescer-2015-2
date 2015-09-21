
public class IrishDwarf 
{
   private String nome;
    private int hp;  
    private int exp;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario;
    
    public IrishDwarf(String n)
    {
        this.nome = n;
        this.hp = 110;
        this.status = Status.VIVO;
        this.exp = 0;
        this.inventario = new Inventario();
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public IrishDwarf(String n, DataTerceiraEra data)
    {
        this(n);
        this.dataNascimento = data;
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
                item.adicionarMilUnidadesLikeABoss();
        }
    }
}
