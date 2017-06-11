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
public class ClienteDAO {
    //private String nome;
    //private String endereco;
    //private String telefone;
    //private Long cep;
    //private String email;
    public void create(String nome, int idade, int sexo) {
        ConexaoMySQL conexao = new ConexaoMySQL();
        try {
            PreparedStatement stmt = conexao.getConexaoMySQL().prepareStatement("INSERT INTO cliente (nome, endereco, telefone, cep, email)"
                    + " VALUES (?, ?, ?)");
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

    }

//    public List<Animal> retrieveAll() {
//
//    }

//    public Animal retrieve(int id) {
//
//    }

    public void update(Animal animal) {
    
    }
}
