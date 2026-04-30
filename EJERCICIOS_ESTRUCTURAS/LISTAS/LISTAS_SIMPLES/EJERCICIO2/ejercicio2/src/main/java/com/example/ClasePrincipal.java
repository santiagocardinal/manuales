package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ClasePrincipal {

    private ListaEnlazada<Integer> numeros;

    public ClasePrincipal(){
        numeros = new ListaEnlazada<>();
    }

    // Getter (necesario para tests)
    public ListaEnlazada<Integer> getNumeros(){
        return numeros;
    }

    // 🔹 Carga desde archivo + inserción ordenada + sin duplicados
    public void archivoNumeros(String archivo){

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String cadena;

            while ((cadena = lector.readLine()) != null) {

                int numero;

                try {
                    numero = Integer.parseInt(cadena.trim());
                } catch (NumberFormatException e) {
                    continue;
                }

                if (!contiene(numero)) {
                    agregarOrdenado(numero);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    // 🔹 Inserción ordenada (SIN duplicados)
    public void agregarOrdenado(int numero){

        if (contiene(numero)) return;

        int i = 0;

        while (i < numeros.tamano() && numeros.obtener(i) < numero){
            i++;
        }

        numeros.agregar(i, numero);
    }

    // 🔹 Buscar si existe
    public boolean contiene(int numero){

        int i = 0;

        while (i < numeros.tamano()){
            if (numeros.obtener(i) == numero){
                return true;
            }
            i++;
        }

        return false;
    }

    // 🔹 Insertar en posición (NO respeta orden)
    public void insertarEnPosicion(int posicion, int numero){

        if (posicion < 0 || posicion > numeros.tamano()){
            System.out.println("Posición inválida");
            return;
        }

        numeros.agregar(posicion, numero);
    }

    // 🔹 Mostrar lista
    public void mostrar(){

        if (numeros.esVacio()){
            System.out.println("Lista vacía");
            return;
        }

        System.out.println("NUMEROS ORDENADOS:");

        for (int i = 0; i < numeros.tamano(); i++){
            System.out.println(numeros.obtener(i));
        }
    }
}