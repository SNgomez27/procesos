package carrera;
class Hilo{
    public boolean hilosAlaVez = false;



    public synchronized void esperarSalida(String hilos) throws InterruptedException{
        while (!hilosAlaVez){
            System.out.println(hilos + " Esperando a la salida" );
            wait();
        }
        System.out.println(" salieron todos juntos ");
    }
    public synchronized void todosAlaVes() throws InterruptedException{
        this.hilosAlaVez = true;
        System.out.println("Ya  todos estan en la salida");
        notifyAll();
    }
}
public class carrera {
    public static void main(String[] args) throws InterruptedException {
        Hilo hilos = new Hilo();
        Runnable HilosJuntos = () -> {
            String hilo = Thread.currentThread().getName();
            try {

                hilos.esperarSalida(hilo);


            }catch (InterruptedException e){
                System.out.println("error " + e.getMessage());
            }
        };
        Thread hilo1 = new Thread(HilosJuntos, " hilo 1");
        Thread hilo2 = new Thread(HilosJuntos, " hilo 2");
        Thread hilo3 = new Thread(HilosJuntos, " hilo 3");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("error " + e.getMessage());
        }
        hilos.todosAlaVes();
    }
}