package act4;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FumadorPapel extends Thread {

    private Semaphore papel;
    private Semaphore listo;

    public FumadorPapel(Semaphore papel, Semaphore listo) {
        this.papel = papel;
        this.listo = listo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                papel.acquire();
                System.out.println("[Fumador con papel] Toma ingredientes");
                System.out.println("[Fumador con papel] Arma y fuma el cigarro...");
                Thread.sleep(3000);
                listo.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(FumadorPapel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
