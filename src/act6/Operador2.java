package act6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Operador2 extends Thread{
    private Semaphore cuadros;
    private Semaphore espacioCuadros;

    public Operador2(Semaphore cuadros, Semaphore espacioCuadros) {
        this.cuadros = cuadros;
        this.espacioCuadros = espacioCuadros;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                espacioCuadros.acquire();
                System.out.println("[Operador 2] Fabrica cuadro");
                Thread.sleep(2000);
                cuadros.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Operador1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}