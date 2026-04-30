package com.example;

public class Personas {

    private  String nombre;
    private int edad;

    public Personas(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
    }
    //=================GETTERS=======================
    public String getNombre(){
        return nombre;

    }
    public int getEdad(){
        return edad;
    }
    //========================SETTERS=======================
    public void setEdad(int nueva_edad){
        this.edad = nueva_edad;
    }
     @Override
    public String toString() {
        return String.valueOf(edad);
    }
}
