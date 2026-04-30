package com.example;

import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;


public class LeerArchivosTest {

    // 🔹 helper para crear archivos
    private String crearArchivo(String nombre, String contenido) throws IOException {
        FileWriter fw = new FileWriter(nombre);
        fw.write(contenido);
        fw.close();
        return nombre;
    }

   
    @Test
    public void TestEliminarDuplicadosSolo() {

        LeerArchivos la = new LeerArchivos();

        ListaEnlazada<Numeros> lista = new ListaEnlazada<>();
        lista.agregar(new Numeros(1));
        lista.agregar(new Numeros(2));
        lista.agregar(new Numeros(2));
        lista.agregar(new Numeros(3));

        TDALista<Numeros> resultado = la.eliminarDuplicados(lista);

        assertEquals(3, resultado.tamano());

        assertEquals(1, resultado.obtener(0).getNum());
        assertEquals(2, resultado.obtener(1).getNum());
        assertEquals(3, resultado.obtener(2).getNum());
    }

   
}