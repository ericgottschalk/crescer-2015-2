

public class UrukHaiOrc extends Orc
{
    public UrukHaiOrc(String n)
    {
        super(n, 150);
        this.adicionarItem(new Item("Espada", 1));
        this.adicionarItem(new Item("Escudo Uruk-Hai", 1));
    }
}
