package ejestacionamiento;
import java.util.LinkedList;

public class estacionamiento {

    private LinkedList<Integer> estacionamiento = new LinkedList<>();
    private final int Capacidad = 20;

    public void setEstacionamiento(LinkedList<Integer> estacionamiento) {
        this.estacionamiento = estacionamiento;
    }
    public  void entradaCoche (int valor) throws InterruptedException {
        synchronized (this) {
            while (estacionamiento.size() == Capacidad) {
                wait();
            }
            estacionamiento.add(valor);
            System.out.println("Estacionamiento tiene  " + estacionamiento + " autos ");
            notify();
        }
    }
    public void salidaCoche () throws InterruptedException {
        synchronized (this) {
            while (true) {
                if (estacionamiento.size() == 0) {
                    wait();
                }
                int valor = estacionamiento.removeFirst();
                System.out.println("salen del estacionamiento   " + valor + " autos ");
                notify();
            }



        }
    }
}



