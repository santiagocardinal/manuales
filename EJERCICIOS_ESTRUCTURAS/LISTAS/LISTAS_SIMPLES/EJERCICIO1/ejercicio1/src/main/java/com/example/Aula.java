package com.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Aula {

    private ListaEnlazada<Alumno> alumnos;
    private ListaEnlazada<Alumno>promedioBajo;

    public Aula(){

        alumnos = new ListaEnlazada<>();
        promedioBajo = new ListaEnlazada<>();
    }

    public void archivoAlumnos(String archivo){

        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {

            String cadena;

            while ((cadena = lector.readLine()) != null) {

                String[] partes = cadena.split(",");

                if (partes.length < 3) {
                    continue;
                }

                String nombre = partes[0].trim();

                int edad;
                double calificacion;

                try {
                    edad = Integer.parseInt(partes[1].trim());
                    calificacion = Double.parseDouble(partes[2].trim());
                
                } catch (NumberFormatException e) {
                    continue;
                }

                    Alumno alumnoExistente = buscarPorNombre(nombre);

                if (alumnoExistente == null) {
                    alumnos.agregar(alumnos.tamano(), (new Alumno(nombre, edad, calificacion)));;
                    alumnos.ordenarTotal((a,b)->a.getNombre().compareTo(b.getNombre()));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public Alumno buscarPorNombre(String nombre) {

        int i = 0;

        while (i < alumnos.tamano()) {

            Alumno a = alumnos.obtener(i);

            if (a.getNombre().equals(nombre)) {
                return a;
            }

            i++;
        }

        return null;
    }

    public void mostrarAula(){

        if(alumnos.esVacio()){
            System.out.println("No se agregó ningún alumno al aula.");
        }
        else{

            System.out.println("ALUMNOS");
            for(int i = 0; i < alumnos.tamano(); i++){

                Alumno a = alumnos.obtener(i);

                System.out.println("ALUMNO: " + a.getNombre());
                System.out.println("EDAD: " + a.getEdad());
                System.out.println("CALIFICACION: " + a.getCalificacion());
                System.out.println("-------------------");
            }
            System.out.println("Total Alumnos: " +alumnos.tamano());

        }
    }

    public int eliminarPromedioBajo(){
        return  alumnos.eliminarSi(a -> a.getCalificacion() < 6);
    }
}