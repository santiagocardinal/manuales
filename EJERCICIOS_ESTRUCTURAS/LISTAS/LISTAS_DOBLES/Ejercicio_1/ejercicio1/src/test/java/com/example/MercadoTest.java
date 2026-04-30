package com.example;

import static org.junit.Assert.*;

import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

public class MercadoTest {

    private static final String ARCHIVO = "productosTest.txt";

    // 🔹 helper para crear archivo
    private void crearArchivoBase() throws IOException {
        FileWriter fw = new FileWriter(ARCHIVO);
        fw.write("Pan,50\n");
        fw.write("Leche,80\n");
        fw.write("Carne,200\n");
        fw.write("Pan,50\n"); // duplicado
        fw.close();
    }

    // ✔ Test carga de archivo
    @Test
    public void testArchivoProductos() throws IOException {

        crearArchivoBase();

        Mercado m = new Mercado();
        m.archivoProdcutos(ARCHIVO);

        assertNotNull(m.buscarPorProducto("Pan"));
        assertNotNull(m.buscarPorProducto("Leche"));
        assertNotNull(m.buscarPorProducto("Carne"));

    }

    // ✔ Test búsqueda existente
    @Test
    public void testBuscarExistente() throws IOException {

        crearArchivoBase();

        Mercado m = new Mercado();
        m.archivoProdcutos(ARCHIVO);

        Productos p = m.buscarPorProducto("Leche");

        assertNotNull(p);
        assertEquals("Leche", p.getProducto());
    }

    // ✔ Test búsqueda inexistente
    @Test
    public void testBuscarNoExistente() throws IOException {

        crearArchivoBase();

        Mercado m = new Mercado();
        m.archivoProdcutos(ARCHIVO);

        assertNull(m.buscarPorProducto("Queso"));
    }

    // ✔ Test eliminar precios elevados
    @Test
    public void testEliminarPreciosElevados() throws IOException {

        crearArchivoBase();

        Mercado m = new Mercado();
        m.archivoProdcutos(ARCHIVO);

        m.eliminarPreciosElevados(100);

        // Carne (200) debería eliminarse
        assertNull(m.buscarPorProducto("Carne"));

        // los demás siguen
        assertNotNull(m.buscarPorProducto("Pan"));
        assertNotNull(m.buscarPorProducto("Leche"));
    }

    // ✔ Test eliminar con lista vacía
    @Test
    public void testEliminarListaVacia() {

        Mercado m = new Mercado();

        m.eliminarPreciosElevados(100);

        assertNull(m.buscarPorProducto("Pan"));
    }

    // ✔ Test eliminar con precio inválido
    @Test
    public void testEliminarPrecioInvalido() throws IOException {

        crearArchivoBase();

        Mercado m = new Mercado();
        m.archivoProdcutos(ARCHIVO);

        m.eliminarPreciosElevados(0);

        // no debería eliminar nada
        assertNotNull(m.buscarPorProducto("Pan"));
        assertNotNull(m.buscarPorProducto("Carne"));
    }

    
}