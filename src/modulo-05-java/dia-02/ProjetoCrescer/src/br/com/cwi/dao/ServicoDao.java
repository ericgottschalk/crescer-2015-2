package br.com.cwi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.cwi.jdbc.ConnectionFactory;
import br.com.cwi.model.Servico;

public class ServicoDao {

    public void add(Servico servico) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Servico (idServico, dsServico) VALUES (servico_seq.nextval, ?)");
            preparedStatement.setString(1, servico.dsServico);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void update(Servico servico) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("UPDATE Servico SET dsServico = ? WHERE idServico = ?");
            preparedStatement.setString(1, servico.dsServico);
            preparedStatement.setLong(2, servico.idServico);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(long id) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("DELETE FROM Servico WHERE idServico = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }
    }

    public Servico load(long id) throws SQLException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatment = con.prepareStatement("SELECT idServico, dsServico FROM Servico WHERE idServico = ?");
            preparedStatment.setLong(1, id);
            ResultSet result = preparedStatment.executeQuery();
            Servico servico = null;
            if (result.next()) {
                servico = this.resultSetToServico(result);
            }

            return servico;
        } catch (SQLException e) {
            throw e;
        }
    }

    public List<Servico> find() throws SQLException {
        List<Servico> list = new ArrayList<Servico>();
        try (Connection con = new ConnectionFactory().getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT isServico, dsServico FROM Servico");
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Servico servico = this.resultSetToServico(result);
                list.add(servico);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
        return list;
    }

    public List<Servico> find(Servico servico) throws SQLException {
        List<Servico> list = new ArrayList<Servico>();
        int i = 0, ds = 0, id = 0;
        boolean hasId = servico.idServico > 0;
        boolean hasDs = servico.dsServico != null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            StringBuilder command = new StringBuilder();
            command.append("SELECT idServico, dsServico FROM Servico WHERE 1 = 1 ");
            if (hasId) {
                command.append("AND idServico = ? ");
                id = ++i;
            }
            if (hasDs) {
                command.append("AND dsServico = ? ");
                ds = ++i;
            }
            PreparedStatement preparedStatement = con.prepareStatement(command.toString());
            preparedStatement.setString(1, servico.dsServico == null ? "" : servico.dsServico);
            if (hasId) {
                preparedStatement.setLong(id, servico.idServico);
            }

            if (hasDs) {
                preparedStatement.setString(ds, servico.dsServico);
            }

            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                Servico servicoBuscado = this.resultSetToServico(result);
                list.add(servicoBuscado);
            }

            return list;

        } catch (SQLException e) {
            throw e;
        }
    }

    private Servico resultSetToServico(ResultSet set) throws SQLException {
        Servico servico = new Servico();
        servico.idServico = set.getLong(1);
        servico.dsServico = set.getString(2);

        return servico;
    }
}
