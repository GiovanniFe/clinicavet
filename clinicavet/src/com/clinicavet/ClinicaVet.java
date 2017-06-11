package com.clinicavet;

import com.dao.AnimalDAO;
import com.vo.Animal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giovanni
 */
public class ClinicaVet {

    public static void main(String[] args) {
        List<Animal> animalList = new ArrayList<Animal>();
        animalList = new AnimalDAO().retrieveAll();
        for (Animal a : animalList) {
            System.out.print(a.getNome() + " ");
            System.out.print(a.getIdade() + " ");
            System.out.print(a.getSexo() + " ");
            System.out.println("   ");

        }
    }

}
