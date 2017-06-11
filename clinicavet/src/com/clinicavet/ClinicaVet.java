package com.clinicavet;

import com.dao.AnimalDAO;
import com.vo.Animal;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
//        new AnimalDAO().create("giovanni", 20, 1);
        Animal animal = new Animal(2, "giovanni ferreira", 22, 2);
        new AnimalDAO().update(animal);
    }

}
