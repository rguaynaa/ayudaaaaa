/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.play;
import models.timer;
import view.proceso;

/**
 *
 * @author rodrigo
 */
public class controllerproceso {
    private proceso visualizacion;
    private int cantidad;
    
    
    public controllerproceso (proceso visualizacion,int cantidad){
        this.visualizacion=visualizacion;
        this.cantidad=cantidad;
        inicializar();
        iniciarhilos();
    }
    public void iniciarhilos(){
       timer time =new timer(visualizacion.lbtiempo);
       play iniciar=new play(this.visualizacion,time,this.cantidad,5,6,7);
       time.start();
       iniciar.start();
    }
    private void inicializar(){
        visualizacion.setVisible(true);
        
    }

    
}
