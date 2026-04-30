package com.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ///System.out.println( "Hello World!" );
        Clase_Principal clase = new Clase_Principal();
        clase.agregarNumeros(0, 10);
        clase.agregarNumeros(1, 11);
        clase.agregarNumeros(2, 12);
        clase.agregarNumeros(3, 13);
        clase.agregarNumeros(4, 14);
        clase.agregarNumeros(5, 15);

        clase.mostrarListas();
        System.out.println("------------------------------------------------------");
        clase.invertirNumeros();;
        clase.mostrarListas();
        
    }
}
