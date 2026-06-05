package act2;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cadete extends Thread {

    private Semaphore baldeArriba, baldeAbajo;

    public Cadete(Semaphore baldeArriba, Semaphore baldeAbajo) {
        this.baldeArriba = baldeArriba;
        this.baldeAbajo = baldeAbajo;
    }

    @Override
    public void run() {
        System.out.println("[Cadete] Ejecuta");

        try {
            baldeAbajo.acquire();
            System.out.println("[Cadete] LLenar balde");
            System.out.println("[Cadete] Subir balde");
            baldeArriba.release();
        } catch (InterruptedException ex) {
            Logger.getLogger(Cadete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}