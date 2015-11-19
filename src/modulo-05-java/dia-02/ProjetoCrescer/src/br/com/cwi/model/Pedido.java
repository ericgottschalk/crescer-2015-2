package br.com.cwi.model;


public class Pedido {

    public long idPedido;

    public Cliente Cliente;

    public String dsPedido;
    
    @Override
    public String toString(){
    	return this.idPedido + " - Cliente: " + this.Cliente.nmCliente 
    			+ " - CPF cliente: " + this.Cliente.nrCpf + " - Descrição: "
    			+ this.dsPedido;
    }
}
