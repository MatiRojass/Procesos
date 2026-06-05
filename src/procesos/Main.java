package procesos;

import act1.*;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Mati
 */
public class Main {

    
    public static void act1(){
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
       Objeto obj = new Objeto(0);
       Semaphore semaforo = new Semaphore(1);
       
        ProcesoX procX = new ProcesoX(obj, semaforo);
        ProcesoY procY = new ProcesoY(obj, semaforo);
        ProcesoZ procZ = new ProcesoZ(obj, semaforo);
        
        procX.start();
        procX.join();
        procY.start();
        procZ.start();
    }
    
}
