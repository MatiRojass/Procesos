package act6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Operador1 extends Thread{
    private Semaphore ruedas;
    private Semaphore espacioRuedas;

    public Operador1(Semaphore ruedas, Semaphore espacioRuedas) {
        this.ruedas = ruedas;
        this.espacioRuedas = espacioRuedas;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                espacioRuedas.acquire();
                System.out.println("[Operador 1] Fabrica rueda");
                Thread.sleep(2000);
                ruedas.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Operador1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
