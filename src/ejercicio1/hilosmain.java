package ejercicio1;

public class hilosmain {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("hilo 1 " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("error " + e);
                }
            }
        });
        Thread hilo2 = new Thread(() -> {
            for (int i = 6; i <= 10; i++) {
                System.out.println("hilo 2 " + i);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println("error " + e);
                }
            }
        });
        hilo1.start();
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println("error " + e);
        }
        hilo2.start();
        try {
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("error " + e);
        }
    }
}
