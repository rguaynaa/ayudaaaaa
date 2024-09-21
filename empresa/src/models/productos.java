/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.io.Serializable;

/**
 *
 * @author rodrigo
 */
public class productos implements Serializable{
private static final long serialVersionUID = 1L;

    private String codigo;
    private String nombre;
    private String material;
    private String color;
  
    
    public productos(String codigo,String nombre,String material,String color){
        this.codigo=codigo;
        this.nombre=nombre;
        this.material=material.toUpperCase();
        this.color=color.toUpperCase();
        
    }
    public String getCodigo(){
       return codigo;   
   }
   public void setCodigo(String codigo){
       this.codigo=codigo;
   }
   
    public String getNombre(){
       return nombre;   
   }
   public void setNombre(String nombre){
       this.nombre=nombre;
   }
    public String getmaterial(){
       return material;   
   }
   public void setmaterial (String material){
       this.material=material;
   }
      public String getcolor(){
       return color;   
   }
   public void setcolor(String color){
       this.color=color;
    
   }  
    public int getEnsamblaje() {
    switch (material.toLowerCase()) {
        case "METAL":
            return 15; // segundos
        case "MATERIAL":
            return 25;
        case "VIDRIO":
            return 10;
        case "NYLON":
            return 20;
        case "HULE":
            return 10;    
        case "POLIESTER":
            return 5;    
        default:
            return 10;
    }
}

    public int getCosto() {
    switch (material.toLowerCase()) {
        case "METAL":
            return 3;
        case "MATERIAL":
            return 1;
        case "VIDRIO":
            return 6;
        case "NYLON":
            return 2;
        case "HULE":
            return 5;    
        case "POLIESTER":
            return 4; 
        default:
            return 2;
    }
}
    public int getTiempopintura() {
       switch (color.toLowerCase()) {
        case "VERDE":
            return 15;
        case "NEGRO":
            return 25;
        case "NA":
            return 0;
        case "AZUL":
            return 20;
        case "ROJO":
            return 10;    
        case "AMARILLO":
            return 5; 
        default:
            return 0;
    }
    }
    public int getCostopintura() {
       switch (color.toLowerCase()) {
        case "VERDE":
            return 3;
        case "NEGRO":
            return 1;
        case "NA":
            return 0;
        case "AZUL":
            return 2;
        case "ROJO":
            return 5;    
        case "AMARILLO":
            return 4; 
        default:
            return 0;
    }
    }
}
