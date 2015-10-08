
/**
 * Write a description of class Smartphone here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Smartphone extends Telefone
{
    private Conectividade conectividade;
    
    public Smartphone(String modelo)
    {
        super(modelo);
        this.conectividade = Conectividade.NENHUM;
    }
    
    public Conectividade getConectividade()
    {
        return this.conectividade;
    }
    
    public void setConectividade(Conectividade con)
    {
        this.conectividade = con;
    }
}
