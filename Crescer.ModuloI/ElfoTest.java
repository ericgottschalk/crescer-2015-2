

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class ElfoTest
{
    @Test
    public void craicaoElfo()
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
    public void elfoComNomeNull()
    {
        Elfo elf = new Elfo(null);
        assertNull(elf.getNome());
    }
   
    @Test
    public void elfoComNomeVazio()
    {
        Elfo elf = new Elfo("");
        assertTrue(elf.getNome().isEmpty());
    }
    @Test
    public void atirarFlechas()
    {
        Elfo elfo = new Elfo("Test atirar");
        int exp = elfo.getExp() + 1;
        int flechas = elfo.getFlechas() - 1;
        
        elfo.atirarFlechas(new Dwarf());
        
        assertEquals(flechas, elfo.getFlechas());
        assertEquals(exp, elfo.getExp());
        
    }
    
    @Test
    public void atirarFlechasEmDwarf()
    {
        Elfo elfo = new Elfo("Elfo");
        Dwarf dwarf = new Dwarf();
        int flechasElfoEsperadas = 41;
        int expElfoEsperada = 1;
        int hpDwarfEsperada = 100;
        
        elfo.atirarFlechas(dwarf);
        
        assertEquals(flechasElfoEsperadas, elfo.getFlechas());
        assertEquals(expElfoEsperada, elfo.getExp());
        assertEquals(hpDwarfEsperada, dwarf.getHp());
    }
    
    @Test
    public void metodoToString()
    {
        Elfo elfo = new Elfo("Legolas");
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfo.toString());
    }
}
