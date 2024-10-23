package ejestacionamiento;

import java.util.LinkedList;

public class hilosmain {
    public static void main(String[] args) {
        estacionamiento esta = new estacionamiento();
        LinkedList<Integer> estacionamiento = new LinkedList<>();
        Thread entradaCoche = new Thread(() ->{
            try {
                int valor = 0;
                while (true) {
                    esta.entradaCoche(valor);
                    valor++;
                    Thread.sleep(2000);

                }
            } catch (InterruptedException e) {
                System.out.println("error" +e);
            }

        });
        Thread salidaCoche = new Thread(() ->{
            try {
                int valor = 0;
                while (true) {
                    esta.salidaCoche();

                    Thread.sleep(2000);

                }
            } catch (InterruptedException e) {
                System.out.println("error" +e);
            }

        });
        entradaCoche.start();
        salidaCoche.start();
    }
    }

