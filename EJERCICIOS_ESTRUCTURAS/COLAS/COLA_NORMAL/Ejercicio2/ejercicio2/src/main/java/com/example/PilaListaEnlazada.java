package com.example;

public class PilaListaEnlazada<T> extends ListaEnlazada<T> implements TDAPila<T> {

    @Override
    public void mete(T dato) 
    {
        agregar(0, dato); // push → al inicio
    }

    @Override
    public T saca() 
    {
        return quitar(0); // pop → saca el primero
    }

    @Override
    public T tope() 
    {
        return obtener(0); // peek → ver el primero
    }

    @Override
    public boolean esVacia() 
    {
        return super.esVacio();
    }

    @Override
    public int tamano() 
    {
        return super.tamano();
    }

    @Override
    public void vaciar() 
    {
        super.vaciar();
    }

    public T sacarPrimeroInsertado() 
    {
        if (esVacia()) return null;

        T ultimo = null;

        while (!esVacia()) 
        {
            ultimo = saca(); // va guardando el último que saca
        }

        return ultimo; // este era el primero que se metió
    }
}
