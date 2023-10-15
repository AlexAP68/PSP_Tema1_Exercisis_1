package Exercisi2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ExercicisMultiproces2 {
    public static void main(String[] args) {
        try {
            // Crear el proceso hijo
            ProcessBuilder builder = new ProcessBuilder("java", "src/Exercisi2/ExercicisMultiproces2_ModificarString.java");
            Process process = builder.start();

            // Obtener streams de entrada/salida del proceso hijo
            BufferedReader childInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            OutputStream childOutput = process.getOutputStream();

            // Obtener entrada estándard del proceso padre
            BufferedReader parentInput = new BufferedReader(new InputStreamReader(System.in));

            String line;

            while ((line = parentInput.readLine()) != null) {
                // Enviar línea al proceso hijo
                childOutput.write((line + "\n").getBytes());
                childOutput.flush();

                // Leer la respuesta del proceso hijo
                String childResponse = childInput.readLine();
                System.out.println("El PARE diu: " + childResponse);
            }

            // Cerrar el proceso hijo
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
