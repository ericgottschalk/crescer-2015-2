public class Dwarf
{
    private String nome;
    private int hp;
    private int exp;
    
    public Dwarf(String n)
    {
        this.nome = n;
        this.hp = 110;
        this.exp = 0;
    }
    
    public void sofrerDano()
    {
        this.hp -= 10;
    }
}