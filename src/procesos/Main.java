package procesos;

import act1.*;
import act2.*;
import act3.*;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mati
 */
public class Main {

    public static void act1() {
        Objeto obj = new Objeto(0);
        Semaphore semaforo = new Semaphore(1);

        ProcesoX procX = new ProcesoX(obj, semaforo);
        ProcesoY procY = new ProcesoY(obj, semaforo);
        ProcesoZ procZ = new ProcesoZ(obj, semaforo);

        procX.start();
        procY.start();
        procZ.start();
    }

    public static void act2() {
        Semaphore baldeArriba = new Semaphore(0);
        Semaphore baldeAbajo = new Semaphore(1);

        Albanil alb = new Albanil(baldeArriba, baldeAbajo);
        Cadete cad = new Cadete(baldeArriba, baldeAbajo);

        alb.start();
        cad.start();
    }

    public static void act3() {
        Semaphore s = new Semaphore(1);
        Semaphore elementos = new Semaphore(0);

        ED ed = new ED(0);

        P1 p1 = new P1(s, elementos, ed);
        P2 p2 = new P2(s, elementos, ed);

        p1.start();
        p2.start();

        System.out.println("[Final] Valor de n = " + ed.n);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //act1();
        //act2();
        act3();
    }

}
