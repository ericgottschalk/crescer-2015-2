package br.com.cwi.model;


public class Cliente {

    public long idCliente;

    public String nmCliente;

    public String nrCpf;

    @Override
    public String toString() {
        return this.idCliente + " - " + this.nmCliente + " - " + this.nrCpf;
    }
}
