module cr.ac.ucr.tarea2_algoritmos {
    requires javafx.controls;
    requires javafx.fxml;


    opens cr.ac.ucr.tarea2_algoritmos to javafx.fxml;
    exports cr.ac.ucr.tarea2_algoritmos;
    exports controller;
    opens controller to javafx.fxml;
}