

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IrishDwarfTest
{
    @Test
    public void dwarfNasceComNome()
    {
        IrishDwarf d = new IrishDwarf("Anao");
        assertEquals("Anao", d.getNome());
    }
   
    @Test 
    public void nasceComDataInformada()
    {
        DataTerceiraEra data = new DataTerceiraEra(2, 2, 2);
        IrishDwarf d = new IrishDwarf("", data);
        
        assertEquals(data, d.getDataNascimento());
    }
    
    @Test
    public void tentarSorteTerSorte()
    {
        IrishDwarf d = new IrishDwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        Item item = new Item("Test", 3);
        d.getInventario().adicionarItem(item);
        for(int i = 0; i < 2; i++)
            d.receberFlechada();
            
        d.tentarSorte();
        
        assertEquals(6003, item.getQuantidade());
    }
    
    @Test
    public void tentarSorteTerSorteAgain()
    {
        IrishDwarf d = new IrishDwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        Item item = new Item("Test", 10);
        d.getInventario().adicionarItem(item);
        for(int i = 0; i < 2; i++)
            d.receberFlechada();

        d.tentarSorte();
        
        assertEquals(55010, item.getQuantidade());
    }
    
    @Test
    public void tentarSorteNaoTerSorte()
    {
        IrishDwarf d = new IrishDwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        Item item = new Item("Test", 10);
        d.getInventario().adicionarItem(item);
            
        d.tentarSorte();
        
        assertEquals(10, item.getQuantidade());
    }
}
