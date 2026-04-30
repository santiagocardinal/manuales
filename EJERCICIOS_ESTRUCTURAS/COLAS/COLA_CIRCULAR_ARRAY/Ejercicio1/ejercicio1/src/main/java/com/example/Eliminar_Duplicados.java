package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Eliminar_Duplicados {

private ColaCircularArray<Integer> cola;

    public Eliminar_Duplicados(int capacidad) {
        cola = new ColaCircularArray(capacidad);
    }

    // 🔹 Cargar archivo
    public void cargarArchivo(String archivo) {

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            String linea;

            while ((linea = br.readLine()) != null) {
                int num = Integer.parseInt(linea.trim());
                cola.poneEnCola(num);
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void eliminarDuplicados() {

    ColaCircularArray<Integer> aux = new ColaCircularArray<>(cola.tamano());

    while (!cola.vacia()) {

        int actual = (int) cola.quitaDeCola();

        // si NO está en aux → lo agrego
        if (!contiene(aux, actual)) {
            aux.poneEnCola(actual);
        }
    }

    // reconstruyo la original
    while (!aux.vacia()) {
        cola.poneEnCola(aux.quitaDeCola());
    }
}

    // 🔹 Mostrar
    public void mostrar() {

        int n = cola.tamano();

        for (int i = 0; i < n; i++) {
            int val = cola.quitaDeCola();
            System.out.println(val);
            cola.poneEnCola(val);
        }
    }
    private boolean contiene(ColaCircularArray<Integer> c, int valor) {

    int n = c.tamano();
    boolean encontrado = false;

    for (int i = 0; i < n; i++) {

        int temp = c.quitaDeCola();

        if (temp == valor) {
            encontrado = true;
        }

        c.poneEnCola(temp);
    }

    return encontrado;
}
}
