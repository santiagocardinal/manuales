package com.example;

public class Clase_Principal {
    private ListaEnlazada<Integer>numeros;
    public Clase_Principal(){
        numeros = new ListaEnlazada<>();
    }
    public ListaEnlazada<Integer> getListaNumeros(){
        return numeros;
    }
    public void agregarNumeros(int indice,int numeross){
        numeros.agregar(indice, numeross);
    }
    public void invertirNumeros(){
        numeros.invertir();
    }
    public void mostrarListas(){
        for(int i=0;i<numeros.tamano();i++){
            System.out.println(numeros.obtener(i));
        }
    }
}
