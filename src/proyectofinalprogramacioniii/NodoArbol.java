/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalprogramacioniii;

/**
 *
 * @author PC
 */
public class NodoArbol {
    int ID;
    String DPI;
    String NOMBRE;
    
    NodoArbol RamaDerecha, RamaIzquierda;
    
    public NodoArbol(int id, String dpi, String nombre)
    {
        this.ID = id;
        this.DPI = dpi;
        this.NOMBRE = nombre;
        this.RamaDerecha = null;
        this.RamaIzquierda = null;
    }
    
    public String toString(){
        return "\nId de pasajero: " + ID + " \nDocumento personal de identificacion: " + DPI + "\nNombre del pasajero: " + NOMBRE;
    }
}
