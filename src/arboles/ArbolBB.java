/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arboles;

import java.util.Objects;

/**
 *
 * @author A15216350
 */
public class ArbolBB {
    
    protected NodoBin raiz;
    
    public ArbolBB(Object o){
        raiz = new NodoBin(o);
    }
    
    public void inOrden(){
        if(raiz!=null){
            raiz.inOrden();
        }
    }
    
    public void preOrden(){
        if(raiz!=null){
            raiz.preOrden();
        }
    }
    
    public void posOrden(){
        if(raiz!=null){
            raiz.posOrden();
        }
    }
    
    public void insertar(Object o){
        insertarOrdenado(raiz, o);
    }
    
    private void insertarOrdenado(NodoBin n, Object o){
        if((Integer)o < (Integer)n.getDato()){
            
            if(n.getIzq()==null){
                n.setIzq(new NodoBin(o));
            }
            else{
                insertarOrdenado(n.getIzq(),o);
            }
            
        }
        else{
            
            if((Integer)o > (Integer)n.getDato()){
                if(n.getDer()==null){
                    n.setDer(new NodoBin(o));
                }
                else{
                    insertarOrdenado(n.getDer(),o);
                }
            }
            
        }
        
    }
    
    public boolean buscar(Object o){
        return buscar(raiz,o);
    }
    
    public boolean buscar(NodoBin n, Object o){
        
        if(Objects.equals((Integer)o,(Integer)n.getDato())){
            return true;
        }
        else{
            if((Integer)o < (Integer)n.getDato()){
                if(n.izq!=null){
                    return buscar(n.getIzq(),o);
                }
                else{
                    return false;
                }
            }
            else{
                if(n.getDer()!=null){
                    return buscar(n.getDer(),o);
                }
                else{
                    return false;
                }
            }
        }
        
        
    }
    
    
    public static void main(String[] args) {
        ArbolBB arbol = new ArbolBB(28);
        arbol.insertar(92);
        arbol.insertar(14);
        arbol.insertar(73);
        arbol.insertar(1);
        arbol.insertar(91);
        arbol.insertar(100);
        arbol.insertar(15);
        arbol.insertar(74);
        arbol.insertar(2000);
        arbol.insertar(602);
        
        if(arbol.buscar(602)){
            System.out.println("El dato si se encuentra");
        }
        else{
            System.out.println("El dato no se encuentra");
        }
        
       /* System.out.println("Arbol inOrden");
        arbol.inOrden();
        
        System.out.println("Arbol preOrden");
        arbol.preOrden();
        
        System.out.println("Arbol posOrden");
        arbol.posOrden();
        */
        
    }
    
    
    
}
