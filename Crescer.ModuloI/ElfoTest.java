

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void testeCraicaoElfo()
    {
        Elfo elf = new Elfo("Test sem flechas");
        assertEquals(42, elf.getFlechas());
        assertEquals("Test sem flechas", elf.getNome());
        assertEquals(0, elf.getExp());
        
        Elfo elfo = new Elfo("Test com flechas", 10);
        assertEquals(10, elfo.getFlechas());
        assertEquals("Test com flechas", elfo.getNome());
        assertEquals(0, elfo.getExp());
    }
    
    @Test
    public void testeAtirarFlechas()
    {
        Elfo elfo = new Elfo("Test atirar");
        int exp = elfo.getExp();
        int flechas = elfo.getFlechas();
        elfo.atirarFlechas(new Dwarf());
        
        assertEquals((flechas - 1), elfo.getFlechas());
        assertEquals((exp + 1), elfo.getExp());
        
    }
}
