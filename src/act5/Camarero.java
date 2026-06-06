package act5;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Camarero extends Thread{
    private Semaphore sc1;
    private Semaphore sigPlato1;
    private Semaphore sc2;
    private Semaphore sigPlato2;
    private Platos platos;

    public Camarero(Semaphore sc1, Semaphore sigPlato1, Semaphore sc2, Semaphore sigPlato2, Platos platos) {
        this.sc1 = sc1;
        this.sigPlato1 = sigPlato1;
        this.sc2 = sc2;
        this.sigPlato2 = sigPlato2;
        this.platos = platos;
    }
    
    @Override
    public void run(){
        while(true){
            try {
                sc1.acquire();
                sc2.acquire();  
                System.out.println("[CAMARERO] Ejecuta");
                System.out.println("[CAMARERO] Repone los platos...");
                platos.uno = 10;
                platos.dos = 10;
                Thread.sleep(4000);
                sigPlato1.release();
                sigPlato2.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Camarero.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
    
}
