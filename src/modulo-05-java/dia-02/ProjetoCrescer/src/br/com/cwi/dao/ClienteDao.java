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
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Cliente (idCliente, nmCliente, nrCpf) VALUES (cliente_seq.nextval, ?, ?)");
            preparedStatement.setString(1, cliente.nmCliente);
            preparedStatement.setString(2, cliente.nrCpf);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Cliente cliente) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE Cliente SET nmCliente = ?, nrCpf = ? WHERE idCliente = ?");
            preparedStatement.setString(1, cliente.nmCliente);
            preparedStatement.setString(2, cliente.nrCpf);
            preparedStatement.setLong(3, cliente.idCliente);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(long id) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Cliente WHERE idCliente = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Cliente load(long id) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatment = con.prepareStatement("SELECT idCliente, nmCliente, nrCpf FROM Cliente WHERE idCliente = ?");
            preparedStatment.setLong(1, id);
            ResultSet result = preparedStatment.executeQuery();
            Cliente cliente = null;
            if (result.next()) {
                cliente = this.resultSetToCliente(result);
            }

            return cliente;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Cliente> find() throws SQLException{
        List<Cliente> list = new ArrayList<Cliente>();
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT idCliente, nmCliente, nrCpf FROM Cliente");
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Cliente cliente = this.resultSetToCliente(result);
                list.add(cliente);
            }
        }catch(SQLException e){
            throw e;
        }
        return list;
    }

    public List<Cliente> find(Cliente cliente) throws SQLException {
        List<Cliente> list = new ArrayList<Cliente>();
        int i = 0, name = 0, id = 0, cpf = 0;
        boolean hasId = cliente.idCliente > 0;
        boolean hasName = cliente.nmCliente != null;
        boolean hasCpf = cliente.nrCpf != null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            StringBuilder command = new StringBuilder();
            command.append("SELECT idCliente, nmCliente, nrCpf FROM Cliente WHERE 1 = 1 ");
            if (hasId) {
                command.append("AND idCliente = ? ");
                id = ++i;
            }
            if (hasName) {
                command.append("AND nmCliente = ? ");
                name = ++i;
            }
            if (hasCpf) {
                command.append("AND nrCpf = ? ");
                cpf = ++i;
            }
            PreparedStatement preparedStatement = con.prepareStatement(command.toString());
            if (hasId) {
                preparedStatement.setLong(id, cliente.idCliente);
            }
            if (hasName) {
                preparedStatement.setString(name, cliente.nmCliente);
            }
            if (hasCpf) {
                preparedStatement.setString(cpf, cliente.nrCpf);
            }

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Cliente clienteBuscado = this.resultSetToCliente(result);
                list.add(clienteBuscado);
            }

            return list;

        } catch (SQLException e) {
            throw e;
        }
    }

    private Cliente resultSetToCliente(ResultSet set) throws SQLException{
        Cliente cliente = new Cliente();
        cliente.idCliente = set.getLong(1);
        cliente.nmCliente = set.getString(2);
        cliente.nrCpf = set.getString(3);

        return cliente;
    }
}
