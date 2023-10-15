package Exercisi1;

public class ExercicisMultiproces1_ParellSenar {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Error: Proporcione exactamente un número como argumento.");
            return;
        }

        try {
            int numero = Integer.parseInt(args[0]);
            if (numero % 2 == 0) {
                System.out.println("Es parell");
            } else {
                System.out.println("Es senar");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Introdueix un nombre vàlid.");
        }
    }
}
