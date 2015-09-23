

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SnagaOrcOrcTest
{
    @Test
    public void atacarElfoArco()
    {
         Orc orc = new SnagaOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         orc.realizarAtaque(elfo);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(72, elfo.getHp());
         assertEquals(4, flecha.getQuantidade());
    }
    
    @Test
    public void atacarElfoArcoDuasVezes()
    {
         Orc orc = new SnagaOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         orc.realizarAtaque(elfo);
         orc.realizarAtaque(elfo);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(64, elfo.getHp());
         assertEquals(3, flecha.getQuantidade());
    }
    
    @Test
    public void atacarElfoArcoAcabarFlechasEFugir()
    {
         Orc orc = new SnagaOrc("");
         Elfo elfo = new Elfo("Elfinho");
         
         for (int i = 0; i < 6; i++)
            orc.realizarAtaque(elfo);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(40, elfo.getHp());
         assertEquals(0, flecha.getQuantidade());
         assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void atacarDwarfArco()
    {
         Orc orc = new SnagaOrc("");
         Dwarf d = new Dwarf("");
         
         orc.realizarAtaque(d);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(102, d.getHp());
         assertEquals(4, flecha.getQuantidade());
    }
    
    @Test
    public void atacarDwarfArcoDuasVezes()
    {
         Orc orc = new SnagaOrc("");
         Dwarf d = new Dwarf("");
         
         orc.realizarAtaque(d);
         orc.realizarAtaque(d);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(94, d.getHp());
         assertEquals(3, flecha.getQuantidade());
    }
    
    @Test
    public void atacarDwarfArcoAteAcabarFlechas()
    {
         Orc orc = new SnagaOrc("");
         Dwarf d = new Dwarf("");
         
         for (int i = 0; i < 120; i++)
            orc.realizarAtaque(d);
         
         Item flecha = orc.getInventario().pesquisarItem("Flecha");
         assertEquals(70, d.getHp());
         assertEquals(0, flecha.getQuantidade());
         assertEquals(Status.FUGINDO, orc.getStatus());
    }
    
    @Test
    public void receberAtaqueElfo()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new SnagaOrc("");
        
        elfo.atirarFlechas(orc);
        
        assertEquals(60, orc.getHp());
    }
    
    @Test
    public void receberAtaqueElfoAteMorrer()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new SnagaOrc("");
        
        for (int i = 0; i < 20; i++)
            elfo.atirarFlechas(orc);
        
        assertEquals(Status.MORTO, orc.getStatus());
    }
    
    @Test
    public void receberAtaqueDwarf()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new SnagaOrc("");
        
        d.realizarAtaque(orc);
        
        assertEquals(60, orc.getHp());
    }
    
    @Test
    public void receberAtaqueDwarfDuasVezes()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new SnagaOrc("");
        
        d.realizarAtaque(orc);
        d.realizarAtaque(orc);
        
        assertEquals(50, orc.getHp());
    }
    
    @Test
    public void receberAtaqueDwarfAteMorrer()
    {
        Dwarf d = new Dwarf("");
        Orc orc = new SnagaOrc("");
        
        for(int i = 0; i < 30; i++)
            d.realizarAtaque(orc);
        
        assertEquals(Status.MORTO, orc.getStatus());
    }
}
