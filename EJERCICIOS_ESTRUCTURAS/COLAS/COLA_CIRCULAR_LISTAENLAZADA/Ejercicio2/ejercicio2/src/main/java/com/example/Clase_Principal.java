package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Clase_Principal {

    private ColaCircularListaEnlazada<Integer> datos;

    public Clase_Principal() {
        datos = new ColaCircularListaEnlazada<>();
    }

    // 🔹 Leer archivo e insertar sin duplicados
    public void archivoAdquisiciones(String archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = lector.readLine()) != null) {

                int numero;

                try {
                    numero = Integer.parseInt(linea.trim());
                } catch (NumberFormatException e) {
                    continue; // ignora líneas inválidas
                }

                // evitar duplicados
                if (!datos.contieneCircular(numero)) {
                    datos.poneEnCola(numero);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    // 🔹 Mostrar cola SIN destruirla
    public void mostrarColaCircular() {

        if (datos.vacia()) {
            System.out.println("Cola vacía");
            return;
        }

        int tamanio = datos.tamano();

        for (int i = 0; i < tamanio; i++) {
            int valor = datos.quitaDeCola();
            System.out.println(valor);
            datos.poneEnCola(valor); // lo vuelvo a insertar
        }
    }

    // 🔹 Buscar número
    public boolean buscarPorNumero(int numero) {
        return datos.contieneCircular(numero);
    }

    // 🔹 Tamaño
    public int tamano() {
        return datos.tamano();
    }
    public void rotar(int k) {

    if (datos.vacia() || k <= 0) return;

    int n = datos.tamano();

    // optimización: no dar vueltas de más
    k = k % n;

    for (int i = 0; i < k; i++) {
        int valor = datos.quitaDeCola();
        datos.poneEnCola(valor);
    }
}
}