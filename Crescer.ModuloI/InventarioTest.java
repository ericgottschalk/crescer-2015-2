

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InventarioTest
{   
    @Test
    public void adicaoItem()
    {
        Inventario ivt = new Inventario();
        Item itm = new Item("Item de teste", 10);
        
        assertFalse(ivt.getItens().contains(itm));
        
        ivt.adicionarItem(itm);
        
        assertTrue(ivt.getItens().contains(itm));
    }
    
    @Test
    public void removerItem()
    {
        Inventario ivt = new Inventario();
        Item itm = new Item("Item de teste", 10);
        
        ivt.adicionarItem(itm);
        assertTrue(ivt.getItens().contains(itm));
        
        ivt.perderItem(itm);
        assertFalse(ivt.getItens().contains(itm));
    }
    
    @Test
    public void imprimirDescricao()
    {
         Item itm1 = new Item("Adaga", 10);
         Item itm2 = new Item("Escudo", 10);
         Item itm3 = new Item("Bracelete", 10);
         Inventario ivt = new Inventario();
         
         ivt.adicionarItem(itm1);
         ivt.adicionarItem(itm2);
         ivt.adicionarItem(itm3);
         
         assertEquals("Adaga,Escudo,Bracelete,", ivt.getDescricoesItens());
    }
    
    @Test
    public void itemComMaiorQuantidade10Itens()
    {
        Inventario ivt = new Inventario();
        Item esperado = new Item("quant: 10", 10);
        
        for (int i = 1; i < 11; i++)
        {
            Item itm = new Item("quant: " + i, i);
            ivt.adicionarItem(itm);
        }   
        
        Item i = ivt.getItemComMaiorQuantidade();
        
        assertEquals(esperado, i);
    }
    
    @Test
    public void itemComMaiorQuantidade100Itens()
    {
        Inventario ivt = new Inventario();
        Item esperado = new Item("quant: 100", 100);
        
        for (int i = 1; i < 101; i++)
        {
            Item itm = new Item("quant: " + i, i);
            ivt.adicionarItem(itm);
        }   
        
        Item i = ivt.getItemComMaiorQuantidade();
        
        assertEquals(esperado, i);
    }
    
    @Test
    public void ordenarInventario5Items()
    {
        Inventario ivt = new Inventario();
        Item itm1 = new Item("Test", 2);
        Item itm2 = new Item("Test", 5);
        Item itm3 = new Item("Test", 3);
        Item itm4 = new Item("Test", 1);
        Item itm5 = new Item("Test", 7);
        ivt.adicionarItem(itm1);
        ivt.adicionarItem(itm2);
        ivt.adicionarItem(itm3);
        ivt.adicionarItem(itm4);
        ivt.adicionarItem(itm5);
        
        ivt.ordenarInventario();
        
        assertTrue(itm4.equals(ivt.getItem(0)));
        assertTrue(itm1.equals(ivt.getItem(1)));
        assertTrue(itm3.equals(ivt.getItem(2)));
        assertTrue(itm2.equals(ivt.getItem(3)));
        assertTrue(itm5.equals(ivt.getItem(4)));
    }
    
    @Test 
    public void ordenarInventario10Itens()
    {
        Inventario ivt = new Inventario();
        Item itm1 = new Item("Test", 2);
        Item itm2 = new Item("Test", 5);
        Item itm3 = new Item("Test", 3);
        Item itm4 = new Item("Test", 1);
        Item itm5 = new Item("Test", 7);
        Item itm6 = new Item("Test", 6);
        Item itm7 = new Item("Test", 9);
        Item itm8 = new Item("Test", 10);
        Item itm9 = new Item("Test", 4);
        Item itm10 = new Item("Test", 8);
        
        ivt.adicionarItem(itm1);
        ivt.adicionarItem(itm2);
        ivt.adicionarItem(itm3);
        ivt.adicionarItem(itm4);
        ivt.adicionarItem(itm5);
        ivt.adicionarItem(itm6);
        ivt.adicionarItem(itm7);
        ivt.adicionarItem(itm8);
        ivt.adicionarItem(itm9);
        ivt.adicionarItem(itm10);
       
        ivt.ordenarInventario();
        
        assertEquals(itm4.getQuantidade(), ivt.getItem(0).getQuantidade());
        assertEquals(itm1.getQuantidade(), ivt.getItem(1).getQuantidade());
        assertEquals(itm3.getQuantidade(), ivt.getItem(2).getQuantidade());
        assertEquals(itm9.getQuantidade(), ivt.getItem(3).getQuantidade());
        assertEquals(itm2.getQuantidade(), ivt.getItem(4).getQuantidade());
        assertEquals(itm6.getQuantidade(), ivt.getItem(5).getQuantidade());
        assertEquals(itm5.getQuantidade(), ivt.getItem(6).getQuantidade());
        assertEquals(itm10.getQuantidade(), ivt.getItem(7).getQuantidade());
        assertEquals(itm7.getQuantidade(), ivt.getItem(8).getQuantidade());
        assertEquals(itm8.getQuantidade(), ivt.getItem(9).getQuantidade());
    }
}
