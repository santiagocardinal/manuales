package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ColaListaEnlazadaTest {

    private ColaListaEnlazada<String> cola;

    @Before
    public void setUp() {
        cola = new ColaListaEnlazada<>();
    }

    @Test
    public void nuevaColaEstaVacia() {
        assertTrue(cola.vacia());
        assertTrue(cola.esVacio());      // heredado de TDALista
        assertEquals(0, cola.tamano());
    }

   

    @Test
    public void poneEnColaConNullRetornaFalse() {
        assertFalse(cola.poneEnCola(null));
        assertTrue(cola.vacia());
        assertEquals(0, cola.tamano());
    }

    @Test
    public void agregarUnElemento() {
        assertTrue(cola.poneEnCola("A"));

        assertFalse(cola.vacia());
        assertEquals(1, cola.tamano());
        assertEquals("A", cola.frente());
    }

    @Test
    public void quitarUnicoElemento() {
        cola.poneEnCola("X");
        assertEquals("X", cola.quitaDeCola());

        assertTrue(cola.vacia());
        assertEquals(0, cola.tamano());
    }

    @Test
    public void comportamientoFIFO() {
        cola.poneEnCola("primero");
        cola.poneEnCola("segundo");
        cola.poneEnCola("tercero");

        assertEquals(3, cola.tamano());
        assertEquals("primero", cola.frente());

        assertEquals("primero", cola.quitaDeCola());
        assertEquals(2, cola.tamano());
        assertEquals("segundo", cola.frente());

        assertEquals("segundo", cola.quitaDeCola());
        assertEquals(1, cola.tamano());
        assertEquals("tercero", cola.frente());

        assertEquals("tercero", cola.quitaDeCola());
        assertTrue(cola.vacia());
    }

    @Test
    public void mantieneTailCorrectamente() {
        // Agregar varios
        cola.poneEnCola("A");
        cola.poneEnCola("B");
        cola.poneEnCola("C");

        // Quitar el primero → tail debe seguir siendo C
        assertEquals("A", cola.quitaDeCola());

        // Agregar otro elemento → debe enlazarse después de C (O(1) con tail)
        cola.poneEnCola("D");

        // Verificar orden final: B, C, D
        assertEquals("B", cola.quitaDeCola());
        assertEquals("C", cola.quitaDeCola());
        assertEquals("D", cola.quitaDeCola());
        assertTrue(cola.vacia());
    }

    @Test
    public void anulaLimpiaLaCola() {
        cola.poneEnCola("1");
        cola.poneEnCola("2");
        cola.poneEnCola("3");

        cola.anula();

        assertTrue(cola.vacia());
        assertEquals(0, cola.tamano());
       
        // Después de anular, se pueden agregar nuevos elementos normalmente
        assertTrue(cola.poneEnCola("nuevo"));
        assertEquals("nuevo", cola.frente());
    }

    @Test
    public void operacionesAlternadas() {
        cola.poneEnCola("uno");
        cola.poneEnCola("dos");
        assertEquals("uno", cola.quitaDeCola());

        cola.poneEnCola("tres");
        assertEquals("dos", cola.quitaDeCola());

        cola.poneEnCola("cuatro");
        assertEquals("tres", cola.quitaDeCola());
        assertEquals("cuatro", cola.quitaDeCola());

        assertTrue(cola.vacia());
    }

    @Test
    public void elementosNulosNoSeAgreganPeroNoRompenLaEstructura() {
        cola.poneEnCola("A");
        assertFalse(cola.poneEnCola(null)); // no se agrega
        assertEquals(1, cola.tamano());
        assertEquals("A", cola.frente());

        // Los métodos heredados como contiene() e indiceDe() no deben fallar con null
        assertFalse(cola.contiene(null));
        assertEquals(-1, cola.indiceDe(null));
    }
}