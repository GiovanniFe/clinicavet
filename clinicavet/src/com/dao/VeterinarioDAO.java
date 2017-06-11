package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Veterinario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class VeterinarioDAO {

    public final String NOME_TABELA = "veterinario";
    
    public void create(String nome, String endereco, String telefone) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (nome, endereco, telefone) VALUES (?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, telefone);

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Veterinario veterinario) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, veterinario.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Veterinario> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Veterinario> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                list.add(new Veterinario(id, nome, endereco, telefone));
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

    public Veterinario retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Veterinario veterinario = null;
            if (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                veterinario = new Veterinario(id, nome, endereco, telefone);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return veterinario;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Veterinario veterinario) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA
                    + " SET nome = ?, endereco = ?, telefone = ? WHERE id = ?");
            stmt.setString(1, veterinario.getNome());
            stmt.setString(2, veterinario.getEndereco());
            stmt.setString(3, veterinario.getTelefone());
            stmt.setInt(4, veterinario.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
