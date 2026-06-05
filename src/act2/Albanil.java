package act2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Albanil extends Thread {

    private Semaphore baldeArriba, baldeAbajo;

    public Albanil(Semaphore baldeArriba, Semaphore baldeAbajo) {
        this.baldeArriba = baldeArriba;
        this.baldeAbajo = baldeAbajo;
    }

    @Override
    public void run() {
        System.out.println("[Albanil] Ejecuta");

        try {
            baldeArriba.acquire();
            System.out.println("[Albanil] Vacia balde");
            System.out.println("[Albanil] Baja balde");
            baldeAbajo.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Albanil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
