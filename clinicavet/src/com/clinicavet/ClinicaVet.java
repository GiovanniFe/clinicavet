package com.clinicavet;

import com.dao.AnimalDAO;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        new AnimalDAO().create("giovanni", 20, 1);
    }

}
