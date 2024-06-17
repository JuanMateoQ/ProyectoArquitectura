import java.util.concurrent.atomic.AtomicInteger;

public class Procesador {
    int PC;
    AtomicInteger AC1, AC2, IR;
    Instrucciones instrucciones;
    public Procesador(){
        this.PC = 100;
        instrucciones = new Instrucciones();
        AC1 = new AtomicInteger();
        AC2 = new AtomicInteger();
        IR = new AtomicInteger();
    }
    public void empezarContadorDelPC(int numA, int numB) {
        int contadorDeInstrucciones = 0;
        //ejecuciones
        do{
            instrucciones.asignarEspacioDeMemoriaPC(this.IR, contadorDeInstrucciones);
            System.out.println(this.PC + "|" +contadorDeInstrucciones + this.IR + "|" + "  |"+ this.PC + "| PC\n"+
                    instrucciones.realizarInstrucción(contadorDeInstrucciones, this.AC1, this.AC2, numA, numB) +
                    "...        |" + (contadorDeInstrucciones ) + (this.IR) + "| IR \n"+
                    "500" + "|" + numA + "|\n"+
                    "501" + "|" + numB + "|\n");
            contadorDeInstrucciones++;
            this.PC++;
        }while(this.PC != 106);

        System.out.println("AC1: " + this.AC1);
    }
}
