package com.example;

public class ColaListaEnlazada<T> extends ListaEnlazada<T> implements TDACola<T> {

    private Nodo<T> cola;   // puntero al último nodo
    private int tamano;     // contador para O(1) en tamaño

    public ColaListaEnlazada() {
        super();
        this.cola = null;
        this.tamano = 0;
    }

    @Override
    public T frente() {
        if (esVacio())
            throw new java.util.NoSuchElementException();
        return cabeza.getDato();  // acceso directo, O(1)
    }

    @Override
    public boolean poneEnCola(T dato) {
        if (dato == null) return false;

        Nodo<T> nuevo = new Nodo<>(dato);

        if (esVacio()) {
            cabeza = nuevo;   // ambos apuntan al mismo nodo
            cola = nuevo;
        } else {
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        tamano++;
        return true;
    }

    @Override
    public T quitaDeCola() {
        if (esVacio())
            throw new java.util.NoSuchElementException();

        T dato = cabeza.getDato();
        cabeza = cabeza.getSiguiente();  // avanzamos la cabeza

        tamano--;

        if (tamano == 0) {
            cola = null;   // la cola queda vacía
        }
        return dato;
    }

    @Override
    public boolean vacia() {
        return esVacio();
    }

    @Override
    public void anula() {
        super.vaciar();   // pone cabeza = null (heredado)
        cola = null;
        tamano = 0;
    }

    @Override
    public int tamano() {
        return this.tamano;
    }

    // ─── Sobrescritura de métodos de lista para mantener la integridad de la cola ───
    @Override
    public boolean agregar(T elem) {
        return poneEnCola(elem);
    }

    @Override
    public void agregar(int index, T elem) {
        throw new UnsupportedOperationException("Una cola no permite inserción por índice");
    }

    @Override
    public T quitar(int indice) {
        throw new UnsupportedOperationException("Una cola no permite eliminación por índice");
    }

    @Override
    public boolean eliminar(int indice) {
        throw new UnsupportedOperationException("Una cola no permite eliminación por índice");
    }

    // Opcional: también puedes bloquear quitar(T) y eliminar(T) si quieres
    @Override
    public T quitar(T elemento) {
        throw new UnsupportedOperationException("Una cola no permite eliminar elementos arbitrarios");
    }

    @Override
    public boolean eliminar(T elemento) {
        throw new UnsupportedOperationException("Una cola no permite eliminar elementos arbitrarios");
    }
}