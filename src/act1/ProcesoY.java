package act1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Mati
 */
public class ProcesoY extends Thread{
    private Objeto obj;
    private Semaphore semaforo;

    public ProcesoY(Objeto obj, Semaphore semaforo) {
        this.obj = obj;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        System.out.println("[PROCESO Y] Ejecuta");
        try {
            semaforo.acquire();
            System.out.println("[PROCESO Y] Toma un turno");

            this.obj.contador = this.obj.contador + 1;
            
            System.out.println("[PROCESO Y] Incrementa OBJ");
            System.out.println("[PROCESO Y] Libera turno");

            semaforo.release();
        } catch (InterruptedException ex) {
            System.getLogger(ProcesoX.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
