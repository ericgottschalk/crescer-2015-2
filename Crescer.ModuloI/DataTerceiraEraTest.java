

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DataTerceiraEraTest
{
    @Test
    public void ctorDataTerceiraEra()
    {
        DataTerceiraEra data = new DataTerceiraEra(10, 7, 1988);
        assertEquals(10, data.getDia());
        assertEquals(7, data.getMes());
        assertEquals(1988, data.getAno());
        assertEquals("10/7/1988", data.getData());
    }
    
    @Test
    public void bissextoTrue()
    {
        DataTerceiraEra data = new DataTerceiraEra(10, 7, 1988);
        assertTrue(data.ehBissexto());
    }
    
    @Test
    public void bissextoFalse()
    {
        DataTerceiraEra data = new DataTerceiraEra(10, 7, 1989);
        assertFalse(data.ehBissexto());
    }
}
