package act1;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Mati
 */
public class ProcesoX extends Thread {

    private Objeto obj;
    private Semaphore semaforo;

    public ProcesoX(Objeto obj, Semaphore semaforo) {
        this.obj = obj;
        this.semaforo = semaforo;
    }

    public int leerEntero() {
        Scanner sc = new Scanner(System.in);
        System.out.print("[PROCESO X] Ingrese un entero: ");
        return sc.nextInt();
    }

    @Override
    public void run() {
        System.out.println("[PROCESO X] Ejecuta");
        int valor = leerEntero();
        try {
            semaforo.acquire();
            System.out.println("[PROCESO X] Toma un turno");

            this.obj.contador = valor;
            System.out.println("[PROCESO X] Cambia valor a OBJ");
            System.out.println("[PROCESO X] Libera turno");

            semaforo.release();
        } catch (InterruptedException ex) {
            System.getLogger(ProcesoX.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
