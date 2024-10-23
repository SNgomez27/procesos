package primerEjemplo;

public class miHIlo extends Thread {
    //run()
    //sleep() --> 1000 = 1s
    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println( "hilo" + i);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Error" + e);
            }
        }
    }
}
