package com.example;

public class Clase_principal {

    private ColaListaEnlazada<Integer> numeros_inicial;
    private PilaListaEnlazada<Integer> numeros_primerCambio;

    public Clase_principal() {
        numeros_inicial = new ColaListaEnlazada<>();
        numeros_primerCambio = new PilaListaEnlazada<>();
    }

    // 🔹 pasar de cola → pila
    public void pasarDatosPila() {

        while (!numeros_inicial.vacia()) {
            numeros_primerCambio.mete(numeros_inicial.quitaDeCola());
        }
    }

    // 🔹 pasar de pila → cola
    public void pasarDatosCola() {

        while (!numeros_primerCambio.esVacia()) {
            numeros_inicial.poneEnCola(numeros_primerCambio.saca());
        }
    }

    // 🔹 getters útiles para test
    public ColaListaEnlazada<Integer> getCola() {
        return numeros_inicial;
    }

    public PilaListaEnlazada<Integer> getPila() {
        return numeros_primerCambio;
    }
    public void mostrarCola() {

    ColaListaEnlazada<Integer> aux = new ColaListaEnlazada<>();

    while (!numeros_inicial.vacia()) {
        int valor = numeros_inicial.quitaDeCola();
        System.out.println(valor);
        aux.poneEnCola(valor);
    }

    // restaurar
    while (!aux.vacia()) {
        numeros_inicial.poneEnCola(aux.quitaDeCola());
    }  
    }

    // 🔹 Mostrar pila SIN romperla
    public void mostrarPila() {

    PilaListaEnlazada<Integer> aux = new PilaListaEnlazada<>();

    while (!numeros_primerCambio.esVacia()) {
        int valor = numeros_primerCambio.saca();
        System.out.println(valor);
        aux.mete(valor);
    }

    // restaurar
    while (!aux.esVacia()) {
        numeros_primerCambio.mete(aux.saca());
    }
    }
}