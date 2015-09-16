public class Dwarf
{
    private int hp;  
    
    public Dwarf()
    {
        this.hp = 110;
    }
    
    public void receberFlechada()
    {
        this.hp -= 10;
    }
}