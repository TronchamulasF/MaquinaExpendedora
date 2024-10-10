module com.example.maquinaexpendedora1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.maquinaexpendedora1 to javafx.fxml;
    exports com.example.maquinaexpendedora1;
}