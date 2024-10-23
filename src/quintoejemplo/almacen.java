package quintoejemplo;

import java.util.LinkedList;

public class almacen {
    private LinkedList<Integer> lista = new LinkedList<>();
    private final int CAPACIDAD = 5;
    public  void setELementoLista(LinkedList<Integer> listaProv){
        this.lista = listaProv;
    }
    public void  producir (int valor) throws InterruptedException{
        synchronized (this){
            while (lista.size() == CAPACIDAD){
                wait();
            }
            lista.addLast(valor);
            System.out.println("producido: "+valor);
            notify();
        }
    }
    public void consumir () throws InterruptedException{
        synchronized (this){
            while (lista.size() == 0){
                wait();
            }
            int valor = this.lista.removeFirst();
            System.out.println("consumido: "+valor);
            notify();
        }
    }
}
