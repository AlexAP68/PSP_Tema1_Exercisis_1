package Exercisi3.pare;

import Exercisi3.fill.Fill;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Pare {
    public static void main(String[] args) {
        try {
            PipedOutputStream pareToFill = new PipedOutputStream();
            PipedInputStream fillToPare = new PipedInputStream();

            fillToPare.connect(pareToFill);

            // Crea i inicia el Fill amb els corrents establerts
            Fill fill = new Fill(fillToPare, pareToFill);
            fill.start();

            // Comunica't amb el Fill
            enviarMissatge("Me cago", pareToFill, fillToPare);
            rebreMissatge(fillToPare);

            // Tanca els corrents
            pareToFill.close();
            fillToPare.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void enviarMissatge(String missatge, OutputStream out, InputStream in) throws IOException {
        System.out.println("Pare: envia missatge");
        out.write(missatge.getBytes());
        out.flush();
        esperar(in);
    }

    private static void rebreMissatge(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String missatge = new String(buffer, 0, bytesRead);
        System.out.println("Pare: rep missatge del Fill \"" + missatge + "\"");
    }

    private static void esperar(InputStream in) throws IOException {
        while (in.available() == 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
