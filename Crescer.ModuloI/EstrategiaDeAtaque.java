import java.util.ArrayList;

public interface EstrategiaDeAtaque
{
    ArrayList<Elfo> getOrdemDoUltimoAtaque();
    
    void atacar(ExercitoElfos e, ArrayList<Dwarf> dwarves); 
}
