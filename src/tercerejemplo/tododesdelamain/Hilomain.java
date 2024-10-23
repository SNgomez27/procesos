package tercerejemplo.tododesdelamain;

import java.sql.SQLOutput;

public class Hilomain {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hilo1  " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("error" + e);
                }

            }
        });
        Thread hilo2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hilo2  " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("error" + e);
                }
            }
        });
        hilo1.start();
        hilo2.start();
        try {
            hilo1.join();
            hilo2.join();
        }
        catch (InterruptedException e){
            System.out.println("error" + e);
        }
    }
}


