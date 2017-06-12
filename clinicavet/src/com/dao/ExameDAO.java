package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Exame;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class ExameDAO {

    public final String NOME_TABELA = "exame";

    public Exame create(Exame exame) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (descricao) VALUES (?)");
            stmt.setString(1, exame.getDescricao());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
            exame.setId(conexao.getMaxId(NOME_TABELA));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exame;
    }

    public void delete(Exame exame) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, exame.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Exame> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Exame> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String descricao = rs.getString("descricao");
                list.add(new Exame(id, descricao));
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

    public Exame retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Exame exame = null;
            if (rs.next()) {
                String descricao = rs.getString("descricao");
                exame = new Exame(id, descricao);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return exame;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Exame exame) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA
                    + " SET descricao = ? WHERE id = ?");
            stmt.setString(1, exame.getDescricao());
            stmt.setInt(2, exame.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
