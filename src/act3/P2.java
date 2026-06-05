package act3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P2 extends Thread {

    private Semaphore s;
    private Semaphore elementos;
    private ED ed;

    public P2(Semaphore s, Semaphore elementos, ED ed) {
        this.s = s;
        this.elementos = elementos;
        this.ed = ed;
    }

    @Override
    public void run() {
        System.out.println("[P2] Ejecuta");

        int i = 0;
        while (i < 3) {
            try {
                System.out.println("[P2] Espera a elementos");
                elementos.acquire();
                s.acquire();
                System.out.println("[P2] Toma turno");
                System.out.println("[P2] Quita elemento");
                ed.n = ed.n - 1;
                s.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(P2.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }

    }

}
