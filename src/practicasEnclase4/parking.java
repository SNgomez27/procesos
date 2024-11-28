package practicasEnclase4;
class estacionamiento{
    private int Max=3;
    private int Contador=0;
    private boolean estado=false;
    public synchronized void estacionar() throws InterruptedException {
        while (!estado){
            System.out.println("estacionamiento lleno");
            wait();
        }
        System.out.println(" esperando lugar en el estacionamiento");
    }
    public synchronized void lugarAsignado() throws InterruptedException {
        this.estado=true;
        System.out.println("Puede pasar a estacionar");

    }
}



public class parking {
}
