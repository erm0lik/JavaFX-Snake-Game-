module com.example.javafxsnakegame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.javafxsnakegame to javafx.fxml;
    exports com.example.javafxsnakegame;
}