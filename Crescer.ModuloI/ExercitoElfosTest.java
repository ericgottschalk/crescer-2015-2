
import java.util.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercitoElfosTest
{
    @Test
    public void alistarUmElfoVerde()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        exercito.alistarElfo(new ElfoVerde("John"));
        
        assertNotNull(exercito.buscarPorNome("John"));
    }
    
    @Test
    public void alistarTresElfosVerdes()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        for (int i = 0; i < 3; i++)
            exercito.alistarElfo(new ElfoVerde("Elfo" + i));
            
        for (int i = 0; i < 3; i++)
            assertNotNull(exercito.buscarPorNome("Elfo" + i));
    }
    
    @Test
    public void alistarUmElfoNoturno()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        exercito.alistarElfo(new ElfoNoturno("James"));
        
        assertNotNull(exercito.buscarPorNome("James"));
    }
    
    @Test
    public void alistarTresElfosNoturnos()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        for (int i = 0; i < 3; i++)
            exercito.alistarElfo(new ElfoNoturno("Elfo" + i));
            
        for (int i = 0; i < 3; i++)
            assertNotNull(exercito.buscarPorNome("Elfo" + i));
    }
    
    @Test
    public void tentarAlistarElfo()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        exercito.alistarElfo(new Elfo("Low"));
        
        assertNull(exercito.buscarPorNome("Low"));
    }
    
    @Test
    public void tentarAlistarElfos()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        for (int i = 0; i < 10; i++)
            exercito.alistarElfo(new Elfo(i + "Elfo"));
        
        for (int i = 0; i < 10; i++)
            assertNull(exercito.buscarPorNome(i + "Elfo"));
    }
    
    @Test
    public void buscarPorNomeElfoInexistente()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        assertNull(exercito.buscarPorNome("Inexistente"));
    }
    
    @Test
    public void buscarPorNomeElfosInexistentes()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        
        for (int i = 0; i < 10; i++)
            assertNull(exercito.buscarPorNome("Inexistente" + i));
    }
    
    @Test
    public void agruparElfosPorStatus()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        Orc orc = new UrukHaiOrc("Matador de Elfos");
        int v = 0;
        int m = 0;
        
        for (int i = 0; i < 5; i++)
        {
            Elfo eV = new ElfoVerde("Elfo Verde Vivo" + i);
            Elfo eN = new ElfoNoturno("Elfo Noturno vivo" + i);
            exercito.alistarElfo(eV);
            exercito.alistarElfo(eN);
        }
        
        for (int i = 0; i < 5; i++)
        {
            Elfo eV = new ElfoVerde("Elfo Verde Morto" + i);
            Elfo eN = new ElfoNoturno("Elfo Noturno Morto" + i);
            for (int j = 0; j < 10; j++)
            {
                orc.realizarAtaque(eV);
                orc.realizarAtaque(eN);
            }
            
            exercito.alistarElfo(eV);
            exercito.alistarElfo(eN);
        }
        
        exercito.agruparPorStatus();
        ArrayList<Elfo> vivos = exercito.buscarPorStatus(Status.VIVO);
        ArrayList<Elfo> mortos = exercito.buscarPorStatus(Status.MORTO);
        
        for(Elfo elfo : vivos)
        {
            assertEquals(Status.VIVO, elfo.getStatus());
            v++;
        }
        
        for(Elfo elfo : mortos)
        {
            assertEquals(Status.MORTO, elfo.getStatus());
            m++;
        }
        
        assertEquals(10, v);
        assertEquals(10, m);
    }
    
    @Test
    public void agruparElfosETerCertezaQueSaoOsAListados()
    {
        ExercitoElfos exercito = new ExercitoElfos();
        Orc orc = new UrukHaiOrc("Matador de Elfos");
        ArrayList<Elfo> vivosAlistados = new ArrayList<Elfo>();
        ArrayList<Elfo> mortosAlistados = new ArrayList<Elfo>();
        int v = 0;
        int m = 0;
        
        for (int i = 0; i < 5; i++)
        {
            Elfo eV = new ElfoVerde("Elfo Verde Vivo" + i);
            Elfo eN = new ElfoNoturno("Elfo Noturno vivo" + i);
            exercito.alistarElfo(eV);
            exercito.alistarElfo(eN);
            vivosAlistados.add(eV);
            vivosAlistados.add(eN);
        }
        
        for (int i = 0; i < 5; i++)
        {
            Elfo eV = new ElfoVerde("Elfo Verde Morto" + i);
            Elfo eN = new ElfoNoturno("Elfo Noturno Morto" + i);
            for (int j = 0; j < 10; j++)
            {
                orc.realizarAtaque(eV);
                orc.realizarAtaque(eN);
            }
            
            exercito.alistarElfo(eV);
            exercito.alistarElfo(eN);
            mortosAlistados.add(eV);
            mortosAlistados.add(eN);
        }
        
        exercito.agruparPorStatus();
        ArrayList<Elfo> vivos = exercito.buscarPorStatus(Status.VIVO);
        ArrayList<Elfo> mortos = exercito.buscarPorStatus(Status.MORTO);
        
        for(Elfo elfo : vivos)
        {
            assertEquals(Status.VIVO, elfo.getStatus());
            assertTrue(vivos.contains(vivosAlistados.get(v)));
            v++;
        }
        
        for(Elfo elfo : mortos)
        {
            assertEquals(Status.MORTO, elfo.getStatus());
            assertTrue(mortos.contains(mortosAlistados.get(m)));
            m++;
        }
        
        assertEquals(10, v);
        assertEquals(10, m);
    }
}

