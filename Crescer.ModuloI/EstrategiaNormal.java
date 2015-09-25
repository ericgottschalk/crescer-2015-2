import java.util.ArrayList;

public class EstrategiaNormal implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ultimosAtacantes = new ArrayList<Elfo>();
    
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves)
    {
        this.ultimosAtacantes = elfos;
        int intencoesAtaque = elfos.size() * dwarves.size();
        int porcentagemLimite = (int)(intencoesAtaque * 0.3);
        int ataques = 0;
        
        for (Elfo elfo : elfos)
            for (Dwarf dwarf : dwarves)
            {
                if(porcentagemLimite >= ataques && elfo instanceof ElfoNoturno)
                    continue;
                    
                elfo.atirarFlechas(dwarf);
                ataques++;
            }
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.ultimosAtacantes;
    }
}

