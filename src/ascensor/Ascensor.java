package ascensor;
import java.util.LinkedList;
public class Ascensor extends Ascen {
    public static void main(String[] args) {
        Ascensor a = new Ascensor();
        Thread entrar = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    a.entarAlAscensor();
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Error "+e.getMessage());
                }
            }
        });
        Thread salir = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    a.salirDelDescensor();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    System.out.println("Error "+e.getMessage());
                }
            }
        });
        entrar.start();
        try {
            entrar.join();
        } catch (InterruptedException e) {
            System.out.println("Error "+e.getMessage());
        }
        salir.start();
        try {
            salir.join();
        } catch (InterruptedException e) {
            System.out.println("Error "+e.getMessage());
        }
    }

}
