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
    
    
    public void borrar(Object o){
        borrar(raiz,o);
    }
    
    private NodoBin borrar(NodoBin n, Object o){
        if(n==null){
            return null;
        }
        else{
            if((Integer)o<(Integer)n.getDato()){
                n.setIzq(borrar(n.getIzq(),o));
            }
            else{
                if((Integer)o>(Integer)n.getDato()){
                n.setDer(borrar(n.getDer(),o));
                }
                else{ //Ya encontré el que quiero eliminar!
                    if(n.getIzq()!=null && n.getDer()!=null){
                        //Es decir que tiene los 2 hijos+
                        
                        NodoBin minimo = buscarMin(n.getDer()); //Aqui es cuando asignamos quien sustituye
                        //el lugar del que sera eliminado.
                        n.setDato(minimo.getDato());
                        n.setDer(borrarMin(n.getDer()));
                        
                        //Agregar de alguna forma el otro metodo para reubicar el nuevo nodo (Maximo)
                        
                        
                        
                        //
                        
                    }
                    
                    
                    else{ //Que no tiene 2 hijos, puede tener 1 o ninguno
                        n = (n.getIzq()!=null)? n.getIzq():n.getDer(); //Otra forma de hacer un if para 
                        //asignar un valor, antes del ? es la condicion y las sentencias separadas por el signo : es 
                        //la afirmacion y el en caso contrario.
                    }
                }
            }
        }
        
        return n;
    }
    
    private NodoBin buscarMin(NodoBin n){
        while(n.getIzq()!=null){
            n = n.getIzq();
        }
        return n;
    }
    
    private NodoBin borrarMin(NodoBin n){
        if(n.getIzq()!=null){
            n.setIzq(borrarMin(n.getIzq()));
            return n;
        }
        else{
            return n.getDer();
        }
    }
    
    private NodoBin buscarMax(NodoBin n){
        while(n.getDer()!=null){
            n = n.getDer();
        }
        return n;
    }
    
    private NodoBin borrarMax(NodoBin n){
        if(n.getDer()!=null){
            n.setDer(borrarMax(n.getDer()));
            return n;
        }
        else{
            return n.getIzq();
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
        
        System.out.println("Arbol inOrden");
        arbol.inOrden();
        
        /*System.out.println("Arbol preOrden");
        arbol.preOrden();
        
        System.out.println("Arbol posOrden");
        arbol.posOrden();
        */
       
       arbol.borrar(14);
       System.out.println("\nBorrando el 602");
       arbol.inOrden();
        
    }
    
    
    
}
