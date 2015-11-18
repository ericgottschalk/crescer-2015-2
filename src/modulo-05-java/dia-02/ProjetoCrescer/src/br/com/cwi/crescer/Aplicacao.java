package br.com.cwi.crescer;

import java.sql.SQLException;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();
            Cliente cliente = new Cliente();
            // cliente.idCliente = 1;
            // cliente.nmCliente = "Eric";
            cliente.nrCpf = "12312312312";
            System.out.println(dao.find(cliente));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
