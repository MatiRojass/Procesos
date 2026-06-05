package act1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Mati
 */
public class ProcesoZ extends Thread{
    private Objeto obj;
    private Semaphore semaforo;

    public ProcesoZ(Objeto obj, Semaphore semaforo) {
        this.obj = obj;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        System.out.println("[PROCESO Z] Ejecuta");
        try {
            semaforo.acquire();
            System.out.println("[PROCESO Z] Toma un turno");

            this.obj.contador = this.obj.contador + 3;
            
            System.out.println("[PROCESO Z] Incrementa +3 OBJ");
            System.out.println("[PROCESO Z] Libera turno");

            semaforo.release();
            
            System.out.println("[PROCESO Z] valor de OBJ: " + obj.contador);
        } catch (InterruptedException ex) {
            System.getLogger(ProcesoX.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
