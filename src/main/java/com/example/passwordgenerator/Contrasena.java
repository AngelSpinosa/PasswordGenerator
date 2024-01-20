package com.example.passwordgenerator;

import java.util.Random;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;


public class Contrasena {

    private static final String caracteresMayusculas = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String caracteresMinusculas = "abcdefghijklmnopqrstuvwxyz";
    private static final String caracteresNumeros = "0123456789";
    private static final String caracteresSignos = "!@#$%^&*()-_=+[]{}|;:,.<>?";

    String caracteresPermitidos = caracteresMayusculas + caracteresMinusculas + caracteresNumeros + caracteresSignos;
    private boolean usarMayusculas;
    private boolean usarMinusculas;
    private boolean usarNumeros;
    private boolean usarSignos;

    // Constructor y otros métodos

    public void setUsarMayusculas(boolean usarMayusculas) {
        this.usarMayusculas = usarMayusculas;
    }

    public void setUsarMinusculas(boolean usarMinusculas) {
        this.usarMinusculas = usarMinusculas;
    }

    public void setUsarNumeros(boolean usarNumeros) {
        this.usarNumeros = usarNumeros;
    }

    public void setUsarSignos(boolean usarSignos) {
        this.usarSignos = usarSignos;
    }
    private int longitud = 1;
    //Constructor
    public Contrasena(){
        this.longitud = longitud;
    }
    public void setLongitud(int nuevaLongitud){
        if (nuevaLongitud >= 0 && nuevaLongitud <= 25){
            this.longitud = nuevaLongitud;
        }
    }

    //Metodos
    public String GenerarContrasena() {
        StringBuilder contrasenaGenerada = new StringBuilder();
        ActualizarCaracteresPermitidos();
        int longitud = ObtenerLongitud();
        Random rand = new Random();
        for (int i = 0; i < longitud; i++) {
            int indice = rand.nextInt(caracteresPermitidos.length());
            char caracter = caracteresPermitidos.charAt(indice);
            contrasenaGenerada.append(caracter);
        }
        if (caracteresPermitidos.isEmpty()) {
            return "No se han seleccionado caracteres para generar la contraseña.";
        }

        return contrasenaGenerada.toString();
    }


    public void CopiarContra(String contracopiada) {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();
        content.putString(contracopiada); // Establece el contenido en el portapapeles
        clipboard.setContent(content);
    }


    public int ObtenerLongitud(){
        return this.longitud;
    }

    public int DisminuirLongitud(){
        return this.ObtenerLongitud() - 1;
    }
    public int AumentarLongitud(){
        return this.ObtenerLongitud() + 1;
    }

    // Agrega este método en la clase Contrasena
    private void ActualizarCaracteresPermitidos() {
        caracteresPermitidos = "";
        if (usarMayusculas) {
            caracteresPermitidos += caracteresMayusculas;
        }
        if (usarMinusculas) {
            caracteresPermitidos += caracteresMinusculas;
        }
        if (usarNumeros) {
            caracteresPermitidos += caracteresNumeros;
        }
        if (usarSignos) {
            caracteresPermitidos += caracteresSignos;
        }
    }

}

