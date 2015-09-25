import java.util.ArrayList;

public class EstrategiaNormal implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ultimosAtacantes = new ArrayList<Elfo>();

    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves) 
    {        
        this.ultimosAtacantes.clear();
        
        for (Elfo elfo : elfos) 
        {
           ultimosAtacantes.add(elfo);
           
            for (Dwarf dwarf : dwarves)          
                elfo.atirarFlechas(dwarf);
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() 
    {
        return this.ultimosAtacantes;
    }
}
