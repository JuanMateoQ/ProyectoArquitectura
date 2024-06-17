public class Clase3 {
    int operando1;
    int operando2;
    public Clase3(){

    }
    public String sumarDosNúmerosBinarios(String sumando1, String sumando2){
        int numero1 = Integer.parseInt(sumando1, 2);
        int numero2 = Integer.parseInt(sumando2, 2);

        int suma = numero1 + numero2;
        return Integer.toBinaryString(suma);
    }
    public String multiplicarSinBooth(String factor1, String factor2){
        int numero1 = Integer.parseInt(factor1, 2);
        int numero2 = Integer.parseInt(factor2, 2);
        int resultado = numero1*numero2;

        return Integer.toBinaryString(resultado);
    }

}