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
            PreparedStatement preparedStatement = con.prepareStatement("INSERT INTO Servico (idServico) VALUES (?)");
            preparedStatement.setString(1, servico.dsServico);
            preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new SQLException(e);
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

    private Servico resultSetToServico(ResultSet set) throws SQLException {
        Servico servico = new Servico();
        servico.idServico = set.getLong(1);
        servico.dsServico = set.getString(2);

        return servico;
    }
}
