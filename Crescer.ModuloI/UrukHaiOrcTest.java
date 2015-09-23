

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UrukHaiOrcTest
{
    @Test
    public void atacarElfoEspada()
    {
         Orc orc = new UrukHaiOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         orc.realizarAtaque(elfo);
         
         assertEquals(88, elfo.getHp());
    }
    
    @Test
    public void atacarElfoEspadaDuasVezes()
    {
         Orc orc = new UrukHaiOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         orc.realizarAtaque(elfo);
         orc.realizarAtaque(elfo);
         
         assertEquals(76, elfo.getHp());
    }
    
    @Test
    public void atacarElfoEspadaAteMatar()
    {
         Orc orc = new UrukHaiOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         for (int i = 0; i < 12; i++)
            orc.realizarAtaque(elfo);
         
         assertEquals(Status.MORTO, elfo.getStatus());
    }
    
    @Test
    public void atacarDwarfEspada()
    {
         Orc orc = new UrukHaiOrc("");
         Dwarf d = new Dwarf("");
         
         orc.realizarAtaque(d);
         
         assertEquals(98, d.getHp());
    }
    
    @Test
    public void atacarDwarfEspadaDuasVezes()
    {
         Orc orc = new UrukHaiOrc("");
         Dwarf d = new Dwarf("");
         
         orc.realizarAtaque(d);
         orc.realizarAtaque(d);
         
         assertEquals(86, d.getHp());
    }
    
    @Test
    public void atacarDwarfEspadaAteMatar()
    {
         Orc orc = new UrukHaiOrc("");
         Dwarf d = new Dwarf("");
         
         for (int i = 0; i < 12; i++)
            orc.realizarAtaque(d);
         
         assertEquals(Status.MORTO, d.getStatus());
    }
    
    @Test
    public void receberAtaqueElfo()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new UrukHaiOrc("");
        
        elfo.atirarFlechas(orc);
        
        assertEquals(144, orc.getHp());
    }
    
    @Test
    public void receberAtaqueElfoAteMorrer()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new UrukHaiOrc("");
        
        for (int i = 0; i < 31; i++)
            elfo.atirarFlechas(orc);
        
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void receberAtaqueDwarf()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new UrukHaiOrc("");
        
        d.realizarAtaque(orc);
        
        assertEquals(144, orc.getHp());
    }
    
    @Test
    public void receberAtaqueDwarfDuasVezes()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new UrukHaiOrc("");
        
        d.realizarAtaque(orc);
        d.realizarAtaque(orc);
        
        assertEquals(138, orc.getHp());
    }
    
    @Test
    public void receberAtaqueDwarfAteMorrer()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new UrukHaiOrc("");
        
        for(int i = 0; i < 40; i++)
            d.realizarAtaque(orc);
        
        assertEquals(Status.MORTO, orc.getStatus());
    }
}
