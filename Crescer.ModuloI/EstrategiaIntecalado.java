import java.util.ArrayList;

public class EstrategiaIntecalado implements EstrategiaDeAtaque
{
    private ArrayList<Elfo> ultimosAtacantes = new ArrayList<>();
    
    public void atacar(ExercitoElfos e, ArrayList<Dwarf> dwarves) 
    {
        ArrayList<Elfo> elfos = e.buscarPorStatus(Status.VIVO);
        
        if(!mesmaQuantidade(elfos))
            return;
        
        this.pelotaoSentido(elfos);
        
        for (Elfo elfo : elfos) 
            for (Dwarf d : dwarves) 
                elfo.atirarFlechas(d);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() 
    {
        return ultimosAtacantes;
    }
    
    private boolean mesmaQuantidade(ArrayList<Elfo> elfos)
    {
        int verdes = 0, noturnos = 0;
        
        for (Elfo elfo : elfos) 
        {            
            if (elfo instanceof ElfoVerde) 
                verdes++;
                
            if (elfo instanceof ElfoNoturno) 
                noturnos++;
        }
        
        return verdes == noturnos;
    }
    
    private void pelotaoSentido(ArrayList<Elfo> elfos) 
    {     
       ArrayList<Elfo> verdes = new ArrayList<Elfo>();
       ArrayList<Elfo> noturnos = new ArrayList<Elfo>();
       ArrayList<Elfo> intercalados = new ArrayList<Elfo>();
       
       for (Elfo elf : elfos)
       {
           if (elf instanceof ElfoVerde)
               verdes.add(elf);
           
           if (elf instanceof ElfoNoturno)
               noturnos.add(elf);
       }
       
       int v = 0, n = 0;
       for (int i = 1; i <= elfos.size(); i++)
       {
           if (i % 2 == 0)
               intercalados.add(verdes.get(v++));
           else
               intercalados.add(noturnos.get(n++));
       }
       
       elfos = intercalados;
    }
}
