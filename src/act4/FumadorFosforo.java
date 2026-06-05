package act4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FumadorFosforo extends Thread {

    private Semaphore fosforo;
    private Semaphore listo;

    public FumadorFosforo(Semaphore fosforo, Semaphore listo) {
        this.fosforo = fosforo;
        this.listo = listo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                fosforo.acquire();
                System.out.println("[Fumador con fosforo] Toma ingredientes");
                System.out.println("[Fumador con fosforo] Arma y fuma el cigarro");
                Thread.sleep(3000);
                listo.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(FumadorFosforo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
