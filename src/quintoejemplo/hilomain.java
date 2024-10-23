package quintoejemplo;

import java.util.LinkedList;

public class hilomain {
    public static void main(String[] args) {
        almacen alma = new almacen();
        LinkedList<Integer> lista = new LinkedList<>();
        lista.add(100);
        lista.add(200);
        lista.add(300);
        lista.add(400);
        alma.setELementoLista(lista);
        Thread producto = new Thread(()-> {
            try{
                int valor = 0;
                    while (true){
                        alma.producir(valor);
                        valor++;
                        Thread.sleep(1000);
                    }

            }  catch (InterruptedException e ){
                System.out.println("Error "+ e);
            }
        });
        Thread consumidor  = new Thread(()-> {
            try{
                int valor = 0;
                while (true){
                    alma.consumir();
                    Thread.sleep(1000);
                }

            }  catch (InterruptedException e ){
                System.out.println("Error "+ e);
            }
        });
        producto.start();
        consumidor.start();

    }
}
