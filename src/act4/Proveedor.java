package act4;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Proveedor extends Thread {

    private Semaphore papel, tabaco, fosforo;
    private Semaphore listo;

    public Proveedor(Semaphore papel, Semaphore tabaco, Semaphore fosforo, Semaphore listo) {
        this.papel = papel;
        this.tabaco = tabaco;
        this.fosforo = fosforo;
        this.listo = listo;
    }

    //Seleccionar los distintos tipos de combinacion de ingredientes:
    // 1- tabaco y fosforo
    // 2- papel y fosforo
    // 3- tabaco y papel
    private int seleccionarIngrediente() {
        Random r = new Random();
        return r.nextInt(3) + 1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("[PROVEEDOR] Seleccionando ingredientes...");
                Thread.sleep(2000);
                int ing = seleccionarIngrediente();
                switch (ing) {
                    case 1:
                        System.out.println("[PROVEEDOR] Coloca tabaco y fosforo en la mesa");
                        Thread.sleep(1000);
                        papel.release();
                        break;
                    case 2:
                        System.out.println("[PROVEEDOR] Coloca papel y fosforo en la mesa");
                        Thread.sleep(1000);
                        tabaco.release();
                        break;
                    case 3:
                        System.out.println("[PROVEEDOR] Coloca papel y tabaco en la mesa");
                        Thread.sleep(1000);
                        fosforo.release();
                        break;
                }
                System.out.println("[PROVEEDOR] Espera el listo del fumador...");
                listo.acquire();
            } catch (InterruptedException ex) {
                Logger.getLogger(Proveedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
