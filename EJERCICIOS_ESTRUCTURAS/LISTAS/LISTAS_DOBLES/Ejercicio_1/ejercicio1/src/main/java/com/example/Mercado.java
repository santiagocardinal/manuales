package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Mercado {
    
    private ListaEnlazadaDoble<Productos> productos;
    
    public Mercado(){
        productos = new ListaEnlazadaDoble<>();
    }

    public ListaEnlazadaDoble<Productos> getLista(){
        return productos;
    }
    public void archivoProdcutos(String archivo) {

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String cadena;

            while ((cadena = lector.readLine()) != null) {

                String[] partes = cadena.split(",");

                if (partes.length < 2) continue;

                String producto = partes[0].trim();
                Double precio = Double.parseDouble(partes[1].trim());

                Productos elemento = buscarPorProducto(producto);

                if (elemento == null) {
                    productos.agregar(new Productos(producto, precio));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
    }

    public Productos buscarPorProducto(String producto){
        return productos.buscar(a -> producto.equals(a.getProducto()));
    }

    public void eliminarPreciosElevados(double precioAdiscutir){

        if (precioAdiscutir <= 0){
            System.out.println("No se puede discutir ningún precio.");
            return;
        }

        if (productos.esVacio()){
            System.out.println("No hay productos.");
            return;
        }

        for (int i = productos.tamano() - 1; i >= 0; i--){
            if(productos.obtener(i).getPrecio() > precioAdiscutir){
                productos.eliminar(i);
            }
        }
    }

    public void mostrarProductosRestantes(){
        for(int i = 0; i < productos.tamano(); i++){
            System.out.println(
                "Producto: " + productos.obtener(i).getProducto() +
                " | Precio: " + productos.obtener(i).getPrecio()
            );
        }
    }
}