module com.example.calculaterjavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.calculaterjavafx to javafx.fxml;
    exports com.example.calculaterjavafx;
    exports com.example.calculaterjavafx.Controller;
    opens com.example.calculaterjavafx.Controller to javafx.fxml;
}