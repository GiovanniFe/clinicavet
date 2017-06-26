package com.view;

import com.clinicavet.Utils;
import com.controller.CadAnimalController;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author giovanni
 */
public class CadAnimalView extends Application {

    private Pane layout;
    private Stage window;
    private Scene scene;
    protected Label lblTitle, lblNome, lblIdade, lblSexo;
    protected ComboBox<String> cbSexo;
    protected TextField txtNome, txtIdade;
    private Button btnSalvar;

    public void display() {
        launch();
    }

    @Override
    public void start(Stage w) throws Exception {
        window = w;
        setLabels();
        setTextFields();
        setComboBox();
        setButtons();
        addEvents();
        layout = new Pane();
        layout.getChildren().addAll(lblTitle, lblNome, lblIdade, lblSexo, cbSexo, txtNome, txtIdade, btnSalvar);
        scene = new Scene(layout, 385, 130);
        window.setScene(scene);
        window.show();
    }

    private void setLabels() {
        lblTitle = new Label("Cadastro Animal");
        lblTitle.setFont(new Font("Arial Black", 14));
        lblTitle.setLayoutX(10);
        lblTitle.setLayoutY(10);
        lblTitle.setTextFill(new Color(0, 0, 0, 1));

        lblNome = new Label("Nome:");
        lblNome.setFont(new Font("Arial", 14));
        lblNome.setLayoutX(10);
        lblNome.setLayoutY(40);
        lblNome.setTextFill(new Color(0, 0, 0, 1));

        lblIdade = new Label("Idade");
        lblIdade.setFont(new Font("Arial", 14));
        lblIdade.setLayoutX(10);
        lblIdade.setLayoutY(80);
        lblIdade.setTextFill(new Color(0, 0, 0, 1));

        lblSexo = new Label("Sexo");
        lblSexo.setFont(new Font("Arial", 14));
        lblSexo.setLayoutX(250);
        lblSexo.setLayoutY(40);
        lblSexo.setTextFill(new Color(0, 0, 0, 1));

    }

    private void setTextFields() {
        txtNome = new TextField();
        txtNome.setFont(new Font("Arial", 14));
        txtNome.setLayoutX(60);
        txtNome.setLayoutY(40);

        txtIdade = new TextField();
        txtIdade.setFont(new Font("Arial", 14));
        txtIdade.setLayoutX(60);
        txtIdade.setLayoutY(80);

    }

    private void setComboBox() {
        cbSexo = new ComboBox<>();
        cbSexo.setLayoutX(290);
        cbSexo.setLayoutY(40);
        List<String> list = new ArrayList<>();
        list.add("Macho");
        list.add("Fêmea");
        cbSexo.setItems(FXCollections.observableList(list));
        cbSexo.getSelectionModel().selectFirst();
    }

    private void setButtons() {
        btnSalvar = Utils.getButton("Salvar", 70, 30);
        btnSalvar.setLayoutX(300);
        btnSalvar.setLayoutY(80);
    }

    public ComboBox<String> getCbSexo() {
        return cbSexo;
    }

    public TextField getTxtNome() {
        return txtNome;
    }

    public TextField getTxtIdade() {
        return txtIdade;
    }

    private void addEvents() {
        btnSalvar.setOnAction(e -> {
            new CadAnimalController(this).salvar();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Veterinária");
            alert.setHeaderText("Animal salvo com sucesso!");
            alert.showAndWait();
        }
        );
    }

}
