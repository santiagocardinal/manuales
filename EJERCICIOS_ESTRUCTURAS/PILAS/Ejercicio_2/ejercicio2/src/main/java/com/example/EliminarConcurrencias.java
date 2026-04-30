package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EliminarConcurrencias {

    private PilaListaEnlazada<Numeros> numeros;
    private ListaEnlazada<Numeros>prueba_concurrencia;

    public EliminarConcurrencias(){
        numeros = new PilaListaEnlazada<>();
        prueba_concurrencia= new ListaEnlazada<>();
    }

    public void archivoAdquisiciones(String archivo) 
    {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) //leo el archivo linea por linea
        {
            String cadena;//variable para almacenar cada linea del archivo

            while ((cadena = lector.readLine()) != null) //mientras que la siguiente linea no sea nula, se procesa la linea actual
            {

                int numero_nuevo = Integer.parseInt(cadena.trim());

                Numeros existente = prueba_concurrencia.buscar(a -> a.getNum() == numero_nuevo);

                if (existente == null){
                    prueba_concurrencia.agregar(new Numeros(numero_nuevo));
                }
            }

        } catch (IOException e) 
        {
            System.out.println("Error al leer adquisiciones: " + e.getMessage());//tira error si no puede leer el archivo, mostrando un mensaje de error con la descripción del problema.
        }

    }
    
    public void agregarPila(){
        for(int i =0; i< prueba_concurrencia.tamano();i++){
            numeros.mete(prueba_concurrencia.obtener(i));
        }
    }

    public void mostrarLista(){
                for(int i =0; i< prueba_concurrencia.tamano();i++){
                System.out.println(prueba_concurrencia.obtener(i));
                }
    }

    public void mostrarPila(){
        while(!numeros.esVacia()){
            System.out.println(numeros.saca());
        }
    }
    
}
