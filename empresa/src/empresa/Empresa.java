/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package empresa;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.productos;
import view.estacion;

/**
 *
 * @author rodrigo
 */
public class Empresa {
    public static ArrayList<productos> listaproductos=new ArrayList<>();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        estacion iniciar=new estacion();
        iniciar.setVisible(true);
    }
    public static void agregarproductos(productos new_p){
        listaproductos.add(new_p);
    }
    public static Object[][] mostrarproductos(){
        int filas=listaproductos.size();
        Object[][] produ=new Object[filas][4];
        
        for(int i=0;i<filas;i++){
            productos temp=listaproductos.get(i);
            
    produ[i][0] = temp.getCodigo();
    produ[i][1] = temp.getNombre();
    produ[i][2] = temp.getmaterial();
    produ[i][3] = temp.getcolor();
        }
        return produ;
    }
    public static void lecturaCSV (File archivo_csv){
    String linea;
    try (BufferedReader br = new BufferedReader(new FileReader(archivo_csv))) {
        // Leer la primera línea para descartar los encabezados (opcional)
        br.readLine();

        while ((linea = br.readLine()) != null) {
            // Separar los valores por el delimitador, asumiendo que es una coma
            String[] valores = linea.split(",");
            
            // Asumir que el CSV tiene columnas en el siguiente orden: 
            // Código, Nombre, Género, Experimento (o el campo que corresponda)
            if (valores.length >= 4) {
          String codigo = valores[0];
          String nombre = valores[1];
          String material = valores[2];
          String color =valores[3];
          
         // Crear el objeto investigador        
        productos new_produ= new productos(codigo, nombre, material, color);              
        // Agregar el investigador a la lista
        agregarproductos(new_produ);
} else {
    JOptionPane.showMessageDialog(null, "Error: Línea inválida en el archivo CSV.", "Error", JOptionPane.ERROR_MESSAGE);
}
            }
    } catch (FileNotFoundException e) {
        JOptionPane.showMessageDialog(null, "Archivo no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
    }
     
}
     public static void serealizar() {
         try{
             String direccion="./archivoproductos/productos.bin";
             
             ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(direccion));
             salida.writeObject(listaproductos);
             salida.close();
             
             
             System.out.println("serealizado");
             
         }catch(IOException e){
             e.printStackTrace();
         }
     }
    public static Object desearelizar(){
         try{
             String direccion="./archivoproductos/productos.bin";
             ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(direccion));
             ArrayList<productos> lista_temp=(ArrayList<productos>) entrada.readObject();
             entrada.close();
             listaproductos=lista_temp;
             return lista_temp;
         }catch(Exception e){
             System.out.println(e.getMessage());
         }
         return new ArrayList<>();
     }
    
}
