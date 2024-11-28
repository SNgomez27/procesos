package practicaEnclase2;


class recursos{
    private int numGenerado;
    private boolean disponible = false;
    public synchronized void producir() throws InterruptedException {
        while (this.disponible) {
            wait();
        }
        this.numGenerado = (int) (Math.random() * 100);
        System.out.println("se genero un numero");
        this.disponible = true;
        notify();
    }
    public synchronized void consumir() throws InterruptedException {
        while (!this.disponible) {
            wait();
        }
        System.out.println("El nuemro es " + this.numGenerado);
        this.disponible = false;
        notify();
    }


}

public class main {

    public static void main(String[] args) {
        recursos recursos = new recursos();

        Thread productor = new Thread(()  -> {
            for (int i = 0; i < 5; i++) {
                try {
                    recursos.producir();
                    Thread.sleep(500);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        });

        Thread consumidor = new Thread(()  -> {
            for (int i = 0; i < 5; i++) {
                try {
                    recursos.consumir();
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
            }
        });
        productor.start();
        consumidor.start();
    }
}
