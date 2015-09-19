

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ItemTest
{
   @Test
   public void criacaoItem()
   {
       Item itm = new Item("Test", 10972);
       
       assertEquals("Test", itm.getDescricao());
       assertEquals(10972, itm.getQuantidade());
   }
   
   @Test
   public void adicionailMilUnid()
   {
       Item itm = new Item("Test", 102);
       
       itm.adicionarMilUnidades();
       
       assertEquals(1102, itm.getQuantidade());
   }
}
