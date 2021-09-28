/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Vista.VistaT;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author md 
 */
public class Buscador {

    VistaT t;
    String path = "";
    public File[] ficheros;

    public Buscador(String ruta) {
        this.path = ruta;
        ficheros = null;
    }
    
    public void ponruta(String path) {
        this.path = path;
    }

    public boolean Existe() { //si no existe o no es un directorio devuelve false

        File f;
        try {
            f = new File(path); //se crea el objeto con la ruta indicada
            if (f.exists()) {
                if (f.isDirectory()) {
                    ficheros = f.listFiles();//se llena el array con el contenido de la carpeta		
                    return true;
                } else {
                    JOptionPane.showMessageDialog(t, "Error");
                }
            } else {
            JOptionPane.showMessageDialog(t, "error");

            }
        } catch (NullPointerException e) {
            System.err.println("No existe la ruta");
        } catch (SecurityException e) {
            System.err.println("Error de seguridad");
        }
        return false;
    }

}


