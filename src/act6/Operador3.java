package act6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Operador3 extends Thread{
    private Semaphore manubrios;
    private Semaphore espacioManubrios;

    public Operador3(Semaphore manubrios, Semaphore espacioManubrios) {
        this.manubrios = manubrios;
        this.espacioManubrios = espacioManubrios;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                espacioManubrios.acquire();
                System.out.println("[Operador 3] Fabrica manubrio");
                Thread.sleep(2000);
                manubrios.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Operador3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}