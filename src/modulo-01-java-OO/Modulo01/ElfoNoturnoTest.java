

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoNoturnoTest
{
    @Test 
    public void atacarEPerderVida()
    {
        Elfo e = new ElfoNoturno("");
        
        e.atirarFlechas(new Dwarf(""));
        
        assertEquals(95, e.getHp());
    }
    
    @Test
    public void atacarEPerderVidaDuasVezes()
    {
        Elfo e = new ElfoNoturno("");
        
        e.atirarFlechas(new Dwarf(""));
        e.atirarFlechas(new Dwarf(""));
        
        assertEquals(90, e.getHp());
    }
    
    @Test
    public void atacarAteMorrer()
    {
        Elfo e = new ElfoNoturno("", 1000);
        
        for (int i = 0; i < 50; i++)
            e.atirarFlechas(new Dwarf(""));
        
        assertEquals(0, e.getHp());
    }
}
