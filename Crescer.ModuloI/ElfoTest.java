

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
    public void elfoNasceVivo()
    {
        Elfo elfo = new Elfo("");
        assertEquals(Status.VIVO, elfo.getStatus());
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
        
        elfo.atirarFlechas(new Dwarf(""));
        
        assertEquals(flechas, elfo.getFlechas());
        assertEquals(exp, elfo.getExp());
        
    }
    
    @Test
    public void atirarFlechasEmDwarf()
    {
        Elfo elfo = new Elfo("Elfo");
        Dwarf dwarf = new Dwarf("");
        int flechasElfoEsperadas = 41;
        int expElfoEsperada = 1;
        int hpDwarfEsperada = 100;
        
        elfo.atirarFlechas(dwarf);
        
        assertEquals(flechasElfoEsperadas, elfo.getFlechas());
        assertEquals(expElfoEsperada, elfo.getExp());
        assertEquals(hpDwarfEsperada, dwarf.getHp());
    }
    
    @Test
    public void doisElfosAtiramEmDoisDwarves()
    {
        Elfo elfo1 = new Elfo("1");
        Elfo elfo2 = new Elfo("2");
        Dwarf dwarf1 = new Dwarf("");
        Dwarf dwarf2 = new Dwarf("");
        int flechas = 40;
        int exp = 2;
        int hp = 90;
        
        elfo1.atirarFlechas(dwarf1);
        elfo1.atirarFlechas(dwarf2);
        elfo2.atirarFlechas(dwarf1);
        elfo2.atirarFlechas(dwarf2);
        
        assertEquals(flechas, elfo1.getFlechas());
        assertEquals(exp, elfo1.getExp());
        assertEquals(flechas, elfo2.getFlechas());
        assertEquals(exp, elfo2.getExp());
        
        assertEquals(hp, dwarf1.getHp());
        assertEquals(hp, dwarf2.getHp());
        
    }
    
    @Test
    public void metodoToString()
    {
        Elfo elfo = new Elfo("Legolas");
        assertEquals("Legolas possui 42 flechas e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test 
    public void toStringCom1Flecha()
    {
        
        Elfo elfo = new Elfo("Legolas", 1);
        assertEquals("Legolas possui 1 flecha e 0 níveis de experiência.", elfo.toString());
    }
    
    @Test
    public void toStringElfoComUmDeExp()
    {
        Elfo elfo = new Elfo("Legolas");
        elfo.atirarFlechas(new Dwarf(""));
        assertEquals("Legolas possui 41 flechas e 1 nível de experiência.", elfo.toString());
    }
    
    @Test
    public void atacarOrcUrukHai()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new UrukHaiOrc("");
        
        elfo.atirarFlechas(orc);
        
        assertEquals(144, orc.getHp());
    }
    
    @Test
    public void atacarOrcSnaga()
    {
        Elfo elfo = new Elfo("Elfinho");
        Orc orc = new SnagaOrc("");
        
        elfo.atirarFlechas(orc);
        
        assertEquals(60, orc.getHp());
    }
    
    @Test
    public void receberAtqueOrcTipoEspada()
    {
        Elfo elfo = new Elfo("Test");
        
        elfo.receberAtaqueOrc(12);
        
        assertEquals(68, elfo.getHp());
    }
    
    @Test
    public void receberAtqueOrcTipoEspadaAteMorte()
    {
        Elfo elfo = new Elfo("Test");
        
        for (int i = 0; i < 7; i++)
            elfo.receberAtaqueOrc(12);
        
        assertEquals(Status.MORTO, elfo.getStatus());
    }
    
    @Test
    public void receberAtqueOrcTipoArco()
    {
        Elfo elfo = new Elfo("Test");
        
        elfo.receberAtaqueOrc(8);
        
        assertEquals(72, elfo.getHp());
    }
    
    @Test
    public void receberAtqueOrcTipoArcoAteMorte()
    {
        Elfo elfo = new Elfo("Test");
        
        for(int i = 0; i < 10; i++)
            elfo.receberAtaqueOrc(8);
        
        assertEquals(Status.MORTO, elfo.getStatus());
    }
    
    @Test
    public void elfoNasceComInventario()
    {
        Elfo elfo = new Elfo("");
        
        assertNotNull(elfo.getInventario());
    }
    
    @Test
    public void elfoGanhaUmItem()
    {
        Elfo elfo = new Elfo("");
        Item item = new Item("Test", 1);
        
        elfo.adicionarItem(item);
        
        assertTrue(elfo.getInventario().getItens().contains(item));
        
    }
    
    @Test
    public void elfoGanha100Itens()
    {
        Elfo elfo = new Elfo("");
        
        for (int i = 0; i < 100; i++)
            elfo.adicionarItem(new Item("Test", i));
            
        assertEquals(100, elfo.getInventario().getItens().size());
    }
    
    @Test
    public void elfoPerdeItem()
    {
        Elfo elfo = new Elfo("");
        Item item = new Item("Test", 1);
        elfo.adicionarItem(item);
        
        elfo.perderItem(item);
        
        assertFalse(elfo.getInventario().getItens().contains(item));
    }
}
