package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Clase_Principal {

    private ColaListaEnlazada<Integer> numeros;
    private ListaEnlazada<Integer> lista_numeros;

    public Clase_Principal(){
        numeros = new ColaListaEnlazada<>();
        lista_numeros = new ListaEnlazada<>();
    }

    // 🔹 Cargar archivo (evita duplicados en lista base)
    public void archivoAdquisiciones(String archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String cadena;

            while ((cadena = lector.readLine()) != null) {

                int numero = Integer.parseInt(cadena.trim());

                if (!lista_numeros.contiene(numero)) {
                    lista_numeros.agregar(numero);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer adquisiciones: " + e.getMessage());
        }
    }

    // 🔹 Pasar lista → cola
    public void numerosAcola(){

        for(int i = 0; i < lista_numeros.tamano(); i++){
            numeros.poneEnCola(lista_numeros.obtener(i));
        }
    }

    // 🔥 EJERCICIO 3 — eliminar duplicados en cola
    public void eliminarDuplicadosCola() {

        ListaEnlazada<Integer> vistos = new ListaEnlazada<>();
        ColaListaEnlazada<Integer> aux = new ColaListaEnlazada<>();

        while (!numeros.vacia()) {

            int valor = numeros.quitaDeCola();

            if (!vistos.contiene(valor)) {
                vistos.agregar(valor);
                aux.poneEnCola(valor);
            }
        }

        // restaurar sin duplicados
        while (!aux.vacia()) {
            numeros.poneEnCola(aux.quitaDeCola());
        }
    }

    // 🔹 Mostrar cola SIN romperla
    public void mostrarCola(){

        ColaListaEnlazada<Integer> aux = new ColaListaEnlazada<>();

        while (!numeros.vacia()) {
            int valor = numeros.quitaDeCola();
            System.out.println(valor);
            aux.poneEnCola(valor);
        }

        // restaurar
        while (!aux.vacia()) {
            numeros.poneEnCola(aux.quitaDeCola());
        }
    }

    // 🔹 Mostrar lista (debug útil)
    public void mostrarLista(){

        for(int i = 0; i < lista_numeros.tamano(); i++){
            System.out.println(lista_numeros.obtener(i));
        }
    }

    // 🔹 Getters (para testing)
    public ColaListaEnlazada<Integer> getCola(){
        return numeros;
    }

    public ListaEnlazada<Integer> getLista(){
        return lista_numeros;
    }
}