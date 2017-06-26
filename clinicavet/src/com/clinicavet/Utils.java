package com.clinicavet;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 *
 * @author giovanni
 */
public class Utils {

    public static Button getButton(String text, int width, int height) {
        Button btn = new Button(text);
        btn.setMinSize(width, height);
        btn.setStyle("-fx-background-color: \n"
                + "#a6b5c9,\n"
                + "linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n"
                + "linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n"
                + "-fx-text-fill: #242d35;\n"
                + "-fx-font-family: \"Helvetica\";\n"
                + "-fx-font-size: 12px;\n"
                + "-fx-text-fill: white;");
        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> {
            btn.setStyle("-fx-background-color: \n"
                    + "#B7c6dA,\n"
                    + "linear-gradient(#414953 0%, #4f6688 20%, #486185 100%),\n"
                    + "linear-gradient(#879bb6 0%, #95adcc 5%, #6988b3 50%, #597bab 51%, #5b7dac 100%);\n"
                    + "-fx-text-fill: #242d35;\n"
                    + "-fx-font-family: \"Helvetica\";\n"
                    + "-fx-font-size: 12px;\n"
                    + "-fx-text-fill: white;");
        });
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            btn.setStyle("-fx-background-color: \n"
                    + "#a6b5c9,\n"
                    + "linear-gradient(#303842 0%, #3e5577 20%, #375074 100%),\n"
                    + "linear-gradient(#768aa5 0%, #849cbb 5%, #5877a2 50%, #486a9a 51%, #4a6c9b 100%);\n"
                    + "-fx-text-fill: #242d35;\n"
                    + "-fx-font-family: \"Helvetica\";\n"
                    + "-fx-font-size: 12px;\n"
                    + "-fx-text-fill: white;");
        });

        btn.addEventHandler(MouseEvent.MOUSE_ENTERED, e -> btn.getScene().setCursor(Cursor.HAND));
        btn.addEventHandler(MouseEvent.MOUSE_EXITED, e -> btn.getScene().setCursor(Cursor.DEFAULT));
        return btn;
    }
}
