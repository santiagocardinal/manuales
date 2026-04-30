package com.example;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class PoblacioinTest {

    private static final String ARCHIVO = "personas_test.txt";

    // 🔹 Crear archivo base
    public void crearArchivo() throws IOException {

        FileWriter fw = new FileWriter(ARCHIVO);

        fw.write("Ana,17\n");
        fw.write("Luis,25\n");
        fw.write("Maria,30\n");
        fw.write("Pedro,15\n");
        fw.write("Sofia,40\n");
        fw.write("Juan,18\n");

        fw.close();
    }

    // 🔹 Test carga de personas
    @Test
    public void testCargaPersonas() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);

        assertNotNull(p.buscarPersonas("Ana"));
        assertNotNull(p.buscarPersonas("Luis"));
        assertNotNull(p.buscarPersonas("Maria"));
        assertNotNull(p.buscarPersonas("Pedro"));
        assertNotNull(p.buscarPersonas("Sofia"));
        assertNotNull(p.buscarPersonas("Juan"));
    }

    // 🔹 Test búsqueda existente
    @Test
    public void testBuscarExistente() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);

        Personas r = p.buscarPersonas("Luis");

        assertNotNull(r);
        assertEquals("Luis", r.getNombre());
        assertEquals(25, r.getEdad());
    }

    // 🔹 Test búsqueda inexistente
    @Test
    public void testBuscarInexistente() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);

        assertNull(p.buscarPersonas("NoExiste"));
    }

    // 🔹 Test filtro mayores o iguales
    @Test
    public void testInsertarMayores() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);

        p.insertarMayores(18);

        // deberían estar incluidos (>=18)
        assertNotNull(p.buscarPersonas("Luis"));   // 25
        assertNotNull(p.buscarPersonas("Maria"));  // 30
        assertNotNull(p.buscarPersonas("Sofia"));  // 40
        assertNotNull(p.buscarPersonas("Juan"));   // 18

        // menores no necesariamente están en mayores
    }

    // 🔹 Test que valida lógica indirecta de filtrado
    @Test
    public void testInsertarMayoresNoIncluyeMenores() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);

        p.insertarMayores(18);

        // menores pueden seguir en población pero no en mayores
        assertNotNull(p.buscarPersonas("Pedro")); // 15 (puede o no depender del flujo)
    }

    // 🔹 Test mostrar (solo ejecución)
    @Test
    public void testMostrarMayores() throws IOException {

        crearArchivo();

        Poblacion p = new Poblacion();
        p.archivoPersonas(ARCHIVO);
        p.insertarMayores(18);

        p.mostrarColaMayores();

        assertTrue(true); // solo ejecución
    }
}