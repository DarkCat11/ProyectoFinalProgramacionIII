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
import javax.swing.JFrame;

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
        int menu;
        int BusquedaID;
        boolean flag = false;

        //IngresarDatosCSV(id, dpi, nombre, flag);
        System.out.println("Menu de acciones");
        System.out.println("1. Insertar datos de arhivo CSV al arbol de busqueda");
        System.out.println("2. Leer arbol de busqueda");
        System.out.println("3. Buscar un nodo en el arbol de busqueda");
        System.out.println("4. Eliminar un dato en el arbol de busqueda");
        System.out.println("5. Mostrar arbol grafico");
        System.out.println("6. Salir");

        
        
        do{
            
            System.out.print("\nIngresar opcion: ");
           try
           {
             menu = cin.nextInt();  
           }catch(Exception e){
               System.out.print("Ingrese una opcion valida: ");
               menu = cin.nextInt();  
            }
                
            
            
            switch(menu)
            {
                case 1:
                    try {
                    BufferedReader Leer = new BufferedReader(new FileReader("Pasajeros.csv"));
                    String Linea = "";
                    while ((Linea = Leer.readLine()) != null) {
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
                break;
           
                case 2:
                    if (!Arbol.estaVacio()) {
                        Arbol.LeerArbol(Arbol.raiz);
                    } else {
                        System.out.println("Esta vacio");
                    }
                    break;
                    
                case 3:
                    System.out.print("\nIngrese ID a buscar: ");
                    id = cin.nextInt();

                    long InicioEjecucion = System.nanoTime();
                    System.out.print("Sus datos son: " + Arbol.BusquedaPorID(id));
                    long FinalEjecucion = System.nanoTime();

                    System.out.println("\nDuracion de busqueda: " + ((FinalEjecucion - InicioEjecucion) / 1000) + "µs");
                    break;
       
                case 4:
                    
                    if (!Arbol.estaVacio()) {
                        System.out.print("\nIngrese ID a eliminar: ");
                        id = cin.nextInt();
                        if (Arbol.EliminarNodo(id) == false) {
                            System.out.println("No se encuentra dentro del arbol");
                        } else {
                            System.out.println("Nodo eliminado");
                            Arbol.LeerArbol(Arbol.raiz);
                        }
                    }
                    break;
                    
                case 5:
                     
                     Arbol.DibujarArbol();
                    break;
            }

        }while(menu !=6);
        
        
        
        
        
       
        
        
        
        
    }

    public static boolean ValidarNumeros(String numero) {
        return numero.matches("[0-9]{13,13}");
    }

    public static boolean ValidarLetras(String texto) {
        return texto.matches("[a-zA-Z]*");
    }
    

    public static void IngresarDatosCSV(int id, String dpi, String nombre, boolean flag) {
        Scanner cin = new Scanner(System.in);
        ManejoDeArchivos CSV = new ManejoDeArchivos();

        for (int i = 0; i < 10; i++) {
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
