public class Clase1 {

    public static String boothMultiplication(String multiplicand, String multiplier) {
        int n = multiplicand.length();

        // Inicializar registros y variables necesarias
        String A = multiplicand;  // Registro A
        String S = twosComplement(multiplicand);  // Registro -A (complemento a dos)
        String P = "0".repeat(n) + multiplier + "0";  // Registro P (producto)

        // Imprimir el estado inicial
        System.out.println("Estado inicial:");
        System.out.println("A = " + A);
        System.out.println("S = " + S);
        System.out.println("P = " + P);
        System.out.println("--------------------");

        // Iteraciones del algoritmo de Booth
        for (int i = 0; i < n; i++) {
            String lastTwoBits = P.substring(P.length() - 2);

            if (lastTwoBits.equals("01")) {
                P = addBinaryStrings(P, A);
            } else if (lastTwoBits.equals("10")) {
                P = addBinaryStrings(P, S);
            }

            P = arithmeticRightShift(P);

            // Imprimir el paso actual
            System.out.println("Paso " + (i + 1) + ":");
            System.out.println("P = " + P);
            System.out.println("--------------------");
        }

        // Imprimir el último paso antes del resultado final
        System.out.println("Último paso antes del resultado final:");
        System.out.println("P = " + P);
        System.out.println("--------------------");

        return P.substring(0, 2 * n);
    }

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

    private static String twosComplement(String str) {
        StringBuilder complement = new StringBuilder();
        boolean foundFirstOne = false;

        // Invertir los bits y buscar el primer '1' (de derecha a izquierda)
        for (int i = str.length() - 1; i >= 0; i--) {
            if (!foundFirstOne) {
                if (str.charAt(i) == '1') {
                    foundFirstOne = true;
                }
                complement.append(str.charAt(i));
            } else {
                complement.append(str.charAt(i) == '0' ? '1' : '0');
            }
        }

        return complement.reverse().toString();
    }

    private static String arithmeticRightShift(String str) {
        char signBit = str.charAt(0);
        str = signBit + str.substring(0, str.length() - 1);
        return str;
    }



    private static int convertBinaryToDecimal(String binaryString) {
        boolean isNegative = binaryString.charAt(0) == '1';
        if (isNegative) {
            binaryString = twosComplement(binaryString);
        }

        int decimal = 0;
        int power = 0;
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                decimal += Math.pow(2, power);
            }
            power++;
        }

        return isNegative ? -decimal : decimal;
    }

    public static String convertir(int num) {
        boolean isNegative = num < 0;
        if (isNegative) {
            num = Math.abs(num);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 5; i >= 0; i--) {
            int mask = 1 << i;
            if ((num & mask) != 0) {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }

        if (isNegative) {
            // Invertir los bits
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                } else {
                    sb.setCharAt(i, '0');
                }
            }
            // Sumar 1 para obtener el complemento a dos
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '0') {
                    sb.setCharAt(i, '1');
                    break;
                } else {
                    sb.setCharAt(i, '0');
                }
            }
        }

        return sb.toString();
    }

    public String exponencial(String numeroBinario, String numeroBinario1) {
        Clase3 clase3 = new Clase3();
        int exponencial = Integer.parseInt(numeroBinario,2);
        return clase3.exponenciacionRapida(numeroBinario1,exponencial);
    }
}

