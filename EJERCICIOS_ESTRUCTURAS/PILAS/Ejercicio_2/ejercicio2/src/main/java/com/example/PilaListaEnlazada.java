package com.example;

public class PilaListaEnlazada<T> extends ListaEnlazada<T> implements TDAPila<T> {

    @Override
    public void mete(T dato) {
        agregar(0, dato); // push → al inicio
    }

    @Override
    public T saca() {
        return quitar(0); // pop → saca el primero
    }

    @Override
    public T tope() {
        return obtener(0); // peek → ver el primero
    }

    @Override
    public boolean esVacia() {
        return super.esVacio();
    }

    @Override
    public int tamano() {
        return super.tamano();
    }

    @Override
    public void vaciar() {
        super.vaciar();
    }

    public T sacarPrimeroInsertado() {
        if (esVacia()) return null;

        T ultimo = null;

        while (!esVacia()) {
            ultimo = saca(); // va guardando el último que saca
        }

        return ultimo; // este era el primero que se metió
    }

    // ======================================================================
    public void ordenarPila() {
        PilaListaEnlazada<T> aux = new PilaListaEnlazada<>();

        while (!this.esVacia()) {
            T temp = this.saca();

            while (!aux.esVacia() &&
                    ((Comparable<T>) aux.tope()).compareTo(temp) > 0) {
                this.mete(aux.saca());
            }

            aux.mete(temp);
        }

        while (!aux.esVacia()) {
            this.mete(aux.saca());
        }
    }

    public void invertirPila() {
        if (this.esVacia()) {
            return;
        }
        T temp = this.saca();        // 1. saco el tope
        invertirPila();              // 2. invierto el resto
        insertarEnFondo(temp);       // 3. lo pongo abajo
    }

    private void insertarEnFondo(T dato) {
        if (this.esVacia()) {
            this.mete(dato);
            return;
        }
        T temp = this.saca();        // saco
        insertarEnFondo(dato);       // sigo bajando
        this.mete(temp);             // reconstruyo
    }
}