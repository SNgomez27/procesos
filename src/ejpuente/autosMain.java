package ejpuente;
class Puente{
    boolean autosSurPasando;
    boolean autosNortePasando;
    public void pasoAutosNorte() throws InterruptedException{
        synchronized (this) {
            while (true){
                if (autosSurPasando){
                    System.out.println(" estan pasando los autos del sur");
                    wait();
                }
                this.autosNortePasando = true;
                System.out.println(" estan pasando los autos del norte");
                Thread.sleep(5000);
                System.out.println(" ya  pasaron los autos del norte");
                this.autosNortePasando = false;
                notify();
                wait();
            }
        }
    }
    public void autosSurPasando() throws InterruptedException{
        synchronized (this) {
            while (true){
                if (autosSurPasando){
                    System.out.println(" estan pasando los autos del sur");
                    wait();
                }
                this.autosSurPasando = true;
                System.out.println(" estan pasando los autos del sur");
                Thread.sleep(3500);
                System.out.println(" ya  pasaron los autos del sur");
                this.autosSurPasando = false;
                notify();
                wait();
            }
        }
    }
}
public class autosMain {
    public static void main(String[] args) {
        Puente puente = new Puente();
        Thread hiloAutoNorteA = new Thread(() -> {
            try {
                puente.pasoAutosNorte();
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            }
        });
        Thread hiloAutoNorteB = new Thread(() -> {
            try {
                puente.pasoAutosNorte();
            } catch (InterruptedException e) {
                throw  new RuntimeException(e);
            }
        });

        Thread hiloAutoSurPasandoA = new Thread(() -> {
            try {
                puente.autosSurPasando();
            } catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
        });
        Thread hiloAutoSurPasandoB = new Thread(() -> {
            try {
                puente.autosSurPasando();
            } catch (InterruptedException e){
                throw  new RuntimeException(e);
            }
        });
        hiloAutoNorteA.start();
        hiloAutoNorteB.start();
        hiloAutoSurPasandoA.start();
        hiloAutoSurPasandoB.start();

    }
}
