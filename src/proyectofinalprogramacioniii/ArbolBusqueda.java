/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalprogramacioniii;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author PC
 */
public class ArbolBusqueda {

    NodoArbol raiz;

    public ArbolBusqueda() {
        raiz = null;

    }
    
    public void DibujarArbol()
    {
        try
        {
            EscribirArchivo("datos.dot",  CodigoGraphiz());
            ProcessBuilder proceso;
            proceso = new ProcessBuilder("dot" , "-Tpng" , "-o", "ArbolDeBusqueda.png", "datos.dot");
            
            proceso.redirectErrorStream(true);
            proceso.start();
            
        }catch(Exception e)
        {
            
        }
    }
    
    private void EscribirArchivo(String Ruta, String id)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try{
            fichero = new FileWriter(Ruta);
            pw = new PrintWriter(fichero);
            pw.write(id);
            pw.close();
            fichero.close();
        }catch(Exception e)
        {
            
        }finally {
            if(pw != null)
            {
                pw.close();
            }
        }
    }
    public String CodigoGraphiz()
    {
        String Texto = "digraph G\n"
                + "node [shape = circle]\n"
                + "node [style = filled]\n"
                + "node [fillcolor = \"#EEEEE\"]\n"
                + "node [color = \"#EEEEE\"]\n"
                + "edge [color = \"#31CEF0\"]\n";   
        if(raiz != null)
        {
            Texto += raiz.textoGraphiz();
            
        }
        Texto += "\n}";
        return Texto;
    }

    public void InsertarDatos(int id, String dpi, String nombre) {
        NodoArbol newTree= new NodoArbol(id, dpi, nombre);
        if(raiz == null)
        {
            raiz = newTree;
        }else{
            NodoArbol ArbolAuxiliar = raiz;
            NodoArbol Raiz;
            
            while(true)
            {
                Raiz = ArbolAuxiliar;
                if(id < ArbolAuxiliar.ID)
                {
                    ArbolAuxiliar = ArbolAuxiliar.RamaIzquierda;
                    if(ArbolAuxiliar == null)
                    {
                        Raiz.RamaIzquierda = newTree;
                        return;
                    }
                }else
                {
                    ArbolAuxiliar = ArbolAuxiliar.RamaDerecha;
                    if(ArbolAuxiliar == null)
                    {
                        Raiz.RamaDerecha = newTree;
                        return;
                    }
                }
            }
        }
        

    }
    
    public boolean EliminarNodo(int id)
    {
        NodoArbol Auxiliar = raiz;
        NodoArbol Raiz = raiz;
        boolean RamaIzquierda = true;
        
        while(Auxiliar.ID != id)
        {
            Raiz = Auxiliar;
            if(id < Auxiliar.ID)
            {
                 RamaIzquierda = true;
                 Auxiliar = Auxiliar.RamaIzquierda;
                 
            }else{
                
                 RamaIzquierda = false;
                 Auxiliar = Auxiliar.RamaDerecha;
            }
            if(Auxiliar == null)
            {
                System.out.println("No se encontro el dato");
               return false;
            }
        }
        if (Auxiliar.RamaIzquierda == null && Auxiliar.RamaDerecha == null)
        {
            if (Auxiliar == raiz) {
                raiz = null;
            } else if (RamaIzquierda) {
                Raiz.RamaIzquierda = null;
            } else {
                Raiz.RamaDerecha = null;
            }
        }else if(Auxiliar.RamaDerecha == null)
        {
            if (Auxiliar == raiz) {
                raiz = Auxiliar.RamaIzquierda;
            } else if (RamaIzquierda) {
                Raiz.RamaIzquierda = Auxiliar.RamaIzquierda;
            } else {
                Raiz.RamaDerecha = Auxiliar.RamaIzquierda;
            }
        }else if(Auxiliar.RamaIzquierda == null)
        {
            if (Auxiliar == raiz) {
                raiz = Auxiliar.RamaDerecha;
            } else if (RamaIzquierda) {
                Raiz.RamaIzquierda = Auxiliar.RamaDerecha;
            } else {
                Raiz.RamaIzquierda = Auxiliar.RamaDerecha;
            }
        }else
        {
            NodoArbol Cambio = ObtenerNodo(Auxiliar);
            if(Auxiliar == raiz)
            {
                Auxiliar = Cambio;
            }
            else if(RamaIzquierda)
            {
                Raiz.RamaIzquierda = Cambio;
                
            }else
            {
                Raiz.RamaDerecha = Cambio;
            }
            Cambio.RamaIzquierda = Auxiliar.RamaIzquierda;
        }
        
        return true;
        
    }
    
    public NodoArbol ObtenerNodo(NodoArbol cambio)
    {
        NodoArbol CambioRaiz = cambio;
        NodoArbol Cambio = cambio;
        NodoArbol Auxiliar = cambio.RamaDerecha;
        
        while(Auxiliar != null)
        {
            CambioRaiz = Cambio;
            Cambio = Auxiliar;
            Auxiliar = Auxiliar.RamaIzquierda;
            
            
        }
        if(Cambio != cambio.RamaDerecha)
        {
            CambioRaiz.RamaIzquierda = Cambio.RamaDerecha;
            Cambio.RamaDerecha = cambio.RamaDerecha;
        }
        System.out.println("Los datos del nodo : " + Cambio);
        return Cambio;
    }
    
    public NodoArbol BusquedaPorID(int id)
    {
        NodoArbol Auxiliar = raiz;
        while(Auxiliar.ID != id)
        {
            if(id < Auxiliar.ID)
            {
                Auxiliar = Auxiliar.RamaIzquierda;
                
            }else
            {
                Auxiliar = Auxiliar.RamaDerecha;
            }
            if(Auxiliar == null)
            {
               return null; 
            }
        }
        return Auxiliar;
        
    }
    
    public boolean estaVacio()
    {
        return raiz == null;
    }
       
    public void LeerArbol(NodoArbol Raiz)
    {
     if(Raiz != null)
     {
         LeerArbol(Raiz.RamaIzquierda);
         System.out.println("ID: " + Raiz.ID + "\tDPI:" + Raiz.DPI + "\tNombre: " + Raiz.NOMBRE);
         LeerArbol(Raiz.RamaDerecha);
     }
    }
}
