

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ElfoVerdeTest
{
    @Test
    public void adicionarItemValido()
    {
        Elfo elfo = new ElfoVerde("");
        
        elfo.adicionarItem(new Item("Espada de aço valiriano", 1));
        
        assertNotNull(elfo.getInventario().pesquisarItem("Espada de aço valiriano"));
    }
    
    @Test
    public void adicionarItemValidoAgain()
    {
        Elfo elfo = new ElfoVerde("");
        
        elfo.adicionarItem(new Item("Arco e Flecha de Vidro", 1));
        
        assertNotNull(elfo.getInventario().pesquisarItem("Arco e Flecha de Vidro"));
    }
    
    @Test
    public void adicionarItemInvalido()
    {
        Elfo elfo = new ElfoVerde("");
        
        elfo.adicionarItem(new Item("Item invalido test", 10));
        
        assertNull(elfo.getInventario().pesquisarItem("Item invalido test"));
    }
    
    @Test
    public void atacarUmaVezEGanharExpDobrada()
    {
        Elfo elfo = new ElfoVerde("");
        
        elfo.atirarFlechas(new Dwarf(""));
        
        assertEquals(2, elfo.getExp());
    }
    
    @Test
    public void atacarDezVezEGanharExpDobrada()
    {
        Elfo elfo = new ElfoVerde("");
        
        for (int i = 0; i < 10; i++)
            elfo.atirarFlechas(new Dwarf(""));
        
        assertEquals(20, elfo.getExp());
    }
}


