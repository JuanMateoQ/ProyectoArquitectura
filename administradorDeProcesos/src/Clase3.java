public class Clase3 {
    int operando1;
    int operando2;
    public Clase3(){

    }
    public static String sumarDosNúmerosBinarios(String sumando1, String sumando2){

        int numero1 = Integer.parseInt(sumando1, 2);
        int numero2 = Integer.parseInt(sumando2, 2);

        int suma = numero1 + numero2;
        return Integer.toBinaryString(suma);
    }
    public static String multiplicarSinBooth(String factor1, String factor2){
        int numero1 = Integer.parseInt(factor1, 2);
        int numero2 = Integer.parseInt(factor2, 2);
        int resultado = numero1*numero2;

        return Integer.toBinaryString(resultado);
    }
    public String exponenciacionRapida(String base, int exponente) {
        String resultado = "1"; // Inicializa el resultado en 1 (binario)
        String baseActual = base;

        while (exponente > 0) {
            if ((exponente & 1) == 1) { // Si el exponente es impar, multiplicar por la base actual
                resultado = multiplicarSinBooth(resultado, baseActual);
            }
            baseActual = multiplicarSinBooth(baseActual, baseActual); // Elevar al cuadrado la base
            exponente >>= 1; // Dividir el exponente entre 2
        }

        return resultado;
    }
}