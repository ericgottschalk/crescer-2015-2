public class Dwarf
{
    private String nome;
    private int hp;  
    private int exp;
    private Status status;
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String n)
    {
        this.nome = n;
        this.hp = 110;
        this.status = Status.VIVO;
        this.exp = 0;
    }
    
    public void receberFlechada()
    {
        this.hp -= 10;
        
        if (this.hp == 0)
            this.status = Status.MORTO;
        
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public int getExp()
    {
        return this.exp;
    }
    public int getHp()
    {
        return this.hp;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
}