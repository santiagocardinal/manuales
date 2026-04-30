package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

public class NodoDobleTest {

    private NodoDoble<Integer> nodo;

    @Before
    public void setUp() {
        nodo = new NodoDoble<>(10);
    }

    // ─── Constructor ─────────────────────────────────────────────

    @Test
    public void testConstructorGuardaDato() {
        assertEquals(Integer.valueOf(10), nodo.getDato());
    }

    @Test
    public void testConstructorSiguienteEsNull() {
        assertNull(nodo.getSiguiente());
    }

    @Test
    public void testConstructorAnteriorEsNull() {
        assertNull(nodo.getAnterior());
    }

    // ─── setAnterior / getAnterior ───────────────────────────────

    @Test
    public void testSetAnteriorEncadenaNodo() {
        NodoDoble<Integer> anterior = new NodoDoble<>(5);
        nodo.setAnterior(anterior);
        assertEquals(anterior, nodo.getAnterior());
    }

    @Test
    public void testSetAnteriorConNullDesencadena() {
        NodoDoble<Integer> anterior = new NodoDoble<>(5);
        nodo.setAnterior(anterior);
        nodo.setAnterior(null);
        assertNull(nodo.getAnterior());
    }

    // ─── setSiguiente / getSiguiente (heredado) ───────────────────

    @Test
    public void testSetSiguienteEncadenaNodo() {
        NodoDoble<Integer> siguiente = new NodoDoble<>(20);
        nodo.setSiguiente(siguiente);
        assertEquals(siguiente, nodo.getSiguiente());
    }

    // ─── encadenamiento doble ────────────────────────────────────

    @Test
    public void testEncadenamientoDoble() {
        NodoDoble<Integer> nodo1 = new NodoDoble<>(1);
        NodoDoble<Integer> nodo2 = new NodoDoble<>(2);
        NodoDoble<Integer> nodo3 = new NodoDoble<>(3);

        nodo1.setSiguiente(nodo2);
        nodo2.setAnterior(nodo1);
        nodo2.setSiguiente(nodo3);
        nodo3.setAnterior(nodo2);

        assertEquals(nodo3, nodo1.getSiguiente().getSiguiente());
        assertEquals(nodo1, ((NodoDoble<Integer>) nodo3.getAnterior()).getAnterior());
    }

    // ─── genéricos ───────────────────────────────────────────────

    @Test
    public void testConTipoString() {
        NodoDoble<String> n = new NodoDoble<>("hola");
        assertEquals("hola", n.getDato());
    }
}