import java.util.Formatter;
import java.util.ArrayList;

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
        this(n);
        this.flechas = flecha;
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
    
    @Override
    public String toString()
    {
        String txtFlechas = this.flechas != 1 ? "flechas" : "flecha";
        String txtNiveis = this.exp != 1 ? "níveis" : "nível";
            
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, txtFlechas, this.exp, txtNiveis);
    }
    

    
}
