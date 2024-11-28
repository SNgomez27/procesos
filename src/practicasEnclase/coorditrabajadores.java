package practicasEnclase;
class jornada {
    private boolean jefeOrden = false;

    public synchronized void esperandoOrdenes(String trabajadores) throws InterruptedException {
        while (!jefeOrden) {
            System.out.println(trabajadores + "esta esperando las ordeness");
            wait();
        }
        System.out.println(trabajadores + "recibieron ordenes");
    }

    public synchronized void jefeOrden() {
        this.jefeOrden = true;
        System.out.println("la orden llego");
        notifyAll();
    }
}


public class coorditrabajadores {
    public static void main(String[] args) {
        jornada jornada = new jornada();
        Runnable trabajador = () -> {
            String nombre = Thread.currentThread().getName();
            try{
                jornada.esperandoOrdenes(nombre);
            }catch (InterruptedException e){
                System.out.println("error"+e.getMessage());
            }
        };
        Thread t1 = new Thread(trabajador);
        Thread t2 = new Thread(trabajador);
        Thread t3 = new Thread(trabajador);
        t1.start();
        t2.start();
        t3.start();
        try{
            Thread.sleep(1500);
        }catch (InterruptedException e){
            System.out.println("error"+e.getMessage());
        }
        jornada.jefeOrden();
    }
}
