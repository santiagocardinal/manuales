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
        Clase_principal clase = new Clase_principal();
        clase.getCola().poneEnCola(1);
        clase.getCola().poneEnCola(2);
        clase.getCola().poneEnCola(3);
        clase.getCola().poneEnCola(4);
        clase.getCola().poneEnCola(5);
        clase.getCola().poneEnCola(6);

        clase.pasarDatosPila();
        clase.pasarDatosCola();
        clase.mostrarCola();
        System.out.println("____________________");
        clase.mostrarPila();
        
    }
}
