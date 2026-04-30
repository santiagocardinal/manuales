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
        Mercado mercado = new Mercado();
        mercado.archivoProdcutos("Ejercicio_1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\Productos");
        System.out.println("-----------------------------------------------------");
        mercado.mostrarProductosRestantes();
        System.out.println("-----------------------------------------------------");
        mercado.eliminarPreciosElevados(300);
        System.out.println("-----------------------------------------------------");
        mercado.mostrarProductosRestantes();
    }
}
