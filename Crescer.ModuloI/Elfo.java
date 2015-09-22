import java.util.Formatter;
import java.util.ArrayList;

public class Elfo extends Personagem
{
    protected int flechas;
    
    public Elfo(String n)
    {
        super(n, 80);
        this.flechas = 42;
    }
    
    public Elfo(String n, int flecha)
    {
        this(n);
        this.flechas = flecha;
    }
    
    public int getFlechas()
    {
        return this.flechas;
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

    }
    
    public void atirarFlechas(Orc orc)
    {
        if (this.flechas > 0)
        {
            this.flechas--;
            orc.receberAtaqueDeElfo();
            this.exp++;
            return;
        }
    }
    
    @Override
    public String toString()
    {
        String txtFlechas = this.flechas != 1 ? "flechas" : "flecha";
        String txtNiveis = this.exp != 1 ? "níveis" : "nível";
            
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, txtFlechas, this.exp, txtNiveis);
    }
}
