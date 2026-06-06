package act7;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Salida extends Thread {

    private Semaphore pista;
    private Semaphore hangares;
    private Semaphore trayecto;

    public Salida(Semaphore pista, Semaphore hangares, Semaphore trayecto) {
        this.pista = pista;
        this.hangares = hangares;
        this.trayecto = trayecto;
    }

    @Override
    public void run() {
        while (true) {
            try {
                pista.acquire();
                trayecto.acquire();
                System.out.println("[SALE] Avion sale del hangar y ccupa la via hacia la pista");
                Thread.sleep(3000);
                
                trayecto.release();
                hangares.release();
                System.out.println("[SALE] Avion entra a la pista. Libera la via y el hangar.");
                Thread.sleep(2000);
                
                System.out.println("[SALE] Despega y libera la pista");
                pista.release();
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Llegada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
