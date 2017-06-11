package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Consulta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class ConsultaDAO {

    public final String NOME_TABELA = "consulta";

    public void create(Consulta consulta) { 
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (data, historico) VALUES (?, ?)");
            stmt.setString(1, consulta.getData());
            stmt.setString(2, consulta.getHistorico());

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Consulta consulta) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, consulta.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Consulta> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Consulta> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String data = rs.getString("data");
                String historico = rs.getString("historico");
                list.add(new Consulta(id, data, historico));
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

    public Consulta retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Consulta consulta = null;
            if (rs.next()) {
                String data = rs.getString("data");
                String historico = rs.getString("historico");
                consulta = new Consulta(id, data, historico);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return consulta;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Consulta consulta) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA
                    + " SET data = ?, historico = ? WHERE id = ?");
            stmt.setString(1, consulta.getData());
            stmt.setString(2, consulta.getHistorico());
            stmt.setInt(3, consulta.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
