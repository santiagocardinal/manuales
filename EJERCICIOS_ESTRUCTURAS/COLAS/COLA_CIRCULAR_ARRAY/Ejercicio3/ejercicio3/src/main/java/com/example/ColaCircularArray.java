package com.example;

import java.util.NoSuchElementException;

public class ColaCircularArray<T> extends ListaEnlazada<T> implements TDACola<T>  {

    private T[] elementos;
    private int frente;
    private int fin;
    private int tamano;
    private int capacidad;

    @SuppressWarnings("unchecked") //para uprimir los warnings por array genérico
    public ColaCircularArray(int capacidad) {
        if (capacidad <= 0) 
            throw new IllegalArgumentException("Capacidad inválida");

        this.capacidad = capacidad;
        this.elementos = (T[]) new Object[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamano = 0;
    }

    @Override
    public T frente() 
    {
        if (tamano == 0) 
            throw new NoSuchElementException();

        return elementos[frente];
    }

    @Override
    public boolean poneEnCola(T dato) 
    {
        if (dato == null) return false;

        if (estaLlena()) 
            return false; // cola llena o cambiar tamaño

        fin = (fin + 1) % capacidad;
        elementos[fin] = dato;
        tamano++;

        return true;
    }

    @Override
    public T quitaDeCola() 
    {
        if (tamano == 0) 
            throw new NoSuchElementException();

        T dato = elementos[frente];
        frente = (frente + 1) % capacidad;
        tamano--;

        return dato;
    }

    @Override
    public boolean vacia() 
    {
        return tamano == 0;
    }

    @Override
    public void anula() {
        // limpia referencias para el GC
        for (int i = 0; i < capacidad; i++) {
            elementos[i] = null;
        }
        frente = 0;
        fin = -1;
        tamano = 0;
    }

    public boolean estaLlena() {
        return tamano == capacidad;
    }

    @SuppressWarnings({ "unchecked", "unused" })
    private void cambioTamano() {
        int nuevaCapacidad = capacidad * 2;
        T[] tempArr = (T[]) new Object[nuevaCapacidad];

        // copia los elementos en orden, partiendo desde frente
        for (int i = 0; i < tamano; i++) {
            tempArr[i] = elementos[(frente + i) % capacidad];
        }

        frente = 0;
        fin = tamano - 1;      // fin apunta al último elemento real
        capacidad = nuevaCapacidad; // actualiza capacidad para que sea consistente
        elementos = tempArr;
    }
    @Override
    public int tamano() 
    {
        return tamano;
    }
}