package br.com.cwi.model;


public class Servico {

    public long idServico;

    public String dsServico;
    
    @Override
    public String toString(){
    	return this.idServico + " - " + this.dsServico;
    }
}
