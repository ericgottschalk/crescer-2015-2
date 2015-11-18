package br.com.cwi.aplicacao;

import java.util.Scanner;

public class Menu {

    private final String CADASTRAR_CLIENTE = "1";
    private final String BUSCAR_CLIENTE = "2";
    private final String ATUALIZAR_CLIENTE = "3";
    private final String DELETAR_CLIENTE = "4";
    private final String CADASTRAR_SERVICO = "5";
    private final String BUSCAR_SERVICO = "6";
    private final String ATUALIZAR_SERVICO = "7";
    private final String DELETAR_SERVICO = "8";
    private final String NOVO_PEDIDO = "9";
    private final String BUSCAR_PEDIDO = "10";
    private final String BUSCAR_PEDIDO_NOMECLIENTE = "11";
    private final String SAIR = "12";

    public void menu() {
        System.out.println("1  - Cadastrar cliente");
        System.out.println("2  - Buscar cliente");
        System.out.println("3  - Atualizar cliente");
        System.out.println("4  - Deletar cliente");
        System.out.println("5  - Cadastrar serviço");
        System.out.println("6  - Buscar serviço");
        System.out.println("7  - Atualizar serviço");
        System.out.println("8  - Deletar serviço");
        System.out.println("9  - Novo pedido");
        System.out.println("10 - Buscar pedido");
        System.out.println("11 - Buscar pedido por nome cliente");
        System.out.println("12 - Sair");
    }

    public void pause() {
        System.out.println("Press any key to continue...");
    }

    public boolean select(Operacoes operacoes) {
        Scanner scn = new Scanner(System.in);
        String enter = scn.next();
        scn.close();

        switch (enter) {
            case CADASTRAR_CLIENTE:
                operacoes.cadastrarCliente();
                return false;

            case BUSCAR_CLIENTE:
                operacoes.buscarCliente();
                return false;

            case ATUALIZAR_CLIENTE:
                operacoes.atualizarCliente();
                return false;

            case DELETAR_CLIENTE:
                operacoes.deletarCliente();
                return false;

            case CADASTRAR_SERVICO:
                operacoes.cadastrarServico();
                return false;

            case BUSCAR_SERVICO:
                operacoes.buscarServico();
                return false;

            case ATUALIZAR_SERVICO:
                operacoes.atualizarServico();
                return false;

            case DELETAR_SERVICO:
                operacoes.deletarServico();
                return false;

            case NOVO_PEDIDO:
                operacoes.novoPedido();
                return false;

            case BUSCAR_PEDIDO:
                operacoes.buscarPedido();
                return false;

            case BUSCAR_PEDIDO_NOMECLIENTE:
                operacoes.buscarPedidoPorNomeCliente();
                return false;

            case SAIR:
                System.out.println("Saindo...");
                return true;

            default:
                System.out.println("Invalid operation..");
                return false;
        }
    }

    public void Run() {
        boolean exit = false;
        Operacoes operacoes = new Operacoes();
        while (!exit) {
            menu();
            exit = select(operacoes);
            pause();
        }
    }
}
