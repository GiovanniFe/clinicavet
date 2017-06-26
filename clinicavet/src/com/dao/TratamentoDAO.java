package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Tratamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class TratamentoDAO {

    public final String NOME_TABELA = "tratamento";
    
    public Tratamento create(Tratamento tratamento) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (dataInicial, dataFinal) VALUES (?, ?)");
            stmt.setString(1, tratamento.getDataInicial());
            stmt.setString(2, tratamento.getDataFinal());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
            tratamento.setId(conexao.getMaxId(NOME_TABELA));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamento;
    }

    public void delete(Tratamento tratamento) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, tratamento.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tratamento> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Tratamento> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String dataInicial = rs.getString("dataInicial");
                String dataFinal = rs.getString("dataFinal");
                list.add(new Tratamento(id, dataInicial, dataFinal));
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Tratamento retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Tratamento tratamento = null;
            if (rs.next()) {
                String dataInicial = rs.getString("dataInicial");
                String dataFinal = rs.getString("dataFinal");
                tratamento = new Tratamento(id, dataInicial, dataFinal);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return tratamento;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Tratamento tratamento) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA
                    + " SET dataInicial = ?, dataFinal = ? WHERE id = ?");
            stmt.setString(1, tratamento.getDataInicial());
            stmt.setString(2, tratamento.getDataFinal());
            stmt.setInt(3, tratamento.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
