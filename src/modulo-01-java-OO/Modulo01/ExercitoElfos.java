import java.util.*;

public class ExercitoElfos 
{
    private HashMap<String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> orderByStatus;
    private EstrategiaDeAtaque estrategia;
    
    public ExercitoElfos()
    {
        this.estrategia = new EstrategiaNormal();
        this.exercito = new HashMap<>();
        this.orderByStatus = new HashMap<>();
    }
    
    public Elfo buscarPorNome(String nome)
    {
        return this.exercito.get(nome);
    }
    
    public ArrayList<Elfo> buscarPorStatus(Status sts)
    {
        this.agruparPorStatus();
        return this.orderByStatus.get(sts);
    }
    
    public void alistarElfo(Elfo elfo)
    {
        if (elfo instanceof ElfoVerde || elfo instanceof ElfoNoturno)
            this.exercito.put(elfo.getNome(), elfo);
    }
    
    public void trocarDeEstrategia(EstrategiaDeAtaque estrategia)
    {
        this.estrategia = estrategia;
    }
    
    public void agruparPorStatus()
    {    
        this.orderByStatus.clear();
        
        for(Map.Entry<String, Elfo> parKV : this.exercito.entrySet())
        {
            Elfo elfo = parKV.getValue();
            Status sts = elfo.getStatus();
            
            if (this.orderByStatus.containsKey(sts))
                this.orderByStatus.get(sts).add(elfo);
            else
                this.orderByStatus.put(sts, new ArrayList<Elfo>( Arrays.asList(elfo) ));
        }
    }
    
    public void atacarHordaDwarves(ArrayList<Dwarf> dwarves)
    {       
        this.estrategia.atacar(this, dwarves);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque()
    {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
}
