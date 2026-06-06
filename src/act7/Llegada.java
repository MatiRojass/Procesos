package act7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Llegada extends Thread {

    private Semaphore pista;
    private Semaphore hangares;
    private Semaphore trayecto;

    public Llegada(Semaphore pista, Semaphore hangares, Semaphore trayecto) {
        this.pista = pista;
        this.hangares = hangares;
        this.trayecto = trayecto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                hangares.acquire();
                System.out.println("[LLEGA] Avion reserva un hangar");
                pista.acquire();
                System.out.println("[LLEGA] Aterriza y ocupa la pista");
                Thread.sleep(2000);
                trayecto.acquire();
                pista.release();
                System.out.println("[LLEGA] Deja la pista y ocupa la via hacia los hangares");
                Thread.sleep(3000);
                trayecto.release();
                System.out.println("[LLEGA] Se guarda en los hangares");
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
