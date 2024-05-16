/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalprogramacioniii;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author PC
 */
public class ManejoDeArchivos {
    
    ArbolBusqueda IngresarDatos = new ArbolBusqueda();
    
    void GenerarArchivo(String Pasajeros, int ID, String DPI, String nombre){
        
        try{
            FileWriter Usuarios = new FileWriter(Pasajeros, true);
            BufferedWriter bufferedwriter = new BufferedWriter(Usuarios);
            PrintWriter printwriter = new PrintWriter(bufferedwriter);
            printwriter.println(ID + "," + DPI + "," + nombre);
            
            printwriter.flush();
            printwriter.close();
            
            
        }catch(IOException e)
        {
            System.out.print(e);
        }
    }
    
     int ID()
    {
        Random Numero = new Random();
        int NumeroRandom = Numero.nextInt((99999 + 1) + 1);
        return NumeroRandom;
    }
     
}
