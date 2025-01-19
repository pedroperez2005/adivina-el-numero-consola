import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int opcion, respuesta, maxValor = 0, numVidas = 0;
        char volverJugar;

        System.out.println("\n--- Bienvenid@ a 'Adivina el número' ---");

        do {
            do {
                System.out.println("Por favor, selecciona el nivel de dificultad:");
                System.out.println("1. Fácil\n2. Medio\n3. Difícil");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        maxValor = 10;
                        numVidas = 5;
                        break;
                    case 2:
                        maxValor = 20;
                        numVidas = 6;
                        break;
                    case 3:
                        maxValor = 30;
                        numVidas = 7;
                        break;
                    default:
                        System.out.println("Opción no válida");
                }
            } while (opcion < 1 || opcion > 3);

            int numeroRandom = rand.nextInt(maxValor) + 1;
            String vidaIcono = "❤️";

            System.out.println("Adivina el número (1-" + maxValor + "):");

            while (numVidas > 0) {
                System.out.print("\nVidas: " + vidaIcono.repeat(numVidas) + "\n");

                respuesta = sc.nextInt();

                if (respuesta < 1 || respuesta > maxValor) {
                    System.out.println("Ingresa un número entre " + 1 + " y " + maxValor);
                } else {
                    if (respuesta < numeroRandom) {
                        System.out.println("El número es más grande que " + respuesta);
                    } else if (respuesta > numeroRandom) {
                        System.out.println("El número es más pequeño que " + respuesta);
                    } else {
                        System.out.println("¡ADIVINASTE!");
                        break;
                    }
                    numVidas--;

                }
            }

            if (numVidas == 0) {
                System.out.println("--- Se terminaron tus vidas :( ---");
                System.out.println("--- El número era: " + numeroRandom + " ---");
            }

            do {
                System.out.println("¿Quieres volver a jugar? (s/n)");
                volverJugar = sc.next().charAt(0);
                if (volverJugar != 's' && volverJugar != 'n') {
                    System.out.println("Por favor, ingresa una opción correcta.");
                }
            } while (volverJugar != 's' && volverJugar != 'n');
        } while (volverJugar == 's');
    }
}