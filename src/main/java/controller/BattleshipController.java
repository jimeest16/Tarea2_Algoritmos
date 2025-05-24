package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import domain.HashTableTDA;
import ucr.lab.util.FXUtil;

import static ucr.lab.util.Utility.compare;

public class BattleshipController {

    @FXML
    private Label counterLabel;

    @FXML
    private GridPane board;

    private final String[] posicionLetters = "ABCDEFGHIJ".split("");
    private final int size = 10;

    private HashTableTDA table;

    private final String[] ships = {
            "A1", "A2", "A3",
            "C10", "D10",
            "J8", "J9", "J10",
            "I3", "I4",
            "E5", "E6",
            "F8", "G8"// podemos añadir mas
    };

    private int barcosEncontrados = 0;
    private final int totalBarcos = ships.length;

    private int intentos = 0;
    private final int maxIntentos = size * size;// en total 20 intentos

    @FXML
    public void initialize() {
        createGame();
        createBoard();
    }

    // Crea la tabla hash y coloca los barcos
    private void createGame() {
        table = new HashTableTDA(50);
        table.createTable();
        for (String s : ships) {
            table.put(s, "barco");
        }
    }

    // Revisa si la posición contiene un barco
    public boolean positionInsert(String space) {
        String result = table.get(space);
        if (compare("barco", result) == 0) {// con el string de space
            table.put(space, "encontrado");//metod de hash table push
            return true;
        } else {
            table.put(space, "no encontrado");
            return false;
        }
    }

    // agrega tablero y control de cada espacio
    private void createBoard() {
        for (int fila = 0; fila < size; fila++) {// vefico con fila y col
            for (int col = 1; col <= size; col++) {
                String espacio = posicionLetters[fila] + col;// va a ser cada pos
                Button btn = new Button(espacio);// y cada pos es un boton
                btn.setPrefSize(80, 80);
                btn.setStyle("-fx-background-color: lightgray; -fx-font-weight: bold;");

                btn.setOnAction(e -> {
                    boolean movimientos = positionInsert(espacio);
                    intentos++;

                    if (movimientos) {// en true

                        barcosEncontrados++;// aumenta el counter
                        btn.setStyle("-fx-background-color: #e53935; -fx-text-fill: white; -fx-font-size: 17;");
                        btn.setText("\uD83D\uDEA2");// forma de pasar un image a text

                    } else {

                        btn.setStyle("-fx-background-color: #1e88e5; -fx-text-fill: white; -fx-font-size: 17;");
                        btn.setText("\uD83C\uDF0A");
                    }

                    btn.setDisable(true);
                    counterLabel.setText("Barcos encontrados: " + barcosEncontrados + " / " + totalBarcos);


                    if (barcosEncontrados == totalBarcos) {
                        FXUtil.informationDialog("¡BIENNN, HAZ ENCONTRADO LOS BARCOS.");

                    }


                    if (intentos == maxIntentos && barcosEncontrados < totalBarcos) {
                        FXUtil.informationDialog("El juego finalizo, tus intentos se acabaron.");

                    }
                });

                board.add(btn, col, fila);
            }
        }
    }

}
