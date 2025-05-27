package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exercise32 {

    public static void main(String[] args) {
        String string = generateUserInputToSave();
        if (string.isBlank()) {
            System.out.println("No se ha introducido ningún texto.");
        } else {
            String savedString = generateStringToSave(string);
            System.out.println("Texto guardado: " + savedString);
        }

    }

    public static String generateStringToSave(String string) {
        if (string == null || string.isBlank()) {
            throw new IllegalArgumentException("El texto no puede ser nulo o estar vacío.");
        }
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new java.io.FileWriter("src/main/resources/data.txt", true)))) {
            writer.println(string);
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage(), e);
        }
        return string;

    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        String ruta = "src/main/resources/data.txt";

        try ( BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            writer.write(string);
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage(), e);
        }
    }
}
