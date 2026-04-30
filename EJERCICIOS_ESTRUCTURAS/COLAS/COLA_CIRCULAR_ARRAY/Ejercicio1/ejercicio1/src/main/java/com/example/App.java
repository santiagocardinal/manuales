package com.example;

public class App {

    public static void main(String[] args) {

        Eliminar_Duplicados ed = new Eliminar_Duplicados(10);

        // 🔹 cargar desde archivo
        ed.cargarArchivo("Ejercicio1\\ejercicio1\\src\\main\\java\\com\\example\\Sources\\Numeros.txt");

        System.out.println("ANTES:");
        ed.mostrar();

        ed.eliminarDuplicados();

        System.out.println("DESPUÉS:");
        ed.mostrar();
    }
}