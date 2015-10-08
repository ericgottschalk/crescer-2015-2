
/**
 * Write a description of class Nexus5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nexus5 extends Smartphone implements Camera
{
    public Nexus5()
    {
        super("Nexus 5"); 
    }
    
    public void tirarFoto()
    {
        System.out.println("Tirou foto");
    }
}
