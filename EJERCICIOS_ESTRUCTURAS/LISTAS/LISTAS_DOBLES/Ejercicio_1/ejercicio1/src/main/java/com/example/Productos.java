package com.example;

public class Productos {
    private String producto;
    private double precio;

    public Productos(String producto, double precio){
        this.producto = producto;
        this.precio = precio;
    }
    
    //==============GETTERS===========================
    public String getProducto(){
        return producto;
    }
    public double getPrecio(){
        return precio;
    }
    //================SETTERS============================
    public void setPrecio(double nuevo_precio){
        this.precio = nuevo_precio;
    }
}
