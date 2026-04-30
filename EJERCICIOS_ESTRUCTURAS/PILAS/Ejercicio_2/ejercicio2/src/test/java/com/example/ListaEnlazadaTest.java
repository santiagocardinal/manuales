package com.example;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Comparator;

public class ListaEnlazadaTest 
{

    private ListaEnlazada<Integer> lista;

    @Before
    public void setUp() 
    {
        lista = new ListaEnlazada<>();
    }

    // ─── agregar(T) ───────────────────────────────────────────────

    @Test
    public void testAgregarAlFinalRetornaTrue() 
    {
        assertTrue(lista.agregar(10));
    }

    @Test
    public void testAgregarVariosElementosEnOrden() 
    {
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        assert(lista.obtener(0).equals(1));
        assert(lista.obtener(1).equals(2));
        assert(lista.obtener(2).equals(3));
    }

    // ─── agregar(int, T) ─────────────────────────────────────────

    @Test
    public void testAgregarEnPosicionCero() 
    {
        lista.agregar(2);
        lista.agregar(0, 1);
        assert(lista.obtener(0).equals(1));
        assert(lista.obtener(1).equals(2));
    }

    @Test
    public void testAgregarEnPosicionIntermedia() 
    {
        lista.agregar(1);
        lista.agregar(3);
        lista.agregar(1, 2);
        assert(lista.obtener(0).equals(1));
        assert(lista.obtener(1).equals(2));
        assert(lista.obtener(2).equals(3));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAgregarConIndiceNegativoLanzaExcepcion() 
    {
        lista.agregar(-1, 5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testAgregarConIndiceFueraDeRangoLanzaExcepcion() 
    {
        lista.agregar(1);
        lista.agregar(5, 99);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAgregarConNullLanzaExcepcion() 
    {
        lista.agregar(0, null);
    }

    // ─── obtener ─────────────────────────────────────────────────

    @Test
    public void testObtenerElementoExistente() 
    {
        lista.agregar(42);
        assert(lista.obtener(0).equals(42));
    }

    @Test
    public void testObtenerConIndiceNegativoRetornaNull() 
    {
        lista.agregar(1);
        assertNull(lista.obtener(-1));
    }

    @Test
    public void testObtenerConIndiceFueraDeRangoRetornaNull() 
    {
        lista.agregar(1);
        assertNull(lista.obtener(10));
    }

    // ─── tamano / esVacio / vaciar ────────────────────────────────

    @Test
    public void testTamanoListaVacia() 
    {
        assertEquals(0, lista.tamano());
    }

    @Test
    public void testTamanoAumentaAlAgregar() 
    {
        lista.agregar(1);
        lista.agregar(2);
        assertEquals(2, lista.tamano());
    }

    @Test
    public void testEsVacioEnListaNueva() 
    {
        assertTrue(lista.esVacio());
    }

    @Test
    public void testEsVacioFalsoConElementos() 
    {
        lista.agregar(1);
        assertFalse(lista.esVacio());
    }

    @Test
    public void testVaciarDejaListaVacia() 
    {
        lista.agregar(1);
        lista.agregar(2);
        lista.vaciar();
        assertTrue(lista.esVacio());
        assertEquals(0, lista.tamano());
    }

    // ─── contiene / indiceDe ─────────────────────────────────────

    @Test
    public void testContieneElementoPresente() 
    {
        lista.agregar(5);
        assertTrue(lista.contiene(5));
    }

    @Test
    public void testContieneElementoAusente() 
    {
        lista.agregar(5);
        assertFalse(lista.contiene(99));
    }

    @Test
    public void testIndiceDeElementoPresente() 
    {
        lista.agregar(10);
        lista.agregar(20);
        assertEquals(1, lista.indiceDe(20));
    }

    @Test
    public void testIndiceDeElementoAusenteRetornaMenosUno() 
    {
        lista.agregar(10);
        assertEquals(-1, lista.indiceDe(99));
    }

    @Test
    public void testIndiceDeNullRetornaMenosUno() 
    {
        assertEquals(-1, lista.indiceDe(null));
    }

    // ─── buscar ───────────────────────────────────────────────────

    @Test
    public void testBuscarEncuentraElemento() 
    {
        lista.agregar(3);
        lista.agregar(7);
        assert(lista.buscar(x -> x > 5).equals(7));
    }

    @Test
    public void testBuscarSinCoincidenciaRetornaNull() 
    {
        lista.agregar(1);
        lista.agregar(2);
        assertNull(lista.buscar(x -> x > 10));
    }

    @Test
    public void testBuscarConCriterioNullRetornaNull() 
    {
        lista.agregar(1);
        assertNull(lista.buscar(null));
    }

    // ─── quitar(T) / eliminar(T) ──────────────────────────────────

    @Test
    public void testQuitarPorElementoRetornaDato() 
    {
        lista.agregar(10);
        lista.agregar(20);
        assert(lista.quitar(Integer.valueOf(10)).equals(10));
        assertFalse(lista.contiene(10));
    }

    @Test
    public void testQuitarPorElementoAusenteRetornaNull() 
    {
        lista.agregar(1);
        assertNull(lista.quitar(Integer.valueOf(99)));
    }

    @Test
    public void testEliminarPorElementoExistenteRetornaTrue() 
    {
        lista.agregar(5);
        assertTrue(lista.eliminar(Integer.valueOf(5)));
        assertFalse(lista.contiene(5));
    }

    @Test
    public void testEliminarPorElementoAusenteRetornaFalse() 
    {
        assertFalse(lista.eliminar(Integer.valueOf(99)));
    }

    // ─── quitar(int) / eliminar(int) ──────────────────────────────

    @Test
    public void testQuitarPorIndiceRetornaDato() 
    {
        lista.agregar(10);
        lista.agregar(20);
        assert(lista.quitar(0).equals(10));
        assert(lista.obtener(0).equals(20));
    }

    @Test
    public void testQuitarPorIndiceFueraDeRangoRetornaNull() 
    {
        lista.agregar(1);
        assertNull(lista.quitar(5));
    }

    @Test
    public void testEliminarPorIndiceExistenteRetornaTrue() 
    {
        lista.agregar(1);
        lista.agregar(2);
        assertTrue(lista.eliminar(0));
        assert(lista.obtener(0).equals(2));
    }

    @Test
    public void testEliminarPorIndiceFueraDeRangoRetornaFalse() 
    {
        assertFalse(lista.eliminar(10));
    }

    // ─── invertir ────────────────────────────────────────────────

    @Test
    public void testInvertirListaConElementos() 
    {
        lista.agregar(1);
        lista.agregar(2);
        lista.agregar(3);
        lista.invertir();
        assert(lista.obtener(0).equals(3));
        assert(lista.obtener(1).equals(2));
        assert(lista.obtener(2).equals(1));
    }

    @Test
    public void testInvertirListaVaciaNoFalla() 
    {
        lista.invertir();
        assertTrue(lista.esVacio());
    }

    // ─── ordenarTotal ────────────────────────────────────────────

    @Test
    public void testOrdenarTotalAscendente() 
    {
        lista.agregar(3);
        lista.agregar(1);
        lista.agregar(2);
        lista.ordenarTotal(Comparator.naturalOrder());
        assert(lista.obtener(0).equals(1));
        assert(lista.obtener(1).equals(2));
        assert(lista.obtener(2).equals(3));
    }

    @Test
    public void testOrdenarTotalModificaListaOriginal() 
    {
        lista.agregar(5);
        lista.agregar(2);
        TDALista<Integer> resultado = lista.ordenarTotal(Comparator.naturalOrder());
        assertSame(lista, resultado);
    }

    // ─── ordenarParcial ──────────────────────────────────────────

    @Test
    public void testOrdenarParcialRetornaListaNueva() 
    {
        lista.agregar(3);
        lista.agregar(1);
        lista.agregar(2);
        TDALista<Integer> resultado = lista.ordenarParcial(Comparator.naturalOrder());
        assertNotSame(lista, resultado);
        assert(resultado.obtener(0).equals(1));
        assert(resultado.obtener(1).equals(2));
        assert(resultado.obtener(2).equals(3));
    }

    @Test
    public void testOrdenarParcialNoModificaOriginal() 
    {
        lista.agregar(3);
        lista.agregar(1);
        lista.ordenarParcial(Comparator.naturalOrder());
        assert(lista.obtener(0).equals(3));
    }

    // ─── concatenar ──────────────────────────────────────────────

    @Test
    public void testConcatenarDosListas() 
    {
        lista.agregar(1);
        lista.agregar(2);
        ListaEnlazada<Integer> otra = new ListaEnlazada<>();
        otra.agregar(3);
        otra.agregar(4);
        TDALista<Integer> resultado = lista.concatenar(otra);
        assertEquals(4, resultado.tamano());
        assert(resultado.obtener(2).equals(3));
    }

    @Test
    public void testConcatenarConListaVacia() 
    {
        lista.agregar(1);
        TDALista<Integer> resultado = lista.concatenar(new ListaEnlazada<>());
        assertEquals(1, resultado.tamano());
    }

    // ─── intercalar ──────────────────────────────────────────────

    @Test
    public void testIntercalarListasIguales() 
    {
        lista.agregar(1);
        lista.agregar(3);
        ListaEnlazada<Integer> otra = new ListaEnlazada<>();
        otra.agregar(2);
        otra.agregar(4);
        TDALista<Integer> resultado = lista.intercalar(otra);
        assert(resultado.obtener(0).equals(1));
        assert(resultado.obtener(1).equals(2));
        assert(resultado.obtener(2).equals(3));
        assert(resultado.obtener(3).equals(4));
    }

    @Test
    public void testIntercalarConListaMasLarga() 
    {
        lista.agregar(1);
        ListaEnlazada<Integer> otra = new ListaEnlazada<>();
        otra.agregar(2);
        otra.agregar(3);
        TDALista<Integer> resultado = lista.intercalar(otra);
        assertEquals(3, resultado.tamano());
        assert(resultado.obtener(2).equals(3));
    }
}