package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Giovanni
 */
public class ConsultaDAO {

    public void create(String data, String historico) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO consulta (data, historico) VALUES (?, ?)");
            stmt.setString(1, data);
            stmt.setString(2, historico);

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
