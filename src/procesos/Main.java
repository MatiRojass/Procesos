package procesos;

import act1.*;
import act2.Albanil;
import act2.Cadete;
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

    public static void act2(){
        Semaphore baldeArriba = new Semaphore(0);
        Semaphore baldeAbajo = new Semaphore(1);
        
        Albanil alb = new Albanil(baldeArriba, baldeAbajo);
        Cadete cad = new Cadete(baldeArriba, baldeAbajo);
        
        alb.start();
        cad.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //act1();
        act2();
    }

}
