import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceCom110DeHp()
    {
        Dwarf d = new Dwarf();
        assertEquals(110, d.getHp());
    }
}
