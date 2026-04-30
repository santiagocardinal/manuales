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
        /*lista_doble = [11, 22, 33, 44, 55, 66, 77, 88, 99, 110] */
        ListaEnlazadaDoble lista = new ListaEnlazadaDoble<>();
        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(33);
        lista.agregar(44);
        lista.agregar(55);
        lista.agregar(66);
        lista.agregar(77);
        lista.agregar(88);
        lista.agregar(99);
        lista.agregar(110);

        lista.invertir();
        for(int i =0; i< lista.tamano();i++){
            System.out.println(lista.obtener(i));
        }
    }
}
