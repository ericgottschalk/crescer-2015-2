
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EstrategiaDeGuerraTest
{   
    @Test
    public void atacarHordaDwarvesEstrategiaDeGuerraNoturnosAtacam30Porc10Elfos()
    {
        ExercitoElfos e = new ExercitoElfos();
        e.trocarDeEstrategia(new EstrategiaDeGuerra());
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        int limiteAtaque = (int)(10 * 0.3);
        
        for (int i = 0; i < 10; i++)
            e.alistarElfo(new ElfoNoturno("Elfo " + i));
        
        Dwarf d = new Dwarf("Alvo");
        alvo.add(d);
        
        e.atacarHordaDwarves(alvo);
        
        assertEquals(limiteAtaque, e.getOrdemDoUltimoAtaque().size());      
        assertEquals(80, d.getHp());
    }
    
    @Test
    public void atacarHordaDwarvesEstrategiaDeGuerraNoturnosAtacam30Porc50Elfos()
    {
        ExercitoElfos e = new ExercitoElfos();
        e.trocarDeEstrategia(new EstrategiaDeGuerra());
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        int limiteAtaque = (int)(50 * 0.3);
        
        for (int i = 0; i < 50; i++)
            e.alistarElfo(new ElfoNoturno("Elfo " + i));
        
        Dwarf d = new Dwarf("Alvo");
        alvo.add(d);
        
        e.atacarHordaDwarves(alvo);
        
        assertEquals(limiteAtaque, e.getOrdemDoUltimoAtaque().size());      
        assertEquals(0, d.getHp());
    }
    
    @Test
    public void atacarHordaDwarvesEstrategiaDeGuerraNoturnosAtacam30Porc100Elfos()
    {
        ExercitoElfos e = new ExercitoElfos();
        e.trocarDeEstrategia(new EstrategiaDeGuerra());
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        int limiteAtaque = (int)(100 * 0.3);
        
        for (int i = 0; i < 100; i++)
            e.alistarElfo(new ElfoNoturno("Elfo " + i));
        
        Dwarf d = new Dwarf("Alvo");
        alvo.add(d);
        
        e.atacarHordaDwarves(alvo);
        
        assertEquals(limiteAtaque, e.getOrdemDoUltimoAtaque().size());      
        assertEquals(0, d.getHp());
    }
}
