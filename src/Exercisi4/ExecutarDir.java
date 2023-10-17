package Exercisi4;

import java.io.File;
import java.io.IOException;

public class ExecutarDir {
    public static void main(String[] args) {
        // Configuració de comandes
        String command = "cmd";
        String arg = "/c dir";
        String outputFile = "sortida.txt";

        try {
            // Configuració del procés
            ProcessBuilder processBuilder = new ProcessBuilder(command, arg);
            processBuilder.directory(new File(System.getProperty("user.home")));
            processBuilder.redirectOutput(ProcessBuilder.Redirect.to(new File(outputFile)));

            // Inici del procés
            Process process = processBuilder.start();

            // Espera fins que el procés acabi
            int exitCode = process.waitFor();

            // Gestió de resultats
            if (exitCode == 0) {
                System.out.println("Fitxer creat");
            } else {
                System.out.println("Error en crear el fitxer");
            }
        } catch (IOException | InterruptedException e) {
            // Gestió d'excepcions
            e.printStackTrace();
        }
    }
}
