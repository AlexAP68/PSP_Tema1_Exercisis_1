package Exercisi1;

import java.io.*;

public class ExercicisMultiproces1 {
    public static void main(String[] args) {
        while (true) {
            System.out.print("Introdueix un nombre o escriu 'exit' per acabar: ");

            // Llegir l'entrada de l'usuari
            String input = new java.util.Scanner(System.in).nextLine();

            // Sortir del bucle si escrius 'exit'
            if (input.equals("exit")) {
                break;
            }

            try {
                // Convertir la cadena d'entrada a un enter
                int num = Integer.parseInt(input);

                // Crear un procés Exercisi3.fill
                ProcessBuilder builder = new ProcessBuilder("java", "src/Exercisi1/Exercisi1.ExercicisMultiproces1_ParellSenar.java", Integer.toString(num));

                // Redirigir entrada/sortida d'errors del procés Exercisi3.fill al procés Exercisi3.pare.Exercisi3.fill.pare
                builder.redirectInput(ProcessBuilder.Redirect.INHERIT);
                builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
                builder.redirectError(ProcessBuilder.Redirect.INHERIT);

                // Iniciar el procés Exercisi3.fill
                Process process = builder.start();

                // Esperar que el procés Exercisi3.fill finalitzi
                process.waitFor();
            } catch (NumberFormatException | IOException | InterruptedException e) {
                System.out.println("Error: Introdueix un nombre vàlid.");
            }
        }
    }
}
