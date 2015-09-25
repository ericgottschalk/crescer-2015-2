import java.util.ArrayList;

public class EstrategiaDeGuerra implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ultimosAtacantes = new ArrayList<Elfo>();
    
    public void atacar(ExercitoElfos e, ArrayList<Dwarf> dwarves)
    {
        this.ultimosAtacantes.clear();
        ArrayList<Elfo> elfos = e.buscarPorStatus(Status.VIVO);
                
        int intencoesAtaque = elfos.size() * dwarves.size();
        int porcentagemLimite = (int)(intencoesAtaque * 0.3);
        int ataques = 0;
        
        for (Elfo elfo : elfos)
        {
            if(elfo instanceof ElfoNoturno)
            {
                 if (ataques >= porcentagemLimite)
                     continue;
                        
                 ataques++;
            }
               
            this.ultimosAtacantes.add(elfo);
             
            for (Dwarf dwarf : dwarves)
                elfo.atirarFlechas(dwarf);
        }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.ultimosAtacantes;
    }
}

