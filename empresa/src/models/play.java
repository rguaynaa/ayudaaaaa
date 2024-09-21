
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import javax.swing.SwingUtilities;
import view.proceso;

/**
 *
 * @author rodrigo
 */
public class play {
    private volatile boolean esam=true;
    private timer timerp;
    private proceso vtn_hilos;
    private int repetir;
    private int tiempo1;
    private int tiempo2;
    private int tiempo3;
    private productos producto;

    public play(proceso vtn_hilos, timer timep, int repetir, int t1, int t2, int t3) {
        this.vtn_hilos = vtn_hilos;
        this.timerp = timerp;
        this.repetir = repetir;
        this.tiempo1 = t1;
        this.tiempo2 = t2;
        this.tiempo3 = t3;
    }
    public void detener(){
        esam=false;
    }
    
   public void run(){
        try {
            int contador_repeticiones = 0;
            while (esam) {
                SwingUtilities.invokeLater(() -> {
                    this.vtn_hilos.lblRepeticion.setText(contador_repeticiones + "/" + this.repetir);
                    this.vtn_hilos.pgEsamblaje.setValue(0);
                    this.vtn_hilos.pgPintura.setValue(0);
                    this.vtn_hilos.pgEmpaque.setValue(0);
                });
                /*int tiempoEnsamblaje = producto.getEnsamblaje();
                int tiempoPintura = producto.getTiempopintura();
                int tiempoEmpaque = 10;  // Tiempo fijo de empaquetado */

                progreso h1 = new progreso(this.vtn_hilos.pgEsamblaje, this.tiempo1);
                progreso h2 = new progreso(this.vtn_hilos.pgPintura, this.tiempo2);
                progreso h3 = new progreso(this.vtn_hilos.pgEmpaque, this.tiempo3);

                h1.start();
                h1.join();

                h2.start();
                h2.join();

                h3.start();
                h3.join();

                contador_repeticiones++;
                if (contador_repeticiones == this.repetir) {
                    SwingUtilities.invokeLater(() -> this.vtn_hilos.lblRepeticion.setText(contador_repeticiones + "/" + this.repetir));
                    detener();
                    //upsi
                    //this.vtn_hilos.lblRepeticion.setText(contador_repeticiones + "/" + this.repetir);
                    this.detener();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.timerp.detener();
        }
   }

    public void start() {
        new Thread(() -> run()).start();
    }
}
    

