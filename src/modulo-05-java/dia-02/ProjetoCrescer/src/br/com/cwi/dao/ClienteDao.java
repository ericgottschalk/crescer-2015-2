package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;

public class ClienteDao {

    public void add(Cliente cliente) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Cliente (idCliente, nmCliente, nrCpf) VALUES (?, ?, ?)");
            preparedStatement.setLong(1, cliente.idCliente);
            preparedStatement.setString(2, cliente.nmCliente);
            preparedStatement.setString(3, cliente.nrCpf);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Cliente> find() throws SQLException {
        List<Cliente> list = new ArrayList<Cliente>();
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT idCliente, nmCliente, nrCpf FROM Cliente");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Cliente cliente = this.resultSetToCliente(result);
                list.add(cliente);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return list;
    }

    private Cliente resultSetToCliente(ResultSet set) throws SQLException {
        Cliente cliente = new Cliente();
        cliente.idCliente = set.getLong(1);
        cliente.nmCliente = set.getString(2);
        cliente.nrCpf = set.getString(3);

        return cliente;
    }
}
