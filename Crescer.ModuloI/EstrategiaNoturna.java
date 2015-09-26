import java.util.ArrayList;

public class EstrategiaNoturna implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ultimosAtacantes = new ArrayList<Elfo>();
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.ultimosAtacantes;
    }
    
    public void atacar(ExercitoElfos e, ArrayList<Dwarf> dwarves)
    {
        this.ultimosAtacantes.clear();
        ArrayList<Elfo> elfos = e.buscarPorStatus(Status.VIVO);
        this.pelotaoSentido(elfos);
        
        for (Elfo elfo : elfos)
        {
            this.ultimosAtacantes.add(elfo);
            
            for(Dwarf d : dwarves)
                elfo.atirarFlechas(d); 
        }
    }
    
    public void pelotaoSentido(ArrayList<Elfo> pelotao)
    {
        boolean h = true;
        while(h)
        {
            h = false;
            for (int j = 0; j < pelotao.size() - 1; j++)
            {
                Elfo a = pelotao.get(j);
                Elfo p = pelotao.get(j + 1);
                if (a instanceof ElfoNoturno && p instanceof ElfoVerde)
                {
                    pelotao.set(j, p);
                    pelotao.set(j + 1, a);
                    h = true;
                }
            }
        }
    }
}
