import java.util.Formatter;
import java.util.ArrayList;

public class Elfo
{
    private String nome;
    private int flechas;
    private int exp;
    private int hp;
    private Status status;
    
    public Elfo(String n)
    {
        this.nome = n;
        this.flechas = 42;
        this.exp = 0;
        this.hp = 80;
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
    
    public int getHp()
    {
        return this.hp;
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
    
    @Override
    public String toString()
    {
        String txtFlechas = this.flechas != 1 ? "flechas" : "flecha";
        String txtNiveis = this.exp != 1 ? "níveis" : "nível";
            
        return String.format("%s possui %d %s e %d %s de experiência.", this.nome, this.flechas, txtFlechas, this.exp, txtNiveis);
    }
    

    
}
