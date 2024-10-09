package com.example.maquinaexpendedora;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MaquinaExpendedora extends Application {

    private Label etiquetaTotal = new Label("Total: 0.00€");
    private double total = 0.0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage ventanaPrincipal) {
        ventanaPrincipal.setTitle("Máquina Expendedora");

        Button producto1 = new Button("Coca-Cola - 1.50€");
        Button producto2 = new Button("Agua - 1.00€");
        Button producto3 = new Button("Sandwich - 2.50€");
        Button producto4 = new Button("Patatas - 1.20€");
        Button producto5 = new Button("Chocolate - 2.00€");
        Button producto6 = new Button("Café - 1.00€");

        GridPane cuadrículaProductos = new GridPane();
        cuadrículaProductos.setPadding(new Insets(10));
        cuadrículaProductos.setHgap(10);
        cuadrículaProductos.setVgap(10);

        cuadrículaProductos.add(producto1, 0, 0);
        cuadrículaProductos.add(producto2, 1, 0);
        cuadrículaProductos.add(producto3, 2, 0);
        cuadrículaProductos.add(producto4, 0, 1);
        cuadrículaProductos.add(producto5, 1, 1);
        cuadrículaProductos.add(producto6, 2, 1);

        Button moneda10c = new Button("0.10€");
        Button moneda20c = new Button("0.20€");
        Button moneda50c = new Button("0.50€");
        Button moneda1 = new Button("1.00€");
        Button moneda2 = new Button("2.00€");

        HBox cajaMonedas = new HBox(10, moneda10c, moneda20c, moneda50c, moneda1, moneda2);
        cajaMonedas.setPadding(new Insets(10));

        Button botonComprar = new Button("Comprar");
        Button botonCancelar = new Button("Cancelar");

        VBox cajaAcciones = new VBox(10, etiquetaTotal, botonComprar, botonCancelar);
        cajaAcciones.setPadding(new Insets(10));

        Label etiquetaMensaje = new Label();
        VBox cajaMensajes = new VBox(10, etiquetaMensaje);
        cajaMensajes.setPadding(new Insets(10));

        VBox layoutPrincipal = new VBox(10, cuadrículaProductos, cajaMonedas, cajaAcciones, cajaMensajes);
        Scene escena = new Scene(layoutPrincipal, 400, 300);

        producto1.setOnAction(e -> seleccionarProducto(1.50, "Coca-Cola", etiquetaMensaje));
        producto2.setOnAction(e -> seleccionarProducto(1.00, "Agua", etiquetaMensaje));
        producto3.setOnAction(e -> seleccionarProducto(2.50, "Sandwich", etiquetaMensaje));
        producto4.setOnAction(e -> seleccionarProducto(1.20, "Patatas", etiquetaMensaje));
        producto5.setOnAction(e -> seleccionarProducto(2.00, "Chocolate", etiquetaMensaje));
        producto6.setOnAction(e -> seleccionarProducto(1.00, "Café", etiquetaMensaje));

        moneda10c.setOnAction(e -> añadirDinero(0.10));
        moneda20c.setOnAction(e -> añadirDinero(0.20));
        moneda50c.setOnAction(e -> añadirDinero(0.50));
        moneda1.setOnAction(e -> añadirDinero(1.00));
        moneda2.setOnAction(e -> añadirDinero(2.00));

        botonComprar.setOnAction(e -> comprarProducto(etiquetaMensaje));
        botonCancelar.setOnAction(e -> cancelarOperacion(etiquetaMensaje));

        ventanaPrincipal.setScene(escena);
        ventanaPrincipal.show();
    }

    private void seleccionarProducto(double precio, String nombreProducto, Label etiquetaMensaje) {
        total = precio;
        etiquetaTotal.setText("Total: " + String.format("%.2f", total) + "€");
        etiquetaMensaje.setText("Producto seleccionado: " + nombreProducto);
    }

    private void añadirDinero(double moneda) {
        total += moneda;
        etiquetaTotal.setText("Total: " + String.format("%.2f", total) + "€");
    }

    private void comprarProducto(Label etiquetaMensaje) {
        if (total >= 1.00) { // Precio mínimo de ejemplo
            etiquetaMensaje.setText("Gracias por su compra.");
            etiquetaTotal.setText("Total: 0.00€");
            total = 0;
        } else {
            etiquetaMensaje.setText("Saldo insuficiente.");
        }
    }

    private void cancelarOperacion(Label etiquetaMensaje) {
        total = 0;
        etiquetaTotal.setText("Total: 0.00€");
        etiquetaMensaje.setText("Operación cancelada.");
    }
}

