/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalprogramacioniii;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class ProyectoFinalProgramacionIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner cin = new Scanner(System.in);
        ManejoDeArchivos CSV = new ManejoDeArchivos();
        ArbolBusqueda Arbol = new ArbolBusqueda();
        
        int id = 0;
        String dpi = null;
        String nombre = null;
        
        int BusquedaID;
        boolean flag = false;

        //IngresarDatosCSV(id, dpi, nombre, flag);
        
        try {
            BufferedReader Leer = new BufferedReader(new FileReader("Pasajeros.csv"));
            String Linea = "";
            while((Linea = Leer.readLine())!= null)
            {
                String[] Separacion = Linea.split(",");
                
                id = Integer.parseInt(Separacion[0]);
                dpi = Separacion[1];
                nombre = Separacion[2];
                //System.out.print("\nID: " +id + "\nDPI: " + dpi + "\nNombre: " + nombre);
                Arbol.InsertarDatos(id, dpi, nombre);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejoDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManejoDeArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(!Arbol.estaVacio())
        {
              Arbol.LeerArbol(Arbol.raiz);
        }
        else{
            System.out.println("Esta vacio");
        }
        
        System.out.println("\nIngrese ID a buscar");
        id = cin.nextInt();
        
        System.out.print("Sus datos son: " + Arbol.BusquedaPorID(id));
      

    }

    public static boolean ValidarNumeros(String numero) {
        return numero.matches("[0-9]{13,13}");
    }

    public static boolean ValidarLetras(String texto) {
        return texto.matches("[a-zA-Z]*");
    }
    
    public static void LeerArchivo(int id, String dpi, String nombre)
     {
        
         
     }
    

    public static void IngresarDatosCSV(int id, String dpi, String nombre, boolean flag) {
        Scanner cin = new Scanner(System.in);
        ManejoDeArchivos CSV = new ManejoDeArchivos();

        for (int i = 0; i < 4; i++) {
            id = CSV.ID();
            System.out.print("\nSu ID: " + id);

            System.out.print("\nIngrese su dpi: ");
            dpi = cin.next();

            while (flag == false) {
                if (!ValidarNumeros(dpi)) {
                    System.out.print("\nDPI NO VALIDO, VUELVA A INGRESAR: ");
                    dpi = cin.next();
                } else {
                    flag = true;
                }
            }

            flag = false;

            System.out.print("\nIngrese su nombre: ");
            nombre = cin.next();

            while (flag == false) {
                if (!ValidarLetras(nombre)) {
                    System.out.print("\nINGRESO SU NOMBRE INCORRECTAMENTE, VUELVA A INGRESAR: ");
                    nombre = cin.next();
                } else {
                    flag = true;
                }
            }
            flag = false;
            CSV.GenerarArchivo("Pasajeros.csv", id, dpi, nombre);
        }
    }
}
