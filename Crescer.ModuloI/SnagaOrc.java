

public class SnagaOrc extends Orc
{
    public SnagaOrc()
    {
        super("Snaga", 70);
        this.adicionarItem(new Item("Arco", 1));
        this.adicionarItem(new Item("Flecha", 5));
    }
}
