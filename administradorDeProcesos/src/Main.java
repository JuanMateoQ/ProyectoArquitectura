import javax.swing.*;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Procesador procesador = new Procesador();

        Scanner scanner = new Scanner(System.in);
        int opcion;
        //Ingresar dos números en enteros.
        System.out.println("Ingrese el primer numero: ");
        int numeroA= scanner.nextInt();
        System.out.println("Ingrese el segundo numero: ");
        int numeroB= scanner.nextInt();
//máximo 31
        //mínimo -15


        /// inicilizar las clases
        Clase3 clase3 = new Clase3();
        Clase1 clase1 = new Clase1();
        Binario binarioA= new Binario(numeroA);
        Binario binarioB= new Binario(numeroB);
        binarioB.getNumeroBinario();

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // sumar
                    System.out.println(clase3.sumarDosNúmerosBinarios(binarioA.getNumeroBinario(),binarioB.getNumeroBinario()));
                   // String respuestaSuma = clase3.sumarDosNúmerosBinarios(binarioA.getNumeroBinario(),binarioB.getNumeroBinario());
                    //Binario respuesta = new Binario(respuestaSuma);
                   // System.out.println(respuesta.mostrar6Bits());
                    break;
                case 2:
                        //multiplicar
                    System.out.println(clase3.multiplicarSinBooth(binarioA.getNumeroBinario(),binarioB.getNumeroBinario()));
                    break;
                case 3:
                    System.out.println(clase1.boothMultiplication(binarioA.getNumeroBinario(),binarioB.getNumeroBinario()));
                    break;
                case 4:
                   //System.out.println(clase1.boothMultiplication(numeroA,numeroB));
                    break;
                case 5:
                    procesador.empezarContadorDelPC(numeroA,  numeroB);
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
        //String binario = Integer.toBinaryString(numero);

        //Convertir a Binarios
        //Sumar los números
        //Multiplicar
        //Potenciar
        //Implementación de Procesos

    }
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("1. Sumar los números binarios");
        System.out.println("2. Multiplicar.");
        System.out.println("3. Multiplicar con Booth");
        System.out.println("4. Potenciación");
        System.out.println("5. Administrador de Procesos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }


}

