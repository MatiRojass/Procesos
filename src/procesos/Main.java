package procesos;

import act1.*;
import act2.*;
import act3.*;
import act4.*;
import act5.*;
import act6.*;
import act7.*;
import java.util.concurrent.Semaphore;

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

    public static void act4() {
        Semaphore papel = new Semaphore(0);
        Semaphore tabaco = new Semaphore(0);
        Semaphore fosforo = new Semaphore(0);
        Semaphore listo = new Semaphore(0);

        Proveedor prove = new Proveedor(papel, tabaco, fosforo, listo);
        FumadorPapel fumPapel = new FumadorPapel(papel, listo);
        FumadorTabaco fumTabaco = new FumadorTabaco(tabaco, listo);
        FumadorFosforo fumFosforo = new FumadorFosforo(fosforo, listo);

        prove.start();
        fumPapel.start();
        fumTabaco.start();
        fumFosforo.start();
    }

    public static void act5() {
        Semaphore sc1 = new Semaphore(0);
        Semaphore sc2 = new Semaphore(0);
        Semaphore sigPlato1 = new Semaphore(0);
        Semaphore sigPlato2 = new Semaphore(0);
        Semaphore ensalada = new Semaphore(1);
        //Para probar los iniciamos en 3 sino se hace muy largo.
        Platos platos = new Platos(3, 3);

        Comensal1 com1 = new Comensal1(sc1, sigPlato1, ensalada, platos);
        Comensal2 com2 = new Comensal2(sc2, sigPlato2, ensalada, platos);
        Camarero cam = new Camarero(sc1, sigPlato1, sc2, sigPlato2, platos);

        com1.start();
        com2.start();
        cam.start();
    }

    public static void act6() {
        Semaphore ruedas = new Semaphore(0);
        Semaphore cuadros = new Semaphore(0);
        Semaphore manubrios = new Semaphore(0);
        Semaphore espacioRuedas = new Semaphore(20);
        Semaphore espacioCuadros = new Semaphore(10);
        Semaphore espacioManubrios = new Semaphore(10);
        
        Operador1 op1 = new Operador1(ruedas, espacioRuedas);
        Operador2 op2 = new Operador2(cuadros, espacioCuadros);
        Operador3 op3 = new Operador3(manubrios, espacioManubrios);
        Armador arm = new Armador(ruedas, cuadros, manubrios, espacioRuedas, espacioCuadros, espacioManubrios);
        
        op1.start();
        op2.start();
        op3.start();
        arm.start();
    }

    public static void act7(){
        Semaphore pista = new Semaphore(3);
        Semaphore hangares = new Semaphore(10);
        Semaphore trayecto = new Semaphore(1);
        
        Salida salida = new Salida(pista, hangares, trayecto);
        Llegada llegada = new Llegada(pista, hangares, trayecto);
        
        salida.start();
        llegada.start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        //act1();
        //act2();
        //act3();
        //act4();
        //act5();
        //act6();
        //act7();
    }

}
