package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import com.vo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class ClienteDAO {
    
    public final String NOME_TABELA = "cliente";
    
    public void create(String nome, String endereco, String telefone, Long cep, String email) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO " + NOME_TABELA + " (nome, endereco, telefone, cep, email)"
                    + " VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setString(2, endereco);
            stmt.setString(3, telefone);
            stmt.setLong(4, cep);
            stmt.setString(5, email);

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Cliente cliente) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("DELETE FROM " + NOME_TABELA + " cliente WHERE id = ?");
            stmt.setInt(1, cliente.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cliente> retrieveAll() {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA);
            ResultSet rs = stmt.executeQuery();

            List<Cliente> list = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                long cep = rs.getLong("cep");
                String email = rs.getString("email");
                list.add(new Cliente(id, nome, endereco, telefone, cep, email));
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

    public Cliente retrieve(int id) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("SELECT * FROM " + NOME_TABELA + " WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            Cliente cliente = null;
            if (rs.next()) {
                String nome = rs.getString("nome");
                String endereco = rs.getString("endereco");
                String telefone = rs.getString("telefone");
                long cep = rs.getLong("cep");
                String email = rs.getString("email");
                cliente = new Cliente(id, nome, endereco, telefone, cep, email);
            }
            rs.close();
            stmt.close();
            conexao.FecharConexao();
            return cliente;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Cliente cliente) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE " + NOME_TABELA + 
                    " SET nome = ?, endereco = ?, telefone = ?, cep = ?, email = ? WHERE id = ?");
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setLong(5, cliente.getCep_cli());
            stmt.setInt(6, cliente.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
