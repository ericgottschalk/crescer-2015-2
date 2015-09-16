
public class Elfo
{
    private String nome;
    private int flechas;
    private int exp;
    
    public Elfo(String n)
    {
        this.nome = n;
        this.flechas = 42;
        this.exp = 0;
    }
    
    public Elfo(String n, int flecha)
    {
        this.nome = n;
        this.flechas = flecha;
        this.exp = 0;
    }
    
    public void atirarFlechas()
    {
        if (this.flechas > 0)
        {
            this.flechas--;
            this.exp++;
            return;
        }
        
        System.out.println("Sem flechas");
        
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public void setNome(String novoNome)
    {
        this.nome = novoNome;
    }
    
    public int getFlechas()
    {
        return this.flechas;
    }
    
    /*public void setFleach(int num)
    {
        if (num > this.flechas)
            this.flechas = num;
    }*/
    
}
