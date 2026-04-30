package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerArchivos {
    private ListaEnlazada<Numeros> insercion1;
        private ListaEnlazada<Numeros> insercion2;

    public LeerArchivos(){
        insercion1 = new ListaEnlazada<>();
        insercion2 = new ListaEnlazada<>();
    }
 
    public void archivo1(String archivo) 
    {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) //leo el archivo linea por linea
        {
            String cadena;//variable para almacenar cada linea del archivo

            while ((cadena = lector.readLine()) != null) //mientras que la siguiente linea no sea nula, se procesa la linea actual
            {
                int numero    = Integer.parseInt(cadena.trim());

                Numeros numeroExistente = insercion1.buscar(a-> a.getNum() == numero); //pregunto si ya tengo un libro con el mismo codigo
                if(numeroExistente == null){
                    Numeros nuevo = new Numeros(numero);
                    insercion1.agregar(nuevo);
                }            
            }

        } catch (IOException e) 
        {
            System.out.println("Error al leer adquisiciones: " + e.getMessage());//tira error si no puede leer el archivo, mostrando un mensaje de error con la descripción del problema.
        }
    }

    public void archivo2(String archivo) 
    {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) //leo el archivo linea por linea
        {
            String cadena;//variable para almacenar cada linea del archivo

            while ((cadena = lector.readLine()) != null) //mientras que la siguiente linea no sea nula, se procesa la linea actual
            {
                int numero    = Integer.parseInt(cadena.trim());

                Numeros numeroExistente = insercion2.buscar(a-> a.getNum() == numero); //pregunto si ya tengo un libro con el mismo codigo
                if(numeroExistente == null){
                    Numeros nuevo = new Numeros(numero);
                    insercion2.agregar(nuevo);
                }            
            }

        } catch (IOException e) 
        {
            System.out.println("Error al leer adquisiciones: " + e.getMessage());//tira error si no puede leer el archivo, mostrando un mensaje de error con la descripción del problema.
        }
    }

    public TDALista<Numeros> eliminarDuplicados(TDALista<Numeros> lista) {

    ListaEnlazada<Numeros> resultado = new ListaEnlazada<>();

    for (int i = 0; i < lista.tamano(); i++) {

        Numeros actual = lista.obtener(i);

        Numeros existe = resultado.buscar(a -> a.getNum() == actual.getNum());

        if (existe == null) {
            resultado.agregar(actual);
        }
    }

    return resultado;
}

   public void intercalarListas() {

    TDALista<Numeros> insercion3 = insercion1.intercalar(insercion2);

    TDALista<Numeros> sinDuplicados = eliminarDuplicados(insercion3);

    for (int i = 0; i < sinDuplicados.tamano(); i++) {
        System.out.println(sinDuplicados.obtener(i).getNum());
    }
}

}
