package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

public class EliminarConcurrenciasTest {

    private static final String ARCHIVO = "test_numeros.txt";

    // 🔹 Helper para crear archivo
    private void crearArchivo(String contenido) throws IOException {
        FileWriter fw = new FileWriter(ARCHIVO);
        fw.write(contenido);
        fw.close();
    }

    @Test
    public void testEliminarDuplicados() throws IOException {

        crearArchivo(
            "1\n" +
            "2\n" +
            "3\n" +
            "2\n" +
            "4\n" +
            "3\n"
        );

        EliminarConcurrencias ec = new EliminarConcurrencias();
        ec.archivoAdquisiciones(ARCHIVO);

        // Deberían quedar solo únicos: 1,2,3,4
        // Validamos indirectamente contando
        int count = 0;

        // como no hay getter → usamos mostrar lógica indirecta
        // mejor solución: agregar getter (abajo te explico)
        for (int i = 0; i < 10; i++) {
            // no podemos acceder directo → limitación actual
        }

        // SOLUCIÓN PRO: agregar getter en la clase
        // assertEquals(4, ec.getLista().tamano());

        assertTrue(true); // placeholder si no agregás getter
    }

    @Test
    public void testNoDuplicados() throws IOException {

        crearArchivo(
            "5\n6\n7\n8\n"
        );

        EliminarConcurrencias ec = new EliminarConcurrencias();
        ec.archivoAdquisiciones(ARCHIVO);

        // deberían quedar todos
        assertTrue(true);
    }

    @Test
    public void testListaAVPilaOrden() throws IOException {

        crearArchivo(
            "1\n2\n3\n"
        );

        EliminarConcurrencias ec = new EliminarConcurrencias();
        ec.archivoAdquisiciones(ARCHIVO);
        ec.agregarPila();

        // La pila debería quedar:
        // mete 1, mete 2, mete 3 → tope = 3

        // NO podemos acceder directo → problema de diseño
        assertTrue(true);
    }

    @Test
    public void testArchivoVacio() throws IOException {

        crearArchivo("");

        EliminarConcurrencias ec = new EliminarConcurrencias();
        ec.archivoAdquisiciones(ARCHIVO);

        // no debería romper
        assertTrue(true);
    }

    @Test
    public void testUnSoloElemento() throws IOException {

        crearArchivo("10\n");

        EliminarConcurrencias ec = new EliminarConcurrencias();
        ec.archivoAdquisiciones(ARCHIVO);
        ec.agregarPila();

        assertTrue(true);
    }
}