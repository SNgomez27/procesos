package segundoEjemplo;

public class HiloMain {
    public static void main(String[] args) {
        MiRunable mirunnable = new MiRunable();
        Thread hilo = new Thread(mirunnable);
        hilo.start();
    }
}
