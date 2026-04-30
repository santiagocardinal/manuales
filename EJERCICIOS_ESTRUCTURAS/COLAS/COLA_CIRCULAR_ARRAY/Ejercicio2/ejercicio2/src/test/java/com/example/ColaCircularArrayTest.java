package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.NoSuchElementException;

public class ColaCircularArrayTest 
{

    private ColaCircularArray<Integer> cola;

    @Before
    public void setUp() 
    {
        cola = new ColaCircularArray<>(5);
    }

    // ─── constructor ─────────────────────────────────────────────

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorCapacidadInvalidaLanzaExcepcion() 
    {
        new ColaCircularArray<>(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorCapacidadNegativaLanzaExcepcion() 
    {
        new ColaCircularArray<>(-1);
    }

    // ─── poneEnCola ───────────────────────────────────────────────

    @Test
    public void testPoneEnColaRetornaTrue() 
    {
        assertTrue(cola.poneEnCola(1));
    }

    @Test
    public void testPoneEnColaAumentaTamano() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        assertEquals(2, cola.tamano());
    }

    @Test
    public void testPoneEnColaConNullRetornaFalse() 
    {
        assertFalse(cola.poneEnCola(null));
    }

    @Test
    public void testPoneEnColaConNullNoAumentaTamano() 
    {
        cola.poneEnCola(null);
        assertEquals(0, cola.tamano());
    }

    @Test
    public void testPoneEnColaLlenaRetornaFalse() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        cola.poneEnCola(4);
        cola.poneEnCola(5);
        assertFalse(cola.poneEnCola(6));
    }

    // ─── frente ───────────────────────────────────────────────────

    @Test
    public void testFrenteRetornaPrimeroInsertado() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        assert(cola.frente().equals(1));
    }

    @Test
    public void testFrenteNoModificaTamano() 
    {
        cola.poneEnCola(1);
        cola.frente();
        assertEquals(1, cola.tamano());
    }

    @Test(expected = NoSuchElementException.class)
    public void testFrenteColaVaciaLanzaExcepcion() 
    {
        cola.frente();
    }

    // ─── quitaDeCola ─────────────────────────────────────────────

    @Test
    public void testQuitaDeColaRetornaPrimero() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        assert(cola.quitaDeCola().equals(1));
    }

    @Test
    public void testQuitaDeColaReduceTamano() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.quitaDeCola();
        assertEquals(1, cola.tamano());
    }

    @Test
    public void testQuitaDeColaOrdenFIFO() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        assert(cola.quitaDeCola().equals(1));
        assert(cola.quitaDeCola().equals(2));
        assert(cola.quitaDeCola().equals(3));
    }

    @Test
    public void testQuitaDeColaUnicoElementoDejaVacia() 
    {
        cola.poneEnCola(1);
        cola.quitaDeCola();
        assertTrue(cola.vacia());
    }

    @Test(expected = NoSuchElementException.class)
    public void testQuitaDeColaVaciaLanzaExcepcion() 
    {
        cola.quitaDeCola();
    }

    // ─── vacia ───────────────────────────────────────────────────

    @Test
    public void testVaciaEnColaNueva() 
    {
        assertTrue(cola.vacia());
    }

    @Test
    public void testVaciaFalsoConElementos() 
    {
        cola.poneEnCola(1);
        assertFalse(cola.vacia());
    }

    @Test
    public void testVaciaTrasSacarTodos() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.quitaDeCola();
        cola.quitaDeCola();
        assertTrue(cola.vacia());
    }

    // ─── estaLlena ───────────────────────────────────────────────

    @Test
    public void testEstaLlenaFalsoColaVacia() 
    {
        assertFalse(cola.estaLlena());
    }

    @Test
    public void testEstaLlenaVerdaderoColaLlena() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        cola.poneEnCola(4);
        cola.poneEnCola(5);
        assertTrue(cola.estaLlena());
    }

    @Test
    public void testEstaLlenaFalsoTrasQuitarUno() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        cola.poneEnCola(4);
        cola.poneEnCola(5);
        cola.quitaDeCola();
        assertFalse(cola.estaLlena());
    }

    // ─── tamano ──────────────────────────────────────────────────

    @Test
    public void testTamanoColaVacia() 
    {
        assertEquals(0, cola.tamano());
    }

    @Test
    public void testTamanoAumentaYDisminuye() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.quitaDeCola();
        assertEquals(1, cola.tamano());
    }

    // ─── anula ───────────────────────────────────────────────────

    @Test
    public void testAnulaDejaVacia() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.anula();
        assertTrue(cola.vacia());
    }

    @Test
    public void testAnulaResetaTamano() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.anula();
        assertEquals(0, cola.tamano());
    }

    @Test
    public void testAnulaPermiteVolverAUsar() 
    {
        cola.poneEnCola(1);
        cola.anula();
        cola.poneEnCola(2);
        assert(cola.frente().equals(2));
    }

    // ─── circularidad ────────────────────────────────────────────

    @Test
    public void testCircularidadPoneYQuitaVarios() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.quitaDeCola();
        cola.poneEnCola(3);
        assert(cola.frente().equals(2));
        assert(cola.quitaDeCola().equals(2));
        assert(cola.quitaDeCola().equals(3));
        assertTrue(cola.vacia());
    }

    @Test
    public void testCircularidadReutilizaEspacioLiberado() 
    {
        cola.poneEnCola(1);
        cola.poneEnCola(2);
        cola.poneEnCola(3);
        cola.poneEnCola(4);
        cola.poneEnCola(5);
        cola.quitaDeCola();
        cola.quitaDeCola();
        assertTrue(cola.poneEnCola(6));
        assertTrue(cola.poneEnCola(7));
        assert(cola.frente().equals(3));
    }

    @Test
    public void testFrenteSeMantieneTrasVariasInserciones() 
    {
        cola.poneEnCola(10);
        cola.poneEnCola(20);
        cola.poneEnCola(30);
        assert(cola.frente().equals(10));
    }
}