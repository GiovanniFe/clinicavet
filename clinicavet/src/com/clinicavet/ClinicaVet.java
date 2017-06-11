package com.clinicavet;

import com.dao.AnimalDAO;
import com.vo.Animal;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        new AnimalDAO().create(new Animal(0, "teste", 2, 2));
    }
}
