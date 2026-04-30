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
        Poblacion poblacion = new Poblacion();
        poblacion.archivoPersonas("Ejercicio1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\Personas");
        poblacion.insertarMayores(18);
        poblacion.mostrarColaMayores();
    }
}
