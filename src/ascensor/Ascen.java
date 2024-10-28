package ascensor;
import java.util.LinkedList;
public class Ascen {
    private static int Ascen = 10;
    private int personasA;
    private int personasB;
    public synchronized  void entarAlAscensor() throws InterruptedException {
        while (Ascen == personasA){
            System.out.println("El ascensor se ha ocupado, porfa espera");
            wait();
        }
        personasA++;
        System.out.println("opa " + this.personasA + " personas estan entrando al ascensor");
        notify();
    }
    public synchronized  void salirDelDescensor() throws InterruptedException {
        while (Ascen == 0){
            System.out.println("El ascensor se ha vaciado");
            wait();
        }
        personasB++;
        System.out.println("opa " + this.personasB + " personas estan salida");
        notify();
    }
}
