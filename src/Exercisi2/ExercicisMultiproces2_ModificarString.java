package Exercisi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExercicisMultiproces2_ModificarString {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line;

            while ((line = reader.readLine()) != null) {
                // Transformar a mayúsculas y reemplazar vocales
                String modifiedLine = line.toUpperCase().replaceAll("[AEIOU]", "_");
                System.out.println("El Fill diu: " + modifiedLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

