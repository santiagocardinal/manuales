package com.example;

import java.util.NoSuchElementException;

public class ColaCircularListaEnlazada<T> extends ListaEnlazada<T> implements TDACola<T>  {

    private Nodo<T> cola; // apunta al ÚLTIMO nodo; cola.getSiguiente() = frente
    private int tamano;

    public ColaCircularListaEnlazada() {
        this.cola = null;
        this.tamano = 0;
    }

    @Override
    public T frente() {
        if (vacia())
            throw new NoSuchElementException();

        return cola.getSiguiente().getDato(); // cola.siguiente = frente
    }

    @Override
    public boolean poneEnCola(T dato) {
        if (dato == null) return false;

        Nodo<T> nuevo = new Nodo<>(dato);

        if (vacia()) {
            nuevo.setSiguiente(nuevo); // apunta a sí mismo: círculo de 1 nodo
        } else {
            nuevo.setSiguiente(cola.getSiguiente()); // nuevo → frente
            cola.setSiguiente(nuevo);                // viejo cola → nuevo
        }

        cola = nuevo;
        tamano++;
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (vacia())
            throw new NoSuchElementException();

        Nodo<T> frente = cola.getSiguiente();

        if (frente == cola) {
            cola = null; // era el único nodo
        } else {
            cola.setSiguiente(frente.getSiguiente()); // saltea el frente
        }

        frente.setSiguiente(null); // ayuda al GC
        tamano--;
        return frente.getDato();
    }

    @Override
    public boolean vacia() {
        return cola == null;
    }

    @Override
    public void anula() {
        cola = null;
        tamano = 0;
    }

    public int tamano() {
        return tamano;
    }
}