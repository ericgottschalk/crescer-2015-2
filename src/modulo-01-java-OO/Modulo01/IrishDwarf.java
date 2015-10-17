
public class IrishDwarf extends Dwarf
{   
    public IrishDwarf(String n)
    {
        super(n);
    }
    
    public IrishDwarf(String n, DataTerceiraEra data)
    {
        super(n, data);
    }
    
    public void tentarSorte()
    {
        if (this.getNumeroSorte() == -3333.0)
        {
            for (Item item : this.inventario.getItens())
                item.adicionarUnidadesLikeABoss();
        }
    }
}
