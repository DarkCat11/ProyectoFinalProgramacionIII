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

    public void InsetarDatos(int id, String dpi, String nombre) {
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
}
