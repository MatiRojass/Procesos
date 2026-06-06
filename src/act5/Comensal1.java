package act5;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Comensal1 extends Thread {

    private Semaphore sc1;
    private Semaphore sigPlato1;
    private Semaphore ensalada;
    private Platos platos;

    public Comensal1(Semaphore sc1, Semaphore sigPlato1, Semaphore ensalada, Platos platos) {
        this.sc1 = sc1;
        this.sigPlato1 = sigPlato1;
        this.ensalada = ensalada;
        this.platos = platos;
    }

    public int pensarOpcion() {
        Random ran = new Random();
        return ran.nextInt(2);
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("[Comensal 1] Piensa su opcion...");
                Thread.sleep(2000);
                //Elegir entre su plato o la ensalada
                int op = pensarOpcion();

                if (op == 1) { //Su plato
                    System.out.println("[Comensal 1] Hace una cucharada");
                    platos.uno--;
                    if (platos.uno == 0) {
                        System.out.println("[Comensal 1] Termino su plato (ESPERA)");

                        sc1.release(); //avisar al camarero que termino su plato
                        sigPlato1.acquire(); //espera el siguiente plato
                    }
                } else { //Quiere ensalada
                    ensalada.acquire();
                    System.out.println("[Comensal 1] Toma el turno de ensalada");
                    System.out.println("[Comensal 1] Come ensalada...");
                    Thread.sleep(3000);
                    ensalada.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Comensal1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
