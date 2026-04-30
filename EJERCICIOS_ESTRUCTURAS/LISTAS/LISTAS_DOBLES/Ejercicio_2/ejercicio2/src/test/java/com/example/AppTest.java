package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class AppTest {

    // ✔ Test agregar elementos
    @Test
    public void testAgregar() {

        ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>();

        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(33);

        assertEquals(11, (int) lista.obtener(0));
        assertEquals(22, (int) lista.obtener(1));
        assertEquals(33, (int) lista.obtener(2));
    }

    // ✔ Test invertir lista normal
    @Test
    public void testInvertirLista() {

        ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>();

        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(33);
        lista.agregar(44);

        lista.invertir();

        assertEquals(44, (int) lista.obtener(0));
        assertEquals(33, (int) lista.obtener(1));
        assertEquals(22, (int) lista.obtener(2));
        assertEquals(11, (int) lista.obtener(3));
    }

    // ✔ Test invertir lista grande (tu ejemplo)
    @Test
    public void testInvertirListaGrande() {

        ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>();

        lista.agregar(11);
        lista.agregar(22);
        lista.agregar(33);
        lista.agregar(44);
        lista.agregar(55);
        lista.agregar(66);
        lista.agregar(77);
        lista.agregar(88);
        lista.agregar(99);
        lista.agregar(110);

        lista.invertir();

        assertEquals(110, (int) lista.obtener(0));
        assertEquals(99, (int) lista.obtener(1));
        assertEquals(88, (int) lista.obtener(2));
        assertEquals(77, (int) lista.obtener(3));
        assertEquals(66, (int) lista.obtener(4));
        assertEquals(55, (int) lista.obtener(5));
        assertEquals(44, (int) lista.obtener(6));
        assertEquals(33, (int) lista.obtener(7));
        assertEquals(22, (int) lista.obtener(8));
        assertEquals(11, (int) lista.obtener(9));
    }

    // ✔ Test invertir un solo elemento
    @Test
    public void testInvertirUnElemento() {

        ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>();

        lista.agregar(50);
        lista.invertir();

        assertEquals(50, (int) lista.obtener(0));
        assertEquals(1, lista.tamano());
    }

    // ✔ Test lista vacía
    @Test
    public void testListaVacia() {

        ListaEnlazadaDoble<Integer> lista = new ListaEnlazadaDoble<>();

        assertTrue(lista.esVacio());

        lista.invertir(); // no debería romper

        assertEquals(0, lista.tamano());
    }
}