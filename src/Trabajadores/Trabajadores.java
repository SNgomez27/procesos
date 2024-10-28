package Trabajadores;
class fabrica{
    private boolean materialesLlegada = false;
    public synchronized void  esperaMats(String trabajador) throws InterruptedException{
        while (!materialesLlegada){
            System.out.println(trabajador +"esta esperando los materiales");
            wait(); //
        }
        System.out.println(trabajador+"empezo a trabajar");
    }
    public synchronized void materialesLlegada(){
        this.materialesLlegada = true;
        System.out.println("Los materiales llegaron a la fabrica");
        notifyAll();
    }
}

public class Trabajadores {
    public static void main(String[] args) {
        fabrica fabrica = new fabrica();
        Runnable trabajador = () -> {
            String nombre = Thread.currentThread().getName();
            try{
                fabrica.esperaMats(nombre);
            }catch (InterruptedException e){
                System.out.println("error" + e.getMessage());
            }
        };
        Thread trabajador1 = new Thread(trabajador, " trabajador1 ");
        Thread trabajador2 = new Thread(trabajador, " trabajador2 ");
        Thread trabajador3 = new Thread(trabajador, " trabajador3 ");

        trabajador1.start();
        trabajador2.start();
        trabajador3.start();
        try{
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("error" + e.getMessage());
        }
    fabrica.materialesLlegada();
    }
}
