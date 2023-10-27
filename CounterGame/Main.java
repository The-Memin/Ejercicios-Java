import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'counterGame' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static String counterGame(long n) {
        if (n == 1) {return "Richard";}
        long sigPotencia = 0;
        String[] participantes = {"Louise", "Richard"};
        String win = participantes[0];
        while (n != 1) {
            if (!esPotenciaDeDos(n)) {
                sigPotencia = encontrarPotenciaCercana(n);
                n = n - sigPotencia;
            }else{
                n = n/ 2;
            }
            if (n!= 1) {
                win = (win == participantes[0]) ? participantes[1]: participantes[0];
            }
        }
        return win;
    }
    public static boolean esPotenciaDeDos(long numero) {
        // Comprueba si el número tiene un solo bit establecido
        return (numero > 0) && ((numero & (numero - 1)) == 0);
    }
    public static long encontrarPotenciaCercana(long n) {
        if (n <= 0) {
            throw new IllegalArgumentException("El número debe ser positivo.");
        }
        // Encuentra el bit más significativo (el bit más a la izquierda)
        int bitMasSignificativo = 0;
        long num = n;
        while (num > 0) {
            bitMasSignificativo++;
            num >>= 1;
        }

        // Construye la potencia de 2 más cercana
        long potenciaCercana = 0;
        if (bitMasSignificativo <30) {
            potenciaCercana = 1 << (bitMasSignificativo - 1);
        }else{
            potenciaCercana = BigInteger.ONE.shiftLeft(bitMasSignificativo - 1).longValue();
        }
        
        return potenciaCercana;
    }
}

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("ingrese numero");
        long numero = in.nextLong(); // Cambia esto al número que quieras verificar

        System.out.println("El ganador es: "+Result.counterGame(numero));
    }

}