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
        LeerArchivos clase = new LeerArchivos();
        clase.archivo1("Ejercicio1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\1");
        clase.archivo2("Ejercicio1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\2");
        clase.diferenciaEntreListas();
    }
}
