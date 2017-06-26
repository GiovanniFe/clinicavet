package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Especie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class EspecieDAO {

    public final String NOME_TABELA = "especie";

    public void create(Especie especie) { 
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (nome) VALUES (?)");
            stmt.setString(1, especie.getNome());

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Especie especie) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, especie.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Especie> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Especie> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                list.add(new Especie(id, nome));
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

    public Especie retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Especie especie = null;
            if (rs.next()) {
                String nome = rs.getString("nome");
                especie = new Especie(id, nome);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return especie;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Especie especie) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA + " SET nome = ? WHERE id = ?");
            stmt.setString(1, especie.getNome());
            stmt.setInt(2, especie.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
