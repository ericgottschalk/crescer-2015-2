package br.com.cwi.aplicacao;

import java.util.Scanner;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.model.Cliente;

public class Operacoes {

    // TODO implementar metodos não implementados

    public void cadastrarCliente() {
        try {
            Cliente cliente = new Cliente();
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o nome do cliente :> ");
            cliente.nmCliente = scn.next();
            System.out.println("Digite o CPF do cliente :> ");
            cliente.nrCpf = scn.next();

            ClienteDao dao = new ClienteDao();
            dao.add(cliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarCliente() {
        Cliente cliente = this.buscarClientePorId();

        if (cliente == null) {
            System.out.println("Nenhum registro encontrado");
            return;
        }

        System.out.println(cliente.toString());
    }

    public void atualizarCliente() {
        try {
            Cliente cliente = this.buscarClientePorId();

            if (cliente == null) {
                System.out.println("Nenhum registro encontrado");
                return;
            }

            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o nome do cliente :> ");
            cliente.nmCliente = scn.next();
            System.out.println("Digite o CPF do cliente :> ");
            cliente.nrCpf = scn.next();

            ClienteDao dao = new ClienteDao();
            dao.update(cliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deletarCliente() {
        Cliente cliente = this.buscarClientePorId();

        if (cliente == null) {
            System.out.println("Nenhum registro encontrado");
            return;
        }

        try {
            ClienteDao dao = new ClienteDao();
            dao.delete(cliente.idCliente);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void cadastrarServico() {

    }

    public void buscarServico() {

    }

    public void atualizarServico() {

    }

    public void deletarServico() {

    }

    public void novoPedido() {

    }

    public void buscarPedido() {

    }

    public void buscarPedidoPorNomeCliente() {

    }

    private Cliente buscarClientePorId() {
        Cliente cliente = null;
        try {
            Scanner scn = new Scanner(System.in);
            long id = scn.nextLong();
            ClienteDao dao = new ClienteDao();
            cliente = dao.load(id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cliente;
    }
}
