package practicaEnclase3;
class alternado{
    private boolean ping;
    private boolean pong;
    public synchronized void salePing() throws InterruptedException {
        while (this.pong){
            wait();
        }
        System.out.println("ping");
        this.pong = false;
        notify();
        wait();

    }
    public synchronized void salePong() throws InterruptedException {
        while (this.ping){
            wait();
        }
        System.out.println("pong");
        this.ping = false;
        notify();
        wait();
    }
}



public class pingpong {
    public static void main(String[] args) {
        alternado alternar = new alternado();
        Thread ping = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    alternar.salePing();
                    Thread.sleep(1000);
                }
            }catch(Exception e) {
                System.out.println("error");
            }
        });
        Thread pong = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                alternar.salePong();
                Thread.sleep(1000);
                }
            }catch(Exception e) {
                System.out.println("error");
            }
        });
        ping.start();
        pong.start();
    }
}
