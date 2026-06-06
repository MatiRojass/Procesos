package act5;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Comensal2 extends Thread {

    private Semaphore sc2;
    private Semaphore sigPlato2;
    private Semaphore ensalada;
    private Platos platos;

    public Comensal2(Semaphore sc2, Semaphore sigPlato2, Semaphore ensalada, Platos platos) {
        this.sc2 = sc2;
        this.sigPlato2 = sigPlato2;
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
                System.out.println("[Comensal 2] Piensa su opcion...");
                Thread.sleep(2000);
                //Elegir entre su plato o la ensalada
                int op = pensarOpcion();

                if (op == 1) { //Su plato
                    System.out.println("[Comensal 2] Hace una cucharada");
                    platos.dos--;
                    if (platos.dos == 0) {
                        System.out.println("[Comensal 2] Termino su plato (ESPERA)");

                        sc2.release(); //avisar al camarero que termino su plato
                        sigPlato2.acquire(); //espera el siguiente plato
                    }
                } else { //Quiere ensalada
                    ensalada.acquire();
                    System.out.println("[Comensal 2] Toma el turno de ensalada");
                    System.out.println("[Comensal 2] Come ensalada...");
                    Thread.sleep(3000);
                    ensalada.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Comensal1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
