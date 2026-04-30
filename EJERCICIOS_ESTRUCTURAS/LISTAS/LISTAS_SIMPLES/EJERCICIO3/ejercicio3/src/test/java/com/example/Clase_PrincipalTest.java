package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

public class Clase_PrincipalTest {

    // ✔ Test lista vacía
    @Test
    public void testListaVacia() {

        Clase_Principal c = new Clase_Principal();

        assertEquals(0, c.getListaNumeros().tamano());
    }

    // ✔ Test agregar en posiciones
    @Test
    public void testAgregarNumeros() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 10);
        c.agregarNumeros(1, 20);
        c.agregarNumeros(2, 30);

        assertEquals(10, (int)c.getListaNumeros().obtener(0));
        assertEquals(20, (int)c.getListaNumeros().obtener(1));
        assertEquals(30, (int)c.getListaNumeros().obtener(2));
    }

    // ✔ Test insertar en el medio
    @Test
    public void testInsertarEnMedio() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 10);
        c.agregarNumeros(1, 30);
        c.agregarNumeros(1, 20); // insertar en el medio

        assertEquals(10, (int)c.getListaNumeros().obtener(0));
        assertEquals(20, (int)c.getListaNumeros().obtener(1));
        assertEquals(30, (int)c.getListaNumeros().obtener(2));
    }

    // ✔ Test insertar al inicio
    @Test
    public void testInsertarInicio() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 20);
        c.agregarNumeros(0, 10);

        assertEquals(10, (int)c.getListaNumeros().obtener(0));
        assertEquals(20, (int)c.getListaNumeros().obtener(1));
    }

    // ✔ Test insertar al final
    @Test
    public void testInsertarFinal() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 10);
        c.agregarNumeros(1, 20);
        c.agregarNumeros(2, 30);

        assertEquals(30, (int)c.getListaNumeros().obtener(2));
    }

    // ✔ Test invertir lista
    @Test
    public void testInvertirNumeros() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 10);
        c.agregarNumeros(1, 20);
        c.agregarNumeros(2, 30);

        c.invertirNumeros();

        assertEquals(30, (int)c.getListaNumeros().obtener(0));
        assertEquals(20, (int)c.getListaNumeros().obtener(1));
        assertEquals(10, (int)c.getListaNumeros().obtener(2));
    }

    // ✔ Test invertir lista con un solo elemento
    @Test
    public void testInvertirUnElemento() {

        Clase_Principal c = new Clase_Principal();

        c.agregarNumeros(0, 10);
        c.invertirNumeros();

        assertEquals(10, (int)c.getListaNumeros().obtener(0));
    }

    // ✔ Test invertir lista vacía
    @Test
    public void testInvertirListaVacia() {

        Clase_Principal c = new Clase_Principal();

        c.invertirNumeros();

        assertEquals(0, c.getListaNumeros().tamano());
    }
}