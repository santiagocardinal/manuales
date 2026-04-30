package com.example;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class ClasePrincipalTest {

    private static final String ARCHIVO = "test_numeros.txt";

    // 🔹 Helper: crear archivo de prueba
    private void crearArchivo(String contenido) throws IOException {
        FileWriter fw = new FileWriter(ARCHIVO);
        fw.write(contenido);
        fw.close();
    }

    @Test
    public void testCargaArchivoSinDuplicados() throws IOException {

        crearArchivo(
            "5\n" +
            "3\n" +
            "5\n" +  // duplicado
            "8\n"
        );

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        // Deben quedar 3 elementos: 5,3,8
        assertEquals(3, cp.tamano());
    }

    @Test
    public void testBuscarExistente() throws IOException {

        crearArchivo(
            "1\n2\n3\n"
        );

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        assertTrue(cp.buscarPorNumero(2));
    }

    @Test
    public void testBuscarNoExistente() throws IOException {

        crearArchivo(
            "10\n20\n30\n"
        );

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        assertFalse(cp.buscarPorNumero(99));
    }

    @Test
    public void testColaNoSeRompeAlMostrar() throws IOException {

        crearArchivo(
            "1\n2\n3\n"
        );

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        int antes = cp.tamano();

        cp.mostrarColaCircular(); // no debería destruirla

        int despues = cp.tamano();

        assertEquals(antes, despues);
    }

    @Test
    public void testArchivoVacio() throws IOException {

        crearArchivo("");

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        assertEquals(0, cp.tamano());
    }

    @Test
    public void testLineaInvalidaSeIgnora() throws IOException {

        crearArchivo(
            "1\n" +
            "hola\n" + // inválido
            "2\n"
        );

        Clase_Principal cp = new Clase_Principal();
        cp.archivoAdquisiciones(ARCHIVO);

        assertEquals(2, cp.tamano());
    }
}