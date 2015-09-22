public class Dwarf extends Personagem
{
    protected DataTerceiraEra dataNascimento;
    
    public Dwarf(String n)
    {
        super(n, 110);
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public Dwarf(String n, DataTerceiraEra data)
    {
        super(n, 110);
        this.dataNascimento = data;
    }
    
    public void realizarAtaque(Orc orc)
    {
        orc.receberAtaqueDeDwarf(); 
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
    
    public DataTerceiraEra getDataNascimento()
    {
        return  this.dataNascimento;
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