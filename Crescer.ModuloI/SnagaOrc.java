

public class SnagaOrc extends Orc
{
    public SnagaOrc(String n)
    {
        super(n, 70);
        this.adicionarItem(new Item("Arco", 1));
        this.adicionarItem(new Item("Flecha", 5));
    }
}
