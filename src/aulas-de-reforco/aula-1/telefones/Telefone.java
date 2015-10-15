
/**
 * Abstract class Telefone - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Telefone
{
    private String modelo;
    
    protected Telefone(String modelo) {
        this.modelo = modelo;
    }
    
    public String getModelo(){
        return this.modelo;
    }
    
    public void ligarPara(String numero){
        System.out.println("Estou ligando para " + numero);
    }
    
    public void enviarMensagem(String numero, String mensagem)
    {
    }
    
    public void desligar() {
        System.out.println("Telefone desligado.");
    }
}
