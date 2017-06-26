package com.controller;

import com.dao.AnimalDAO;
import com.view.CadAnimalView;
import com.vo.Animal;

/**
 *
 * @author Giovanni
 */
public class CadAnimalController extends CadAnimalView {

    private CadAnimalView v;

    public CadAnimalController(CadAnimalView view) {
        v = view;
    }

    public void salvar() {
        new AnimalDAO().create(new Animal(0, v.getTxtNome().getText(), Integer.parseInt(v.getTxtIdade().getText()),
                v.getCbSexo().getSelectionModel().getSelectedIndex()));
    }

}
