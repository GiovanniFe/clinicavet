package com.dao;

import com.vo.Animal;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class AnimalDAO {

    public void createAnimal(String nome, int idade, int sexo) {
        Animal animal = new Animal(nome, idade, sexo);
    }

    public void deleteAnimal(Animal animal) {

    }

    public List<Animal> getAllAnimals() {

    }

    public Animal getAnimal(int id) {

    }

    public void updateAnimal(Animal animal) {
    }
}
