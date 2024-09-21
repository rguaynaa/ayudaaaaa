/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.play;
import models.productos;
import models.timer;
import view.estacion;
import view.proceso;
import view.producir;

/**
 *
 * @author rodrigo
 */
public class controllerInicial implements ActionListener {
     estacion process=new estacion();
    
    
    public controllerInicial( estacion process){
        this.process=process;
        inicializar();
        
   
    }
    private void inicializar(){
        process.setVisible(true);
        //process.btnproducir.addActionListener(this);
    }
    public void iniciarhilos(){
      
        
       
    }
   

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==process.btnproducir){
           inicializar();
       }
    }
    
}
