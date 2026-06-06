package act6;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Armador extends Thread {

    private Semaphore ruedas;
    private Semaphore cuadros;
    private Semaphore manubrios;
    private Semaphore espacioRuedas;
    private Semaphore espacioCuadros;
    private Semaphore espacioManubrios;

    public Armador(Semaphore ruedas, Semaphore cuadros, Semaphore manubrios, Semaphore espacioRuedas, Semaphore espacioCuadros, Semaphore espacioManubrios) {
        this.ruedas = ruedas;
        this.cuadros = cuadros;
        this.manubrios = manubrios;
        this.espacioRuedas = espacioRuedas;
        this.espacioCuadros = espacioCuadros;
        this.espacioManubrios = espacioManubrios;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //requiere 2 ruedas, 1 cuadro y 1 manubrio
                ruedas.acquire();
                ruedas.acquire();
                cuadros.acquire();
                manubrios.acquire();
                System.out.println("[ARMADOR] EMPIEZA a armar la bicicleta... ");

                Thread.sleep(4000); 

                System.out.println("[ARMADOR] TERMINA la bicicleta y libera espacio.");
                //liberar espacios consumidos
                espacioRuedas.release();
                espacioRuedas.release();
                espacioCuadros.release();
                espacioManubrios.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Armador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
