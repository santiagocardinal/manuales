package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class AppTest {

    @Test
    public void testLIFO() {
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

        pila.mete(1);
        pila.mete(2);
        pila.mete(3);

        assertEquals(Integer.valueOf(3), pila.saca());
        assertEquals(Integer.valueOf(2), pila.saca());
        assertEquals(Integer.valueOf(1), pila.saca());
    }

    @Test
    public void testInvertirPila() {
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        pila.mete(4);

        pila.invertirPila();

        // debería salir en orden original
        assertEquals(Integer.valueOf(1), pila.saca());
        assertEquals(Integer.valueOf(2), pila.saca());
        assertEquals(Integer.valueOf(3), pila.saca());
        assertEquals(Integer.valueOf(4), pila.saca());
    }

    @Test
    public void testInvertirPilaVacia() {
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

        pila.invertirPila();

        assertTrue(pila.esVacia());
    }

    @Test
    public void testMainBehavior() {
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        pila.mete(4);

        // vaciás la pila (como en tu main)
        while(!pila.esVacia()){
            pila.saca();
        }

        // ahora está vacía
        assertTrue(pila.esVacia());

        // invertís (no debería romper nada)
        pila.invertirPila();

        // sigue vacía
        assertTrue(pila.esVacia());
    }

    @Test
    public void testTope() {
        PilaListaEnlazada<Integer> pila = new PilaListaEnlazada<>();

        pila.mete(10);
        pila.mete(20);

        assertEquals(Integer.valueOf(20), pila.tope());
        assertEquals(Integer.valueOf(20), pila.saca());
    }
}