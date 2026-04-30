package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Poblacion {

    private ColaListaEnlazada<Personas> poblacion;
    private ColaListaEnlazada<Personas> poblacion_mayor;

    public Poblacion() {
        poblacion = new ColaListaEnlazada<>();
        poblacion_mayor = new ColaListaEnlazada<>();
    }

    // 🔹 Cargar desde archivo
    public void archivoPersonas(String archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String cadena;

            while ((cadena = lector.readLine()) != null) {

                String[] partes = cadena.split(",");

                String nombre = partes[0].trim();
                int edad = Integer.parseInt(partes[1].trim());

                // evitar duplicados
                if (buscarPersonas(nombre) == null) {
                    poblacion.poneEnCola(new Personas(nombre, edad));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    // 🔹 Buscar sin romper la cola
    public Personas buscarPersonas(String nombre) {

        ColaListaEnlazada<Personas> aux = new ColaListaEnlazada<>();
        Personas encontrado = null;

        while (!poblacion.vacia()) {

            Personas p = poblacion.quitaDeCola();

            if (p.getNombre().equals(nombre)) {
                encontrado = p;
            }

            aux.poneEnCola(p);
        }

        // restaurar
        while (!aux.vacia()) {
            poblacion.poneEnCola(aux.quitaDeCola());
        }

        return encontrado;
    }

    // 🔹 Filtrar mayores
    public void insertarMayores(int mayoria) {

        ColaListaEnlazada<Personas> aux = new ColaListaEnlazada<>();

        while (!poblacion.vacia()) {

            Personas p = poblacion.quitaDeCola();

            if (p.getEdad() >= mayoria) {
                poblacion_mayor.poneEnCola(p);
            }

            aux.poneEnCola(p);
        }

        // restaurar original
        while (!aux.vacia()) {
            poblacion.poneEnCola(aux.quitaDeCola());
        }
    }

    // 🔹 Mostrar mayores (consumiendo la cola)
    public void mostrarColaMayores() {

        while (!poblacion_mayor.vacia()) {

    Personas p = poblacion_mayor.quitaDeCola();

    System.out.println(p.getNombre() + "|" + p.getEdad());
}
    }

    // 🔹 Mostrar población sin destruirla
    public void mostrarPoblacion() {

        ColaListaEnlazada<Personas> aux = new ColaListaEnlazada<>();

        while (!poblacion.vacia()) {

            Personas p = poblacion.quitaDeCola();
            System.out.println(p);

            aux.poneEnCola(p);
        }

        while (!aux.vacia()) {
            poblacion.poneEnCola(aux.quitaDeCola());
        }
    }
}