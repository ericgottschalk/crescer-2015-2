import java.util.ArrayList;

public class EstrategiaNormal implements EstrategiaDeAtaque
{
    public void atacar(ArrayList<Elfo> elfos, ArrayList<Dwarf> dwarves)
    {
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
}

