/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalprogramacioniii;

import javax.swing.JFrame;

/**
 *
 * @author PC
 */
public class ArbolGrafico extends JFrame {
    private ArbolBusqueda Arbol;
    public static final int diametro = 30;
    public static final int radio = diametro/2;
    public static final int ancho = 30;
    
    public void setArbol(ArbolBusqueda arbol)
    {
        this.Arbol = arbol;
        repaint();
        
    }
    
    
}
