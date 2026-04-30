package com.example;

import static org.junit.Assert.*;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class ClasePrincipalTest {

    private static final String ARCHIVO = "numerosTest.txt";

    // 🔹 Método auxiliar
    private void crearArchivo() throws IOException {
        FileWriter fw = new FileWriter(ARCHIVO);
        fw.write("5\n");
        fw.write("2\n");
        fw.write("8\n");
        fw.write("1\n");
        fw.write("3\n");
        fw.write("5\n"); // duplicado
        fw.close();
    }

    // ✔ Test inserción ordenada manual
    @Test
    public void testAgregarOrdenado() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(10);
        c.agregarOrdenado(5);
        c.agregarOrdenado(20);
        c.agregarOrdenado(15);

        assertEquals(Integer.valueOf(5), c.getNumeros().obtener(0));
        assertEquals(Integer.valueOf(10), c.getNumeros().obtener(1));
        assertEquals(Integer.valueOf(15), c.getNumeros().obtener(2));
        assertEquals(Integer.valueOf(20), c.getNumeros().obtener(3));
    }

    // ✔ Test evita duplicados
    @Test
    public void testNoDuplicados() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(5);
        c.agregarOrdenado(5);
        c.agregarOrdenado(5);

        assertEquals(1,c.getNumeros().tamano()); // con tu código actual permite duplicados
    }

    // ✔ Test contiene
    @Test
    public void testContiene() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(10);
        c.agregarOrdenado(20);

        assertTrue(c.contiene(10));
        assertFalse(c.contiene(5));
    }

    // ✔ Test archivo + orden + sin duplicados
    @Test
    public void testArchivoNumeros() throws IOException {

        crearArchivo();

        ClasePrincipal c = new ClasePrincipal();
        c.archivoNumeros(ARCHIVO);

        assertEquals(Integer.valueOf(1), c.getNumeros().obtener(0));
        assertEquals(Integer.valueOf(1), c.getNumeros().obtener(0));
        assertEquals(Integer.valueOf(2), c.getNumeros().obtener(1));
        assertEquals(Integer.valueOf(3), c.getNumeros().obtener(2));
        assertEquals(Integer.valueOf(5), c.getNumeros().obtener(3));
        assertEquals(Integer.valueOf(8), c.getNumeros().obtener(4));

        // sin duplicados → deberían ser 5 elementos
        assertEquals(5, c.getNumeros().tamano());
    }

    // ✔ Test lista vacía
    @Test
    public void testListaVacia() {

        ClasePrincipal c = new ClasePrincipal();

        assertFalse(c.contiene(10));
        assertEquals(0, c.getNumeros().tamano());
    }

    // ✔ Test inserción en inicio
    @Test
    public void testInsertarInicio() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(10);
        c.agregarOrdenado(20);
        c.agregarOrdenado(5);

        assertEquals(Integer.valueOf(5), c.getNumeros().obtener(0));
    }

    // ✔ Test inserción en medio
    @Test
    public void testInsertarMedio() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(10);
        c.agregarOrdenado(30);
        c.agregarOrdenado(20);

        assertEquals(Integer.valueOf(20), c.getNumeros().obtener(1));
    }

    // ✔ Test inserción al final
    @Test
    public void testInsertarFinal() {

        ClasePrincipal c = new ClasePrincipal();

        c.agregarOrdenado(10);
        c.agregarOrdenado(20);
        c.agregarOrdenado(30);

        assertEquals(Integer.valueOf(30), c.getNumeros().obtener(2));
    }
}