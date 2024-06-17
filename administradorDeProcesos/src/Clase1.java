import javax.swing.*;
import java.util.Scanner;


/*
public class Clase1 {

    /**
     * Variables

    static Scanner sc = new Scanner(System.in);

    public  int algoritmoBooth(int x, int y) {
        int a = 0;
        byte w = 0;
        long z = 0;
        for (int i = 0; i < 32; i++) {
            if ((((x & 0x01) << 1) | w) == 1)
                System.out.println(a = a + y);
                mostrarEnBinario()
            if ((((x & 0x01) << 1) | w) == 2)
                System.out.println(a = a - y);

            z = ((((long) a) << 32) | ((((long) x) & 0xffffffffL)));
            w = (byte) (z & 0x01);
            z = z >> 1;

            a = (int) ((z >> 32) & 0xffffffff);
            x = (int) ((z) & 0xffffffff);
        }
        return (int) z;
    }

    public  int potencia(int base, int exponente) {
        int resultado = 1;
        while (exponente != 0) {
            if ((exponente & 1) == 1) {
                resultado = algoritmoBooth(resultado, base);
            }
            base = algoritmoBooth(base, base);
            exponente >>= 1;
        }
        return resultado;
    }
}
*/
public class Clase1 {



    public static int[] boothMultiplication(String multiplicand, String multiplier) {
        // Convertir los números a binario
        String multiplicandBinary = multiplicand;
        String multiplierBinary = multiplier;


        // Añadir el bit de signo al multiplicador
        multiplierBinary = "0" + multiplierBinary;

        // Inicializar el registro del producto
        String product = "0".repeat(multiplicandBinary.length() + multiplierBinary.length());

        // Iterar sobre los bits del multiplicador
        for (int i = multiplierBinary.length() - 1; i >= 0; i--) {
            // Obtener los dos bits actuales del multiplicador
            char currentBit = multiplierBinary.charAt(i);
            char previousBit = (i == 0) ? '0' : multiplierBinary.charAt(i - 1);

            // Aplicar el algoritmo de Booth
            if (currentBit == '1' && previousBit == '0') {
                // Sumar el multiplicando al producto
                product = addBinaryStrings(product, multiplicandBinary);
            } else if (currentBit == '0' && previousBit == '1') {
                // Restar el multiplicando al producto
                product = subtractBinaryStrings(product, multiplicandBinary);
            }

            // Desplazar el producto y el multiplicador un bit a la derecha
            product = product.substring(1) + "0";
            multiplierBinary = multiplierBinary.substring(1) + "0";
        }

        // Convertir el producto binario a decimal
        System.out.println(product);
        return convertBinaryToDecimal(product);
    }

    // Función para sumar dos cadenas binarias
    private static String addBinaryStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int maxLength = Math.max(len1, len2);

        StringBuilder sum = new StringBuilder();
        int carry = 0;

        for (int i = 0; i < maxLength; i++) {
            int bit1 = (i < len1) ? Character.getNumericValue(str1.charAt(len1 - 1 - i)) : 0;
            int bit2 = (i < len2) ? Character.getNumericValue(str2.charAt(len2 - 1 - i)) : 0;
            int sumBit = bit1 + bit2 + carry;
            carry = sumBit / 2;
            sum.insert(0, sumBit % 2);
        }

        if (carry == 1) {
            sum.insert(0, 1);
        }

        return sum.toString();
    }

    // Función para restar dos cadenas binarias
    private static String subtractBinaryStrings(String str1, String str2) {
        // Convertir la segunda cadena a su complemento a dos
        String twosComplement = twosComplement(str2);

        // Sumar las dos cadenas
        return addBinaryStrings(str1, twosComplement);
    }

    // Función para calcular el complemento a dos de una cadena binaria
    private static String twosComplement(String str) {
        // Invertir los bits
        String inverted = str.replace('0', '2').replace('1', '0').replace('2', '1');

        // Sumar 1 al resultado
        return addBinaryStrings(inverted, "1");
    }

    // Función para convertir una cadena binaria a decimal
    private static int[] convertBinaryToDecimal(String binaryString) {
        int[] result = new int[2];
        int decimal = 0;
        int power = 0;

        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        result[0] = decimal;
        result[1] = power - 1; // Guardar el tamaño del producto
        return result;
    }
}
