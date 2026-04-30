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
        Aula aula = new Aula();
        aula.archivoAlumnos("EJERCICIO1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\Alumnos.txt");
        aula.mostrarAula();
        System.out.println("-----------------------------------------------------------------");
        aula.eliminarPromedioBajo();
        System.out.println("-----------------------------------------------------------------");
        aula.mostrarAula();
        System.out.println("-----------------------------------------------------------------");

    }
}
