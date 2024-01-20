package com.example.passwordgenerator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.text.Font;

/*
Para el diseño
Tipografías:
Titulo: Inter Black
Texto: Bricolage Grotesque
Colores:
Primario:
-Blanco (255,255,255)
-Esmeralda (61, 220, 150)
 */

public class Interfaz extends BorderPane {
    boolean chk1 = true;
    boolean chk2 = true;
    boolean chk3 = true;
    boolean chk4 = true;
    public Interfaz(){
        IniciarComponentes();
    }

    public void IniciarComponentes(){
        Label labelnohaycaracteres = new Label("Selecciona al menos un caracter para generar la contraseña");
        labelnohaycaracteres.setStyle("-fx-font-family: 'Inter Black'; -fx-font-size: 16; -fx-text-fill: rgb(0, 63, 145)");
        labelnohaycaracteres.setVisible(false);
        //Cargar la fuente
        Font.loadFont(getClass().getResourceAsStream("/resources/Inter-Black.ttf"), 10);
        //Objeto de la clase Contrasena
        Contrasena contrasena = new Contrasena();

        //Etiqueta del programa
        Label labeltitulo = new Label("Generador de contraseñas");
        labeltitulo.setStyle("-fx-font-family: 'Inter Black'; -fx-font-size: 40; -fx-text-fill: rgb(0, 63, 145);");

        //Contenedores
        VBox VboxCentro = new VBox();
        VboxCentro.setAlignment(Pos.CENTER);
        HBox HboxResultados = new HBox();
        HboxResultados.setAlignment(Pos.CENTER);
        HboxResultados.setSpacing(10);
        VBox vboxLongitud = new VBox();
        vboxLongitud.setAlignment(Pos.CENTER);
        //Longitud 2 y 3 van dentro del VBox Longitud
        HBox hboxLongitud2 = new HBox();
        hboxLongitud2.setAlignment(Pos.CENTER);
        hboxLongitud2.setSpacing(10);
        hboxLongitud2.setPrefHeight(35);
        HBox hBoxLongitud3 = new HBox();
        hBoxLongitud3.setAlignment(Pos.CENTER);
        hBoxLongitud3.setSpacing(10);
        hBoxLongitud3.setPrefHeight(50);
        HBox hboxConfigContrasena = new HBox();
        hboxConfigContrasena.setAlignment(Pos.CENTER);
        hboxConfigContrasena.setSpacing(5);
        hboxConfigContrasena.setPrefHeight(45);

        //Nodos
        //Para HboxResultados
        TextField txfContrasena = new TextField();
        txfContrasena.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 20px; " +
                        "-fx-stroke-width: 10; " +
                        "-fx-text-fill: white;"
        );
        txfContrasena.setPrefHeight(40);
        txfContrasena.setPrefWidth(250);
        //Inhabilitar la edición del TexField
        txfContrasena.setEditable(false);
        Button btnGenerar = new Button("Generar");
        btnGenerar.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 20px;"
        );
        Button btnCopiar = new Button("Copiar");
        btnCopiar.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-text-fill: white;" +
                        "-fx-background-radius: 20px;"
        );

        //Para hboxLongitud2
        Slider slidertamano = new Slider();
        slidertamano.setStyle(
                "-fx-control-inner-background: rgb(0, 63, 145);" +
                        "-fx-control-inner-background-alt: rgb(0, 63, 145);"
        );
        //Variable de la longitud de la contraseña
        int longitudActual = contrasena.ObtenerLongitud();
        Label labeltamanocontra = new Label("Tamaño: " + longitudActual);
        labeltamanocontra.setStyle("-fx-font-family: 'Bricolage Grotesque'; -fx-text-fill:rgb(0, 63, 145); -fx-font-size: 12");

        //Para hboxLongitud3
        Button btnmenorLong = new Button("<");
        btnmenorLong.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 50%;" +
                        " -fx-text-fill: white;"
        );
        Button btnmayorLong = new Button(">");
        btnmayorLong.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 50%; " +
                        "-fx-text-fill: white;"
        );

        //Para hboxConfigContrasena
        Label labelCaracteresUsados = new Label("Caracteres usados");
        labelCaracteresUsados.setStyle("-fx-font-family: 'Bricolage Grotesque';" +
                "-fx-text-fill: rgb(0, 63, 145); " +
                "-fx-font-size: 12");
        CheckBox checkboxmayus = new CheckBox("ABCD");
        checkboxmayus.setSelected(false);
        checkboxmayus.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 20px;" +
                        "-fx-font-family: 'Bricolage Grotesque';" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 5px 10px;"
        );
        CheckBox checkboxminus = new CheckBox("abcd");
        checkboxminus.setSelected(false);
        checkboxminus.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 20px;" +
                        "-fx-font-family: 'Bricolage Grotesque';" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 5px 10px;"
        );
        CheckBox checkboxNumbers = new CheckBox("1234");
        checkboxNumbers.setSelected(false);
        checkboxNumbers.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 20px;" +
                        "-fx-font-family: 'Bricolage Grotesque';" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 5px 10px;"
        );
        CheckBox checkboxSigns = new CheckBox("!#$%");
        checkboxSigns.setSelected(false);
        checkboxSigns.setStyle(
                "-fx-background-color: rgb(0, 63, 145);" +
                        "-fx-background-radius: 20px;" +
                        "-fx-font-family: 'Bricolage Grotesque';" +
                        "-fx-text-fill: white;" +
                        "-fx-padding: 5px 10px;" // Ajusta estos valores según tus necesidades
        );

        //Añadir los subnodos a los nodos
        setTop(labeltitulo);
        setCenter(VboxCentro);
        VboxCentro.getChildren().addAll(HboxResultados, vboxLongitud, hboxConfigContrasena);
        vboxLongitud.getChildren().addAll(hboxLongitud2,hBoxLongitud3);

        //Añadir los nodos a sus contenedores
        HboxResultados.getChildren().addAll(txfContrasena,btnGenerar,btnCopiar);
        hboxLongitud2.getChildren().addAll(slidertamano, labeltamanocontra);
        hBoxLongitud3.getChildren().addAll(btnmenorLong, btnmayorLong);
        hboxConfigContrasena.getChildren().addAll(
                labelCaracteresUsados,checkboxmayus,checkboxminus,checkboxNumbers,checkboxSigns
        );

        setMargin(getTop(), new Insets(20, 0, 0, 0));
        setAlignment(labeltitulo, Pos.CENTER);
        setAlignment(labelnohaycaracteres,Pos.CENTER);
        setBottom(labelnohaycaracteres);


        //Eventos
        // Evento para generar la contraseña
        btnGenerar.setOnAction(evt -> {
            // Verificar si al menos un CheckBox está seleccionado
            if (!checkboxmayus.isSelected() && !checkboxminus.isSelected() && !checkboxNumbers.isSelected() && !checkboxSigns.isSelected()) {
                labelnohaycaracteres.setVisible(true); // Mostrar el mensaje de advertencia
                txfContrasena.setText("");
                return; // Salir del evento sin generar la contraseña
            } else {
                labelnohaycaracteres.setVisible(false); // Ocultar el mensaje de advertencia
            }

            String contrasenagenerada = contrasena.GenerarContrasena();
            txfContrasena.setText(contrasenagenerada);
        });
        //Copiar la contraseña en el portapapeles
        btnCopiar.setOnAction(evt ->{
            String copiarContra = txfContrasena.getText();
            contrasena.CopiarContra(copiarContra);

        });
        //Cambiar la longitud de acuerdo al Slider
        slidertamano.setMax(25); //Para que el Slider no pueda moverse a mas de 25
        slidertamano.valueProperty().addListener((observable, oldValue, newValue) ->{
            int newLongitud = newValue.intValue(); // Obtener el valor entero del Slider
            contrasena.setLongitud(newLongitud); // Actualizar la longitud de la contraseña
            labeltamanocontra.setText("Tamaño: " + newLongitud); // Actualizar la etiqueta
        });

        //Disminuir el tamaño de la contraseña con un boton
        btnmenorLong.setOnAction(evt ->{
            int newLongitud = contrasena.DisminuirLongitud(); //variable que tiene el valor de la clase con la longitud -1
            slidertamano.setValue(newLongitud); //Actualizar el tamaño del Slider
            labeltamanocontra.setText("Tamaño: " + newLongitud); //Actualizar el label con la longitud
        });
        //Aumentar la longitud de la contraseña con un boton
        btnmayorLong.setOnAction(evt ->{
            int newLongitud = contrasena.AumentarLongitud(); //Variable que tiene el valor de la clase con la longitud +1
            slidertamano.setValue(newLongitud); //Actualizar el Slider
            labeltamanocontra.setText("Tamaño: " + newLongitud); //Actualizar el label con la longitud
        });

        //Eventos para los checkbox
        // Checkbox mayus
        checkboxmayus.setOnAction(evt -> {
            contrasena.setUsarMayusculas(checkboxmayus.isSelected());
        });
        // Checkbox minus
        checkboxminus.setOnAction(evt -> {
            contrasena.setUsarMinusculas(checkboxminus.isSelected());
        });
        // Checkbox Numbers
        checkboxNumbers.setOnAction(evt -> {
            contrasena.setUsarNumeros(checkboxNumbers.isSelected());
        });
        // Checkbox Signs
        checkboxSigns.setOnAction(evt -> {
            contrasena.setUsarSignos(checkboxSigns.isSelected());
        });

    }
}
