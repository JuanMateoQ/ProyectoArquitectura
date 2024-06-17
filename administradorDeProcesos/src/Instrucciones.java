import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Instrucciones {
    //Invocar a y b
    //Sumar a + b y guardar en acc1
    //Multiplicar 2* b y guardar en acc2
    //restar acc1 - acc2 y guardar en acc1
    //sumar acc1 + acc2 guardar en acc2
    //Multiplicar acc1 * acc2 y guardar en acc1 y mostrar
    ArrayList<String> listaDeResultadosInstruciones;
    public Instrucciones(){
        listaDeResultadosInstruciones = new ArrayList<String>();
    }

    public String realizarInstrucción(int contadorDeInstrucciones, AtomicInteger AC1, AtomicInteger AC2, int numA, int numB) {
        String informacionARetornar = null;
        switch (contadorDeInstrucciones){
            case 0:
                informacionARetornar =  ("...        |    |AC1 \n"+
                                         "...        |    |AC2 \n");
                listaDeResultadosInstruciones.add(informacionARetornar);
                break;
            case 1:
                AC1.set(numA+numB);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |    |AC2 \n");
                break;
            case 2:
                AC2.set(numB*2);
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |"+AC2 + "|AC2 \n");
                break;
            case 3:
                AC1.set(AC1.get()-AC2.get());
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                                         "...        |"+AC2 + "|AC2 \n");
                break;
            case 4:
                AC2.set(AC1.get()+AC2.get());
                informacionARetornar =  ("...        |"+ AC1+ "|AC1 \n"+
                        "...        |"+AC2 + "|AC2 \n");
                break;
            case 5:
                AC1.set(AC1.get()*AC2.get());
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
