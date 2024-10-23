package ejestacionamiento;
import java.util.LinkedList;

public class estacionamiento {
    private LinkedList<Integer> estacionamiento = new LinkedList<>();
    private final int Capacidad = 20;
   public void setEstacionamiento(LinkedList<Integer> estacionamiento) {
       this.estacionamiento = estacionamiento;
   }
   public  void entradaCoche (int valor) throws InterruptedException {
       synchronized (estacionamiento) {
           while (estacionamiento.size() == Capacidad) {
               wait();
           }
           estacionamiento.addLast(valor);
           System.out.println("Estacionamiento tiene  " + estacionamiento + " autos ");
           notify();
       }
   }
   public void salidaCoche () throws InterruptedException {
       synchronized (estacionamiento) {
           while (estacionamiento.size() == Capacidad) {
               wait();
           }
           int valor = estacionamiento.removeFirst();
           System.out.println("Estacionamiento tiene  " + estacionamiento + " autos ");
           notify();
       }
   }

}
