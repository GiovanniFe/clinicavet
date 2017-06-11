package com.clinicavet;

import com.dao.ConsultaDAO;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        new ConsultaDAO().create("2017-06-11", "historico do animal");
//        Animal animal = new Animal(2, "giovanni ferreira", 22, 2);
//        new AnimalDAO().update(animal);
    }

}
