package br.com.cwi.aplicacao;

import java.util.List;
import java.util.Scanner;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.dao.PedidoDao;
import br.com.cwi.dao.ServicoDao;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;
import br.com.cwi.model.Servico;

public class Operacoes {

    // TODO implementar metodos nÃ£o implementados

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
    	try {
            Servico servico = new Servico();
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o descrição do serviço :> ");
            servico.dsServico = scn.next();

            ServicoDao dao = new ServicoDao();
            dao.add(servico);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void buscarServico() {
    	Servico servico = this.buscarServicoPorId();
    	
    	if (servico == null){
    		System.out.println("Nenhum registro encontrado!");
    		return;
    	}
    	
    	System.out.println(servico.toString());
    }

    public void atualizarServico() {
    	try {
    		Servico servico = this.buscarServicoPorId();
        	
        	if (servico == null){
        		System.out.println("Nenhum registro encontrado!");
        		return;
        	}
        	
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o descrição do serviço :> ");
            servico.dsServico = scn.next();

            ServicoDao dao = new ServicoDao();
            dao.update(servico);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void deletarServico() {
        Servico servico = this.buscarServicoPorId();
    	
    	if (servico == null){
    		System.out.println("Nenhum registro encontrado!");
    		return;
    	}
    	
    	try{
    		ServicoDao dao = new ServicoDao();
            dao.delete(servico.idServico);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void novoPedido() {
    	try{
    		Cliente cliente = this.buscarClientePorId();

            if (cliente == null) {
                System.out.println("Nenhum registro encontrado");
                return;
            }
            
            Pedido pedido = new Pedido();
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite a descrição do pedido :> ");
            pedido.dsPedido = scn.nextLine();
            pedido.Cliente = cliente;
            
            PedidoDao dao = new PedidoDao();
            dao.add(pedido);
    	} catch(Exception e){
    		System.out.println("Error: " + e.getMessage());
    	}
    }

    public void buscarPedido() {
    	Pedido pedido = this.buscarPedidoPorId();
    	
    	if (pedido == null){
    		System.out.println("Nenhum registro encontrado");
            return;
    	}
    	
    	System.out.println(pedido.toString());
    }

    public void buscarPedidoPorNomeCliente() {
    	Scanner scn = new Scanner(System.in);
    	System.out.println("Digite o nome do cliente :> ");
    	String nome = scn.next();
    	
    	try{
	    	PedidoDao dao = new PedidoDao();
	    	List<Pedido> list = dao.find(nome);
	    	
	    	if (list.isEmpty()){
	    		System.out.println("Nenhum registro encontrado!");
	    		return;
	    	}
	    	
	    	for (Pedido pedido : list){
	    		System.out.println(pedido.toString());
	    	}
    	} catch(Exception e){
    		System.out.println("Error: " + e.getMessage());
    	}
    }

    private Cliente buscarClientePorId() {
        Cliente cliente = null;
        try {
            Scanner scn = new Scanner(System.in);
            System.out.println("Digite o id :> ");
            long id = scn.nextLong();
            ClienteDao dao = new ClienteDao();
            cliente = dao.load(id);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        return cliente;
    }
    
    private Servico buscarServicoPorId(){
    	Servico servico = null;
    	try{
    		Scanner scn = new Scanner(System.in);
    		System.out.println("Digite o id :> ");
    		long id = scn.nextLong();
    		ServicoDao dao = new ServicoDao();
    		servico = dao.load(id);
    	} catch(Exception e){
    		System.out.println("Error: " + e.getMessage());
    	}
    	
    	return servico;
    }
    
    private Pedido buscarPedidoPorId(){
    	Pedido pedido = null;
    	try{
    		Scanner scn = new Scanner(System.in);
    		System.out.println("Digite o id :> ");
    		long id = scn.nextLong();
    		PedidoDao dao = new PedidoDao();
    		pedido = dao.load(id);
    	} catch(Exception e){
    		System.out.println("Error: " + e.getMessage());
    	}
    	
    	return pedido;
    }
}
