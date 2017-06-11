package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Giovanni
 */
public class TratamentoDAO {

    public void create(String dataInicial, String dataFinal) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO tratamento (dataInicial, dataFinal) VALUES (?, ?)");
            stmt.setString(1, dataInicial);
            stmt.setString(2, dataFinal);

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
