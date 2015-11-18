package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Cliente;
import br.com.cwi.model.Pedido;

public class PedidoDao {

    public void add(Pedido pedido) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO Pedido (idPedido, idCLiente, dsPedido) VALUES (pedido_seq.nextval, ?, ?)");
            statement.setLong(1, pedido.Cliente.idCliente);
            statement.setString(2, pedido.dsPedido);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(Pedido pedido) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("UPDATE Pedido SET dsPedido = ?");
            statement.setString(1, pedido.dsPedido);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(Pedido pedido) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("DELETE FROM Pedido WHERE idPedido = ?");
            statement.setLong(1, pedido.idPedido);
            statement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Pedido load(long id) throws SQLException {
        Pedido pedido = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT P.idPedido, P.dsPedido, P.idCliente, C.nmCliente, C.nrCpf FROM Pedido P"
                    + " INNER JOIN Cliente C ON P.idCliente = C.idCliente"
                    + " WHERE P.idPedido = ?");
            statement.setLong(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                pedido = this.resultSetToPedido(result);
            }

            return pedido;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find() throws SQLException {
        List<Pedido> list = new ArrayList<Pedido>();
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT P.idPedido, P.dsPedido, P.idCliente, C.nmCliente, C.nrCpf FROM Pedido P"
                    + " INNER JOIN Cliente C ON P.idCliente = C.idCliente");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pedido pedido = this.resultSetToPedido(result);
                list.add(pedido);
            }

            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Pedido> find(String nomeCliente) throws SQLException {
        List<Pedido> list = new ArrayList<Pedido>();
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT P.idPedido, P.dsPedido, P.idCliente, C.nmCliente, C.nrCpf FROM Pedido P"
                    + " INNER JOIN Cliente C ON P.idCliente = C.idCliente"
                    + " WHERE C.nmCliente LIKE ?");
            statement.setString(1, nomeCliente + '%');
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Pedido pedido = this.resultSetToPedido(result);
                list.add(pedido);
            }

            return list;
        } catch (SQLException e) {
            throw e;
        }
    }

    private Pedido resultSetToPedido(ResultSet set) throws SQLException {
        Pedido pedido = new Pedido();
        pedido.idPedido = set.getLong(1);
        pedido.dsPedido = set.getString(2);
        pedido.Cliente = new Cliente();
        pedido.Cliente.idCliente = set.getLong(3);
        pedido.Cliente.nmCliente = set.getString(4);
        pedido.Cliente.nrCpf = set.getString(5);
        return pedido;
    }
}
