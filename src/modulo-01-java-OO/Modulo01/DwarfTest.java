import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DwarfTest
{
    @Test
    public void dwarfNasceComNome()
    {
        Dwarf d = new Dwarf("Anao");
        assertEquals("Anao", d.getNome());
    }
    
    @Test
    public void dwarfNasceCom110DeHp()
    {
        Dwarf d = new Dwarf("");
        assertEquals(110, d.getHp());
    }
    
    @Test
    public void sofrer10DeDano()
    {
        Dwarf d = new Dwarf("");
        d.receberFlechada();
        assertEquals(100, d.getHp());
    }
    
    @Test
    public void receber11FlechadasEZerarHp()
    {
        Dwarf d = new Dwarf("");
        int vidaEsperada = 0;
        
        for(int i = 0; i < 11; i++)
            d.receberFlechada();
            
        assertEquals(vidaEsperada, d.getHp());
    }
    
    @Test
    public void receber7Flechadas()
    {
        Dwarf d = new Dwarf("");
        int vidaEsperada = 40;
        
        for(int i = 0; i < 7; i++)
            d.receberFlechada();
            
        assertEquals(vidaEsperada, d.getHp());
    }
    
    @Test
    public void naoRecebeFlechaEGanhaDoisExp()
    {
        Dwarf d = new Dwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        
        for(int i = 0; i < 2; i++)
            d.receberFlechada();
            
        d.receberFlechada();
        
        assertEquals(90, d.getHp());
        assertEquals(2, d.getExp());
    }
    
    @Test
    public void naoRecebeFlechaNemExpNomeSeixas()
    {
        Dwarf d = new Dwarf("Seixas", new DataTerceiraEra(1, 1, 1995));
            
        d.receberFlechada();
        
        assertEquals(110, d.getHp());
        assertEquals(0, d.getExp());
    }
    
    @Test
    public void naoRecebeFlechaNemExpNomeMeireles()
    {
        Dwarf d = new Dwarf("Meireles", new DataTerceiraEra(1, 1, 1995));
            
        d.receberFlechada();
        
        assertEquals(110, d.getHp());
        assertEquals(0, d.getExp());
    }
    
    @Test
    public void dwarfMorre()
    {
        Dwarf d = new Dwarf("");
        
        for(int i = 0; i < 11; i++)
            d.receberFlechada();
            
        assertEquals(Status.MORTO, d.getStatus());
    }
    
    @Test
    public void hpNaoFicaNegatiivo12Flechadas()
    {
        Dwarf d = new Dwarf("");
        
        for(int i = 0; i < 12; i++)
            d.receberFlechada();
            
        assertEquals(0, d.getHp());
    }
    
    @Test
    public void hpNaoFicaNegatiivo100Flechadas()
    {
        Dwarf d = new Dwarf("");
        
        for(int i = 0; i < 100; i++)
            d.receberFlechada();
            
        assertEquals(0, d.getHp());
    }
    
    @Test 
    public void nasceComDataInformada()
    {
        DataTerceiraEra data = new DataTerceiraEra(2, 2, 2);
        Dwarf d = new Dwarf("", data);
        
        assertEquals(data, d.getDataNascimento());
    }
    
    @Test
    public void tentarSorteTerSorte()
    {
        Dwarf d = new Dwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        Item item = new Item("Test", 10);
        d.adicionarItem(item);
        for(int i = 0; i < 2; i++)
            d.receberFlechada();
            
        d.tentarSorte();
        
        assertEquals(1010, item.getQuantidade());
    }
    
    @Test
    public void tentarSorteNaoTerSorte()
    {
        Dwarf d = new Dwarf("Anao", new DataTerceiraEra(1, 1, 1996));
        Item item = new Item("Test", 10);
        d.adicionarItem(item);
            
        d.tentarSorte();
        
        assertEquals(10, item.getQuantidade());
    }
    
    @Test
    public void receberAtaqueOrcComEspada()
    {
        Dwarf d = new Dwarf("");
        
        d.receberAtaqueOrc(new UrukHaiOrc(""));
        
        assertEquals(98, d.getHp());
        
    }
    
    @Test
    public void receberAtaqueOrcComArco()
    {
        Dwarf d = new Dwarf("");
        
        d.receberAtaqueOrc(new SnagaOrc(""));
        
        assertEquals(102, d.getHp());
        
    }
    
    @Test
    public void atacarOrcComEscudo()
    {
        Dwarf d = new Dwarf("");
        UrukHaiOrc orc = new UrukHaiOrc("");
        
        d.realizarAtaque(orc);
        
        assertEquals(144, orc.getHp());
    }
    
    @Test
    public void atacarOrcSemEscudo()
    {
        Dwarf d = new Dwarf("");
        SnagaOrc orc = new SnagaOrc("");
        
        d.realizarAtaque(orc);
        
        assertEquals(60, orc.getHp());
    }
    
}
