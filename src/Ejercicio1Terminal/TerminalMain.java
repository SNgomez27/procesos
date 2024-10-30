package Ejercicio1Terminal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TerminalMain {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\ALUMNO\\Desktop\\script";

        ProcessBuilder pb = new ProcessBuilder("powershell.exe","-ExecutionPolicy", "Bypass", "-File", ruta);

        try {
            Process p = pb.start();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            int estadoSalida = p.waitFor();
            System.out.println("el proceso termino con el codigo: " + estadoSalida);
        }catch (IOException | InterruptedException e){
            System.out.println("error" + e);
        }
    }
}
