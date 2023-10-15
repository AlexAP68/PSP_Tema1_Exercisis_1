package Exercisi3.fill;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Fill extends Thread {
    private PipedInputStream fillToPare;
    private PipedOutputStream pareToFill;

    public Fill(PipedInputStream fillToPare, PipedOutputStream pareToFill) {
        this.fillToPare = fillToPare;
        this.pareToFill = pareToFill;
    }

    @Override
    public void run() {
        try {
            rebreMissatge(fillToPare);
            enviarMissatge("Pues yo me meo", pareToFill, fillToPare);

            // Tanca els corrents
            fillToPare.close();
            pareToFill.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void rebreMissatge(InputStream in) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String missatge = new String(buffer, 0, bytesRead);
        System.out.println("Fill: rep missatge del Pare \"" + missatge + "\"");
    }

    private static void enviarMissatge(String missatge, OutputStream out, InputStream in) throws IOException {
        System.out.println("Fill: envia missatge del Pare");
        out.write(missatge.getBytes());
        out.flush();
        esperar(in);
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
