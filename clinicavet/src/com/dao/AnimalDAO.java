package com.dao;

import com.sql.ConexaoMySQL;
import com.vo.Animal;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AnimalDAO {

    public void create(String nome, int idade, int sexo) {
        new ConexaoMySQL().executeQuery("INSERT INTO animal VALUES ('" + nome +"', "));
    }

    public void delete(Animal animal) {

    }

    public List<Animal> retrieveAll() {

    }

    public Animal retrieve(int id) {

    }

    public void update(Animal animal) {
    
    }
}
