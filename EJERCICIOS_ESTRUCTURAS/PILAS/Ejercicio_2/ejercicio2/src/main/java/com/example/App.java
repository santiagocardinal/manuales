package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        EliminarConcurrencias concurrencias = new EliminarConcurrencias();
        concurrencias.archivoAdquisiciones("Ejercicio_2\\ejercicio2\\src\\main\\java\\com\\example\\Source\\Datos.txt");
        concurrencias.agregarPila();
        concurrencias.mostrarLista();
        System.out.println("__________________________________________________________________");
        concurrencias.mostrarPila();
    /*PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

    pila.mete(1);
    pila.mete(2);
    pila.mete(3);
    pila.mete(4);

    System.out.println("Tope: " + pila.tope()); // 4

    System.out.println("Sacando:");
    while (!pila.esVacia()) {
        System.out.println(pila.saca());
    }*/
}
}
