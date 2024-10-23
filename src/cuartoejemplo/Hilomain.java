package cuartoejemplo;
class Contador{
     private int contador =0;
     public  synchronized  void incrementar(){
         this.contador++;
         System.out.println("CONTADOR: "+this.contador);
     }
}
public class Hilomain {
    public static void main(String[] args) {
        Contador contador = new Contador();
        Thread hilo1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                contador.incrementar();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("error" + e.getMessage());
                }
            }
        });
        Thread hilo2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                contador.incrementar();
                try{
                    Thread.sleep(1000);
                } catch (InterruptedException e){
                    System.out.println("error" + e.getMessage());
                }
            }
        });
        hilo1.start();
        hilo2.start();
    }
}
