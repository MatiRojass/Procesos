package act4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FumadorTabaco extends Thread {

    private Semaphore tabaco;
    private Semaphore listo;

    public FumadorTabaco(Semaphore tabaco, Semaphore listo) {
        this.tabaco = tabaco;
        this.listo = listo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                tabaco.acquire();

                System.out.println("[Fumador con tabaco] Toma ingredientes");
                System.out.println("[Fumador con tabaco] Arma y fuma el cigarro...");
                Thread.sleep(3000);
                listo.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(FumadorTabaco.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
