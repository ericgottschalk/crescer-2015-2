package br.com.cwi.crescer;

import java.sql.SQLException;

import br.com.cwi.dao.ClienteDao;
import br.com.cwi.model.Cliente;

public class Aplicacao {

    public static void main(String[] args) {
        try {
            ClienteDao dao = new ClienteDao();
            for (Cliente cliente : dao.find()) {
                System.out.println(cliente.toString());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
