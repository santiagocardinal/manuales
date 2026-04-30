package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ConjuntosTest {

    private Conjunto<Integer> conjunto;
    private Conjunto<Integer> otroConjunto;

    @Before
    public void setUp() {
        conjunto = new Conjunto<>();
        otroConjunto = new Conjunto<>();
    }

    // ──────────────── PRUEBAS DE AGREGAR (SIN DUPLICADOS) ────────────────

    @Test
    public void agregarElementosSinDuplicados() {
        assertTrue(conjunto.agregar(10));
        assertTrue(conjunto.agregar(20));
        assertTrue(conjunto.agregar(30));

        assertEquals(3, conjunto.tamano());
        assertTrue(conjunto.contiene(10));
        assertTrue(conjunto.contiene(20));
        assertTrue(conjunto.contiene(30));
    }

    @Test
    public void agregarDuplicadoRetornaFalseYNoModifica() {
        conjunto.agregar(10);
        conjunto.agregar(20);

        assertFalse(conjunto.agregar(10)); // duplicado
        assertEquals(2, conjunto.tamano());
        assertTrue(conjunto.contiene(10));
        assertTrue(conjunto.contiene(20));
    }

    @Test
    public void agregarNullRetornaFalse() {
        assertFalse(conjunto.agregar(null));
        assertEquals(0, conjunto.tamano());
    }

    @Test
    public void constructorConArrayInicial() {
        Integer[] datos = {1, 2, 3, 2, 1}; // duplicados
        Conjunto<Integer> c = new Conjunto<>(datos);

        assertEquals(3, c.tamano()); // solo 1,2,3
        assertTrue(c.contiene(1));
        assertTrue(c.contiene(2));
        assertTrue(c.contiene(3));
        assertFalse(c.contiene(4));
    }

    // ──────────────── PRUEBAS DE UNIÓN ────────────────

    @Test
    public void unionDeConjuntosSinElementosComunes() {
        conjunto.agregar(1);
        conjunto.agregar(2);

        otroConjunto.agregar(3);
        otroConjunto.agregar(4);

        TDAConjunto<Integer> resultado = conjunto.union(otroConjunto);

        assertEquals(4, resultado.tamano());
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(2));
        assertTrue(resultado.contiene(3));
        assertTrue(resultado.contiene(4));
    }

    @Test
    public void unionConElementosComunes() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(3);

        otroConjunto.agregar(2);
        otroConjunto.agregar(3);
        otroConjunto.agregar(4);

        TDAConjunto<Integer> resultado = conjunto.union(otroConjunto);

        assertEquals(4, resultado.tamano());
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(2));
        assertTrue(resultado.contiene(3));
        assertTrue(resultado.contiene(4));
    }

    @Test
    public void unionConConjuntoVacio() {
        conjunto.agregar(1);
        conjunto.agregar(2);

        TDAConjunto<Integer> resultado = conjunto.union(otroConjunto); // otro vacío

        assertEquals(2, resultado.tamano());
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(2));
    }

    @Test
    public void unionDeVacios() {
        TDAConjunto<Integer> resultado = conjunto.union(otroConjunto);
        assertEquals(0, resultado.tamano());
        assertTrue(resultado.esVacio());
    }

    // ──────────────── PRUEBAS DE INTERSECCIÓN ────────────────

    @Test
    public void interseccionConElementosComunes() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(3);

        otroConjunto.agregar(2);
        otroConjunto.agregar(3);
        otroConjunto.agregar(4);

        TDAConjunto<Integer> resultado = conjunto.interseccion(otroConjunto);

        assertEquals(2, resultado.tamano());
        assertTrue(resultado.contiene(2));
        assertTrue(resultado.contiene(3));
        assertFalse(resultado.contiene(1));
        assertFalse(resultado.contiene(4));
    }

    @Test
    public void interseccionSinElementosComunes() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        otroConjunto.agregar(3);
        otroConjunto.agregar(4);

        TDAConjunto<Integer> resultado = conjunto.interseccion(otroConjunto);

        assertEquals(0, resultado.tamano());
        assertTrue(resultado.esVacio());
    }

    @Test
    public void interseccionConVacio() {
        conjunto.agregar(1);
        conjunto.agregar(2);

        TDAConjunto<Integer> resultado = conjunto.interseccion(otroConjunto); // vacío

        assertEquals(0, resultado.tamano());
        assertTrue(resultado.esVacio());
    }

    // ──────────────── PRUEBAS DE DIFERENCIA ────────────────

    @Test
    public void diferenciaEstandar() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.agregar(3);

        otroConjunto.agregar(2);
        otroConjunto.agregar(4);

        TDAConjunto<Integer> resultado = conjunto.diferencia(otroConjunto);

        assertEquals(2, resultado.tamano());
        assertTrue(resultado.contiene(1));
        assertTrue(resultado.contiene(3));
        assertFalse(resultado.contiene(2));
        assertFalse(resultado.contiene(4));
    }

    @Test
    public void diferenciaCuandoEsteEsSubconjunto() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        otroConjunto.agregar(1);
        otroConjunto.agregar(2);
        otroConjunto.agregar(3);

        TDAConjunto<Integer> resultado = conjunto.diferencia(otroConjunto);

        assertEquals(0, resultado.tamano());
        assertTrue(resultado.esVacio());
    }

    @Test
    public void diferenciaConVacio() {
        conjunto.agregar(5);
        conjunto.agregar(6);

        TDAConjunto<Integer> resultado = conjunto.diferencia(otroConjunto); // vacío

        assertEquals(2, resultado.tamano());
        assertTrue(resultado.contiene(5));
        assertTrue(resultado.contiene(6));
    }

    // ──────────────── PRUEBAS DE SUBCONJUNTO ────────────────

    @Test
    public void esSubconjuntoVerdadero() {
        conjunto.agregar(1);
        conjunto.agregar(2);

        otroConjunto.agregar(1);
        otroConjunto.agregar(2);
        otroConjunto.agregar(3);

        assertTrue(conjunto.esSubconjuntoDe(otroConjunto));
    }

    @Test
    public void esSubconjuntoFalso() {
        conjunto.agregar(1);
        conjunto.agregar(4);

        otroConjunto.agregar(1);
        otroConjunto.agregar(2);
        otroConjunto.agregar(3);

        assertFalse(conjunto.esSubconjuntoDe(otroConjunto));
    }

    @Test
    public void conjuntoVacioEsSubconjuntoDeCualquiera() {
        // conjunto vacío
        otroConjunto.agregar(10);
        otroConjunto.agregar(20);
        assertTrue(conjunto.esSubconjuntoDe(otroConjunto));
    }

    @Test
    public void conjuntoNoEsSubconjuntoDeVacio() {
        conjunto.agregar(1);
        assertFalse(conjunto.esSubconjuntoDe(otroConjunto)); // otro vacío
    }

    // ──────────────── PRUEBAS DE TOSTRING ────────────────

    @Test
    public void toStringConjuntoVacio() {
        assertEquals("CONJUNTO VACÍO {}", conjunto.toString());
    }

    @Test
    public void toStringConElementos() {
        conjunto.agregar(10);
        conjunto.agregar(20);
        // El orden no está garantizado, pero los elementos deben aparecer
        String resultado = conjunto.toString();
        assertTrue(resultado.startsWith("{"));
        assertTrue(resultado.endsWith("}"));
        assertTrue(resultado.contains("10") && resultado.contains("20"));
    }

    // ──────────────── PRUEBAS DE MÉTODOS HEREDADOS (COMPORTAMIENTO CONJUNTO) ────────────────

    /*@Test
    public void eliminarElementoExistente() {
        conjunto.agregar(7);
        conjunto.agregar(8);
        assertTrue(conjunto.eliminar(7));
        assertEquals(1, conjunto.tamano());
        assertFalse(conjunto.contiene(7));
        assertTrue(conjunto.contiene(8));
    }*/

    @Test
    public void eliminarElementoInexistente() {
        conjunto.agregar(5);
        assertFalse(conjunto.eliminar(99));
        assertEquals(1, conjunto.tamano());
    }

    @Test
    public void vaciarConjunto() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        conjunto.vaciar();
        assertTrue(conjunto.esVacio());
        assertEquals(0, conjunto.tamano());
    }

    @Test
    public void invertirNoTieneSentidoEnConjuntoPeroFunciona() {
        // Invertir en un conjunto no viola la semántica (solo reordena)
        // pero debemos asegurar que no introduce duplicados.
        conjunto.agregar(5);
        conjunto.agregar(10);
        conjunto.invertir();
        assertEquals(2, conjunto.tamano());
        assertTrue(conjunto.contiene(5));
        assertTrue(conjunto.contiene(10));
    }

    @Test
    public void concatenarMantieneNoDuplicados() {
        conjunto.agregar(1);
        conjunto.agregar(2);
        otroConjunto.agregar(2);
        otroConjunto.agregar(3);
        TDALista<Integer> concatenada = conjunto.concatenar(otroConjunto);
        // concatenar devuelve una ListaEnlazada, no un Conjunto.
        // Puede tener duplicados porque es una lista, no conjunto.
        // Esto está bien según el contrato.
        assertEquals(4, concatenada.tamano()); // 1,2,2,3
    }
}