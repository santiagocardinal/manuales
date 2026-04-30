package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Comparator;

public class PilaListaEnlazadaTest 
{

    private PilaListaEnlazada<Integer> pila;

    @Before
    public void setUp() 
    {
        pila = new PilaListaEnlazada<>();
    }

    // ─── mete ────────────────────────────────────────────────────

    @Test
    public void testMeteAumentaTamano() 
    {
        pila.mete(1);
        assertEquals(1, pila.tamano());
    }

    @Test
    public void testMeteVariosElementos() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        assertEquals(3, pila.tamano());
    }

    // ─── tope ────────────────────────────────────────────────────

    @Test
    public void testTopeRetornaUltimoMetido() 
    {
        pila.mete(1);
        pila.mete(2);
        assert(pila.tope().equals(2));
    }

    @Test
    public void testTopeNoModificaTamano() 
    {
        pila.mete(1);
        pila.tope();
        assertEquals(1, pila.tamano());
    }

    @Test
    public void testTopePilaVaciaRetornaNull() 
    {
        assertNull(pila.tope());
    }

    // ─── saca ────────────────────────────────────────────────────

    @Test
    public void testSacaRetornaUltimoMetido() 
    {
        pila.mete(1);
        pila.mete(2);
        assert(pila.saca().equals(2));
    }

    @Test
    public void testSacaReduceTamano() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.saca();
        assertEquals(1, pila.tamano());
    }

    @Test
    public void testSacaOrdenLIFO() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        assert(pila.saca().equals(3));
        assert(pila.saca().equals(2));
        assert(pila.saca().equals(1));
    }

    @Test
    public void testSacaPilaVaciaRetornaNull() 
    {
        assertNull(pila.saca());
    }

    // ─── esVacia / esVacio ───────────────────────────────────────

    @Test
    public void testEsVaciaEnPilaNueva() 
    {
        assertTrue(pila.esVacia());
    }

    @Test
    public void testEsVaciaFalsoConElementos() 
    {
        pila.mete(1);
        assertFalse(pila.esVacia());
    }

    @Test
    public void testEsVacioConsistenteConEsVacia() 
    {
        pila.mete(1);
        assertEquals(pila.esVacia(), pila.esVacio());
    }

    // ─── tamano ──────────────────────────────────────────────────

    @Test
    public void testTamanoPilaVacia() 
    {
        assertEquals(0, pila.tamano());
    }

    @Test
    public void testTamanoAumentaYDisminuye() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.saca();
        assertEquals(1, pila.tamano());
    }

    // ─── vaciar ──────────────────────────────────────────────────

    @Test
    public void testVaciarDejaVacia() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.vaciar();
        assertTrue(pila.esVacia());
        assertEquals(0, pila.tamano());
    }

    // ─── sacarPrimeroInsertado ────────────────────────────────────

    @Test
    public void testSacarPrimeroInsertadoRetornaPrimero() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        assert(pila.sacarPrimeroInsertado().equals(1));
    }

    @Test
    public void testSacarPrimeroInsertadoDejaVacia() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.sacarPrimeroInsertado();
        assertTrue(pila.esVacia());
    }

    @Test
    public void testSacarPrimeroInsertadoPilaVaciaRetornaNull() 
    {
        assertNull(pila.sacarPrimeroInsertado());
    }

    @Test
    public void testSacarPrimeroInsertadoUnSoloElemento() 
    {
        pila.mete(42);
        assert(pila.sacarPrimeroInsertado().equals(42));
    }

    // ─── heredados de ListaEnlazada ───────────────────────────────

    @Test
    public void testAgregarComportaComoMete() 
    {
        pila.agregar(10);
        assert(pila.tope().equals(10));
    }

    @Test
    public void testContieneElementoPresente() 
    {
        pila.mete(5);
        assertTrue(pila.contiene(5));
    }

    @Test
    public void testContieneElementoAusente() 
    {
        pila.mete(5);
        assertFalse(pila.contiene(99));
    }

    @Test
    public void testIndiceDeTopeEsCero() 
    {
        pila.mete(1);
        pila.mete(2);
        assertEquals(0, pila.indiceDe(2));
    }

    @Test
    public void testBuscarEncuentraElemento() 
    {
        pila.mete(3);
        pila.mete(7);
        assert(pila.buscar(x -> x > 5).equals(7));
    }

    @Test
    public void testQuitarPorElemento() 
    {
        pila.mete(10);
        pila.mete(20);
        assert(pila.quitar(Integer.valueOf(20)).equals(20));
        assertFalse(pila.contiene(20));
    }

    @Test
    public void testEliminarPorElemento() 
    {
        pila.mete(5);
        assertTrue(pila.eliminar(Integer.valueOf(5)));
        assertTrue(pila.esVacia());
    }

    @Test
    public void testInvertirInvierteLaPila() 
    {
        pila.mete(1);
        pila.mete(2);
        pila.mete(3);
        pila.invertir();
        assert(pila.tope().equals(1));
    }

    @Test
    public void testOrdenarTotalAscendente() 
    {
        pila.mete(3);
        pila.mete(1);
        pila.mete(2);
        pila.ordenarTotal(Comparator.naturalOrder());
        assert(pila.tope().equals(1));
    }

    @Test
    public void testConcatenarDosListas() 
    {
        pila.mete(1);
        pila.mete(2);
        PilaListaEnlazada<Integer> otra = new PilaListaEnlazada<>();
        otra.mete(3);
        TDALista<Integer> resultado = pila.concatenar(otra);
        assertEquals(3, resultado.tamano());
    }
}