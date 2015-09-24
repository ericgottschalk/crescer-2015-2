import java.util.Formatter;
import java.util.ArrayList;

public class Elfo extends Personagem
{
    protected int flechas;
    private static int contador = 0;

    public Elfo(String n)
    {
        super(n, 100);
        this.flechas = 42;
		this.contador++;
    }
    
    public Elfo(String n, int flecha)
    {
        this(n);
        this.flechas = flecha;
    }
    
	public static int getContador()
	{
		return contador;
	}

	public static void zerarContador()
	{
		contador = 0;
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
        }

    }
    
    public void atirarFlechas(Orc orc)
    {
        if (this.flechas > 0)
        {
            this.flechas--;
            orc.receberAtaque();
            this.exp++;
        }
    }
    
    @Override
    public int hashCode()
    {
        return this.nome.hashCode() + this.inventario.hashCode();
    }
    
    @Override
    public boolean equals(Object obj)
    {
        return ((Elfo) obj).getNome().equals(this.nome);
    }
    
    @Override
    public String toString()
    {
        String txtFlechas = this.flechas != 1 ? "flechas" : "flecha";
        String txtNiveis = this.exp != 1 ? "níveis" : "nível";
            
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, txtFlechas, this.exp, txtNiveis);
    }
}
