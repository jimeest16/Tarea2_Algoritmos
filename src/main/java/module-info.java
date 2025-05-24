module cr.ac.ucr.HashTables {
    requires javafx.controls;
    requires javafx.fxml;


    opens cr.ac.ucr.HashTables to javafx.fxml;
    exports cr.ac.ucr.HashTables;
    exports controller;
    opens controller to javafx.fxml;
}