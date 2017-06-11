package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Giovanni
 */
public class EspecieDAO {

    public void create(String nome) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO especie (nome) VALUES (?)");
            stmt.setString(1, nome);

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
