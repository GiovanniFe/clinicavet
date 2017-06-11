package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class VeterinarioDAO {

    public void create(String nome, String endereco, String telefone) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO veterinario (nome, endereco, telefone) VALUES (?, ?, ?)");
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

    public void delete(Animal animal) {

    }

//    public List<Animal> retrieveAll() {
//
//    }
//
//    public Animal retrieve(int id) {
//
//    }
    public void update(Animal animal) {

    }
}
