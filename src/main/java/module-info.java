module com.example.maquinaexpendedora {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.maquinaexpendedora to javafx.fxml;
    exports com.example.maquinaexpendedora;
}