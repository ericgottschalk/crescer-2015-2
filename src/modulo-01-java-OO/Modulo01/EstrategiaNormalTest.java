
import java.util.ArrayList;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class EstrategiaNormalTest
{
    @Test
    public void getOrdemDoUltimoAtaqueTresAtacantes()
    {
       
        ExercitoElfos e = new ExercitoElfos();
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        ArrayList<Elfo> atacantes = new ArrayList<Elfo>();
        
        for (int i = 0; i < 3; i++)
            e.alistarElfo(new ElfoVerde("Elfo " + i));
        
        for (int i = 0; i < 3; i++)
            alvo.add(new Dwarf("Alvo" + i));
            
        atacantes = e.buscarPorStatus(Status.VIVO);
        e.atacarHordaDwarves(alvo);
        
        for (Elfo elfo: atacantes)
            assertTrue(e.getOrdemDoUltimoAtaque().contains(elfo));
    }
    
    @Test
    public void getOrdemDoUltimoAtaqueDezAtacantes()
    {
        ExercitoElfos e = new ExercitoElfos();
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        ArrayList<Elfo> atacantes = new ArrayList<Elfo>();
        
        for (int i = 0; i < 10; i++)
            e.alistarElfo(new ElfoVerde("Elfo " + i));
        
        for (int i = 0; i < 10; i++)
            alvo.add(new Dwarf("Alvo" + i));
            
        atacantes = e.buscarPorStatus(Status.VIVO);
        e.atacarHordaDwarves(alvo);
        
        for (Elfo elfo: atacantes)
            assertTrue(e.getOrdemDoUltimoAtaque().contains(elfo));
    }
    
    @Test
    public void atacarHordaTresDwarfs()
    {
        ExercitoElfos e = new ExercitoElfos();
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        
        for (int i = 0; i < 3; i++)
            e.alistarElfo(new ElfoVerde("Elfo " + i));
        
        for (int i = 0; i < 3; i++)
            alvo.add(new Dwarf("Alvo" + i));
            
        e.atacarHordaDwarves(alvo);
        
        for (Dwarf d : alvo)
            assertEquals(80 , d.getHp());
    }
    
    @Test
    public void atacarHordaDezDwarfs()
    {
        ExercitoElfos e = new ExercitoElfos();
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        
        for (int i = 0; i < 10; i++)
            e.alistarElfo(new ElfoVerde("Elfo " + i));
        
        for (int i = 0; i < 10; i++)
            alvo.add(new Dwarf("Alvo" + i));
            
        e.atacarHordaDwarves(alvo);
        
        for (Dwarf d : alvo)
            assertEquals(10 , d.getHp());
    }
    
    @Test
    public void atacarHordaDuasVezesDezDwarfs()
    {
        ExercitoElfos e = new ExercitoElfos();
        ArrayList<Dwarf> alvo = new ArrayList<Dwarf>();
        ArrayList<Elfo> atacantes = new ArrayList<Elfo>();
        
        for (int i = 0; i < 10; i++)
            e.alistarElfo(new ElfoVerde("Elfo " + i));
        
        for (int i = 0; i < 10; i++)
            alvo.add(new Dwarf("Alvo" + i));
            
        atacantes = e.buscarPorStatus(Status.VIVO);
        e.atacarHordaDwarves(alvo);
        e.atacarHordaDwarves(alvo);
        
        for (Dwarf d : alvo)
            assertEquals(Status.MORTO, d.getStatus());
            
        for (Elfo elfo: atacantes)
            assertTrue(e.getOrdemDoUltimoAtaque().contains(elfo));
    }
}
