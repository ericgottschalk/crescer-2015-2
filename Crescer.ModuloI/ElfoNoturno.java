public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String name)
    {
        super(name);
    }
    
    public ElfoNoturno(String name, int hp)
    {
        super(name, hp);
    }
    
    @Override
    public void atirarFlechas(Dwarf dwarf)
    {
        if (this.flechas > 0 && this.status != Status.MORTO)
        {
            this.flechas--;
            dwarf.receberFlechada();
            this.exp += 3;
            this.perderVidaAtacando();
            this.verificarVida();
        }

    }
    
    public void atirarFlechas(Orc orc)
    {
        if (this.flechas > 0 && this.status != Status.MORTO)
        {
            this.flechas--;
            orc.receberAtaque();
            this.exp += 3;
            this.perderVidaAtacando();
            this.verificarVida();
        }
    }
    
    private void perderVidaAtacando()
    {
        double dano = this.hp * 0.05;
        if (dano <= 0.15)
            dano = 1;
        this.hp -= dano;
    }
}