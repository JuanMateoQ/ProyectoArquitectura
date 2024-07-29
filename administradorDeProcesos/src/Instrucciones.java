import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Instrucciones {
    //Invocar a y b
    //Sumar a + b y guardar en acc1 10
    //Multiplicar 2* b y guardar en acc2  10
    //restar acc1 + acc2 y guardar en acc1 20
    //sumar acc1 + acc2 guardar en acc2 20
    //Multiplicar acc1 * acc2 y guardar en acc1 y mostrar 400
    ArrayList<String> listaDeResultadosInstruciones;
    public Instrucciones(){
        listaDeResultadosInstruciones = new ArrayList<String>();
    }

    public String realizarInstrucción(int contadorDeInstrucciones, AtomicInteger AC1, AtomicInteger AC2, String numA, String numB) {
        String informacionARetornar = null;
        switch (contadorDeInstrucciones){
            case 0:
                informacionARetornar =  ("...        |    |AC1 \n"+
                                         "...        |    |AC2 \n");
                listaDeResultadosInstruciones.add(informacionARetornar);
                break;
            case 1:
                String sumaDeAyB =Clase3.sumarDosNúmerosBinarios(numA, numB);
                int aux = Integer.parseInt(sumaDeAyB);
                AC1.set(aux);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |    |AC2 \n");


                break;
            case 2:
                String dos = "10";
                String multBy2 = Clase3.multiplicarSinBooth(numB,dos );
                int aux2 = Integer.parseInt(multBy2);
                AC2.set(aux2);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |"+AC2 + "|AC2 \n");
                break;
            case 3:
                Binario aux3 = new Binario(AC1.get()+AC2.get());
                int acc1Aux3 = Integer.parseInt(aux3.getNumeroBinario());
                AC1.set(acc1Aux3);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |"+AC2 + "|AC2 \n");
                break;
            case 4:
                AC2.set(AC1.get()+AC2.get());
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                        "...        |"+AC2 + "|AC2 \n");
                break;
            case 5:
                Binario aux4 = new Binario(AC1.get()*AC2.get());
                int acc1Aux4 = Integer.parseInt(aux4.getNumeroBinario());
                AC1.set(acc1Aux4);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                        "...        |"+AC2 + "|AC2 \n");

                break;
            default:
                System.out.println("El ciclo de Instrucciones ha terminado...");
        }
        return informacionARetornar;
    }


    public void asignarEspacioDeMemoriaPC(AtomicInteger IR, int contadorDeInstrucciones) {
        switch (contadorDeInstrucciones){
            case 0, 3, 5:
                IR.set(500);
                break;
            case 1, 2, 4:
                IR.set(501);
                break;
            default:
                System.out.println("El ciclo de Instrucciones ha terminado...");
        }
    }
}
