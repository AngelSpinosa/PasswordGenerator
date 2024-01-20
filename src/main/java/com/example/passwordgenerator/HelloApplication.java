package com.example.passwordgenerator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Interfaz root = new Interfaz();
        Scene scene = new Scene(root, 600, 450);
        stage.setTitle("Generador de contraseñas MK1");
        URL urlicon = this.getClass().getResource("Candado.png");
        Image imageicon = new Image(urlicon.toString());
        stage.getIcons().add(imageicon);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}