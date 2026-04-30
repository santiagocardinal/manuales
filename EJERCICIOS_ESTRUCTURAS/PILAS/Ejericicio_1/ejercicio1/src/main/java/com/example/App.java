package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //System.out.println( "Hello World!" );
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();
       
        pila.mete(1);
        pila.mete(3);
        pila.mete(5);
        pila.mete(2);
        pila.mete(4);
        pila.ordenarPila();
        
        while(!pila.esVacia()){
            System.out.println(pila.saca());
        }
    }
}
