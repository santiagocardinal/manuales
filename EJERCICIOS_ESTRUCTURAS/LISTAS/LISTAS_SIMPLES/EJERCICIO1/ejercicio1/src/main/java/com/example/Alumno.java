package com.example;

public class Alumno {
    private String nombre;
    private int edad;
    private double calificacion;

    public Alumno(String nombre, int edad, double calificacion){
        this.nombre = nombre;
        this.edad = edad;
        this.calificacion = calificacion;
    }

    //===============GETTERS===========================
    public String getNombre(){
        return nombre;
    }
    public int getEdad(){
        return edad;
    }
    public double getCalificacion(){
        return calificacion;
    }
    //================SETTERS==============================
    public void setEdad(int nueva_edad){
        this.edad = nueva_edad;
    }
    public void setCalificacion(double nueva_calificacion){
        this.calificacion = nueva_calificacion;
    }
    
}
