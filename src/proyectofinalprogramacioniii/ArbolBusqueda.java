/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalprogramacioniii;

/**
 *
 * @author PC
 */
public class ArbolBusqueda {

    NodoArbol raiz;

    public ArbolBusqueda() {
        raiz = null;

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
