package act3;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class P1 extends Thread {

    private Semaphore s;
    private Semaphore elementos;
    private ED ed;

    public P1(Semaphore s, Semaphore elementos, ED ed) {
        this.s = s;
        this.elementos = elementos;
        this.ed = ed;
    }

    @Override
    public void run() {
        System.out.println("[P1] Ejecuta");

        int i = 0;
        while (i < 3) {
            try {
                s.acquire();
                System.out.println("[P1] Toma turno");
                System.out.println("[P1] Agrega elemento");
                ed.n = ed.n + 1;
                System.out.println("[P1] Señal a elementos (agrega recurso)");
                elementos.release();
                s.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(P1.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }

    }

}
