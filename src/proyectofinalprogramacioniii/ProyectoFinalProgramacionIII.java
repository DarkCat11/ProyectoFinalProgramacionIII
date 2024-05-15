/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectofinalprogramacioniii;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author PC
 */
public class ProyectoFinalProgramacionIII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner (System.in);
        ManejoDeArchivos CSV = new ManejoDeArchivos();
        
        String dpi = null;
        String nombre = null;
        int id = 0;
        boolean flag = false;
       
         IngresarDatosCSV(id, dpi, nombre, flag);
            
            
    }
    
    public static boolean ValidarNumeros(String numero)
    {
        return numero.matches("[0-9]{13,13}");
    }
   
    public static boolean ValidarLetras(String texto)
    {
        return texto.matches("[a-zA-Z]*");
    }
    
    public static void IngresarDatosCSV(int id, String dpi, String nombre, boolean flag)
    {
        Scanner cin = new Scanner (System.in);
        ManejoDeArchivos CSV = new ManejoDeArchivos();
       
        
        for(int i = 0; i < 4 ; i ++)
        {
           id = CSV.ID();
           System.out.print("\nSu ID: " + id);
           
           System.out.print("\nIngrese su dpi: ");
           dpi = cin.next();
           
           while(flag == false)
           {
               if(!ValidarNumeros(dpi))
               {
               System.out.print("\nDPI NO VALIDO, VUELVA A INGRESAR: ");
               dpi = cin.next();
               }else{
                   flag = true;
               }
           }
           
           flag = false;
           
           System.out.print("\nIngrese su nombre: "); 
           nombre = cin.next();
           
           
           while(flag == false)
           {
               if(!ValidarLetras(nombre))
               {
               System.out.print("\nINGRESO SU NOMBRE INCORRECTAMENTE, VUELVA A INGRESAR: ");
               nombre = cin.next();
               }else{
                   flag = true;
               }
           }
           flag = false;
           CSV.GenerarArchivo("Pasajeros.csv", id, dpi, nombre);
        }
    }
}
