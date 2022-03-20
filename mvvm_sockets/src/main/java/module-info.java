module dk.via {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.google.gson;

    opens dk.via.calculator.view to javafx.fxml;
    opens dk.via.calculator to javafx.fxml;

    exports dk.via.calculator;
}