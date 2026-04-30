package com.example;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class AulaTest {

    private static final String archivo_nombres = "AlumnosTest.txt";

    // 🔧 Método auxiliar para crear el archivo
    private void crearArchivoBase() throws IOException {
        FileWriter alumnos = new FileWriter(archivo_nombres);
        alumnos.write("Ana,12,7.8\n");
        alumnos.write("Juan,18,10.5\n");
        alumnos.write("Maria,10,5.4\n");
        alumnos.close();
    }

    @Test
    public void testCargarAlumnos() throws IOException {

        crearArchivoBase();

        Aula a = new Aula();
        a.archivoAlumnos(archivo_nombres);

        assertNotNull(a.buscarPorNombre("Ana"));
        assertNotNull(a.buscarPorNombre("Juan"));
        assertNotNull(a.buscarPorNombre("Maria"));
    }

    @Test
    public void testBuscarPorNombreExistente() throws IOException {

        crearArchivoBase();

        Aula a = new Aula();
        a.archivoAlumnos(archivo_nombres);

        Alumno l = a.buscarPorNombre("Ana");

        assertNotNull(l);
        assertEquals("Ana", l.getNombre());
    }

    @Test
    public void testBuscarPorNombreNoExistente() throws IOException {

        crearArchivoBase();

        Aula a = new Aula();
        a.archivoAlumnos(archivo_nombres);

        assertNull(a.buscarPorNombre("Pedro")); // nombre que no existe
    }

    @Test
    public void testEliminarPromedioBajo() throws IOException {

        crearArchivoBase();

        Aula a = new Aula();
        a.archivoAlumnos(archivo_nombres);

        int eliminados = a.eliminarPromedioBajo();

        // Maria tiene promedio 5.4 → debería eliminarse
        assertEquals(1, eliminados);

        // Ya no debería estar
        assertNull(a.buscarPorNombre("Maria"));

        // Los otros siguen
        assertNotNull(a.buscarPorNombre("Ana"));
        assertNotNull(a.buscarPorNombre("Juan"));
    }
}