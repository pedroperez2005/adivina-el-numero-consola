import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int respuesta;
        int minValor = 1;
        int maxValor = 10;
        int numeroRandom = rand.nextInt(maxValor) + minValor;
        int numVidas = 5;
        String vidaIcono = "❤️";

        System.out.println("Adivina el número (1-10)");

        while (numVidas > 0) {
            System.out.print("\nVidas: " + vidaIcono.repeat(numVidas) + "\n");

            respuesta = sc.nextInt();

            if(respuesta < minValor || respuesta > maxValor){
                System.out.println("Ingresa un número entre " + minValor + " y " + maxValor);
            } else{
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
    }
}