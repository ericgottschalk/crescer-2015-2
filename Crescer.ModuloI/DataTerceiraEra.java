
public class DataTerceiraEra
{
    private int dia;
    private int ano;
    private int mes;
    
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia()
    {
        return this.dia;
    }
    
    public int getMes()
    {
        return this.mes;
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public String getData()
    {
        return String.format("%d/%d/%d", dia, mes, ano);
    }
    public boolean ehBissexto()
    {
         return ((this.ano % 400 == 0) || ((this.ano % 4 == 0) && (this.ano % 100 != 0)));
    }
}