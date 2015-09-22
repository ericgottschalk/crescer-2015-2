

public class UrukHaiOrc extends Orc
{
    public UrukHaiOrc()
    {
        super("Uruk-Hai", 150);
        this.adicionarItem(new Item("Espada", 1));
        this.adicionarItem(new Item("Escudo Uruk-Hai", 1));
    }
}
