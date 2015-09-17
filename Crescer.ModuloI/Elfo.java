import java.util.Formatter;

public class Elfo
{
    private String nome;
    private int flechas;
    private int exp;
    private Status status;
    
    public Elfo(String n)
    {
        this.nome = n;
        this.flechas = 42;
        this.exp = 0;
        this.status = Status.VIVO;
    }
    
    public Elfo(String n, int flecha)
    {
        this.nome = n;
        this.flechas = flecha;
        this.exp = 0;
        this.status = Status.VIVO;
    }
    
        public String getNome()
    {
        return this.nome;
    }
    
    public int getFlechas()
    {
        return this.flechas;
    }
    
    public int getExp()
    {
        return this.exp;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    /*public void setFleach(int num)
    {
        if (num > this.flechas)
            this.flechas = num;
    }*/
    
    public void atirarFlechas(Dwarf dwarf)
    {
        if (this.flechas > 0)
        {
            this.flechas--;
            dwarf.receberFlechada();
            this.exp++;
            return;
        }
        
        System.out.println("Sem flechas");
    }
    
    public String toString()
    {
      
        boolean ehPluralFlechas = this.flechas != 1;
        boolean ehPluralNiveis = this.exp != 1;
        
        String txtFlechas = ehPluralFlechas ? "flechas" : "flecha";
        String txtNiveis = ehPluralNiveis ? "níveis" : "nível";
            
        String result = String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, txtFlechas, this.exp, txtNiveis);
        return result;
    }
    

    
}
