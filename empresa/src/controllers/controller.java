/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.estacion;
import view.proceso;
import view.producir;

/**
 *
 * @author rodrigo
 */
public class controller implements ActionListener {
   
   producir vtnprodu=new producir();
    

    public controller(estacion producir) {
        
        this.vtnprodu=vtnprodu;
        inicializar();
    }
    private void inicializar(){
        vtnprodu.setVisible(true);
        vtnprodu.setLocationRelativeTo(null);
        vtnprodu.setResizable(false);
        vtnprodu.btnproducir.addActionListener(this);
         
        
    }
    public void iniciarHilos(){
        int repetir=Integer.parseInt(this.vtnprodu.jtcantidad.getText());
        
        proceso vtn=new proceso();
        controllerproceso control=new controllerproceso(vtn,repetir);
    }
    public void iniciar(){
        
       
    //controllerInicial controlInicial = new controllerInicial( vtnprodu);
    //controlInicial.iniciarhilos();  
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==vtnprodu.btnproducir){
            inicializar();
        }
    }

    
   
    
}