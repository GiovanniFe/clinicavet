package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Giovanni
 */
public class AnimalDAO {

    public void create(String nome, int idade, int sexo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO animal (nome, idade, sexo) VALUES (?, ?, ?)");
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, sexo);

            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Animal animal) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement preparedStatement = conexao.getConexaoMySQL().prepareStatement("DELETE FROM Animal WHERE id = ?");
            preparedStatement.setInt(1, animal.getId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public List<Animal> retrieveAll() {
//
//    }
//
//    public Animal retrieve(int id) {
//
//    }

    public void update(Animal animal) {
        try {
            ConexaoMySQL conexao = new ConexaoMySQL();
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("UPDATE Animal SET nome = ?, idade = ?, sexo = ? WHERE id = ?");
            stmt.setString(1, animal.getNome());
            stmt.setInt(2, animal.getIdade());
            stmt.setInt(3, animal.getSexo());
            stmt.setInt(4, animal.getId());
            stmt.execute();
            stmt.close();
            conexao.FecharConexao();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
