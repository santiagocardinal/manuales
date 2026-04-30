package com.example;

import java.util.Comparator;
import java.util.function.Predicate;

public class ListaEnlazadaDoble<T> implements TDALista<T> {

    private NodoDoble<T> cabeza;
    private NodoDoble<T> anterior;
    private int tamano;
    
    public ListaEnlazadaDoble() {
        cabeza = null;
        anterior = null;
        tamano =0;
    }

    @Override
    public boolean agregar(T dato)  //cumple con lista doblemente enlazada
    {
        NodoDoble<T> nuevo = new NodoDoble<>(dato);

        if (cabeza == null) 
        {
            cabeza = nuevo;
            anterior = nuevo;
            tamano++;
        } 
        else 
        {
            anterior.setSiguiente(nuevo);
            nuevo.setAnterior(anterior);
            anterior = nuevo;
        }
        return true;
    }

    @Override
    public void agregar(int indice, T elemento) 
    {
        if (indice < 0 ) throw new IndexOutOfBoundsException("Índice: " + indice);//no se puede acceder al indice
        if (elemento == null) throw new IllegalArgumentException("No se permiten null");//no se puede tener un elemento nulo

        NodoDoble<T> nuevo = new NodoDoble<>(elemento);

        if (indice == 0) 
        {
            // insertar al inicio
            nuevo.setSiguiente(cabeza);

            if (cabeza != null) 
                cabeza.setAnterior(nuevo); //la cabeza es un elemento distinto de nulo, el anterior a la cabeza va a ser nuevo,  mueve uno para adelante y deja espacio para insertar
                cabeza = nuevo;
            
                if (tamano == 0) 
                anterior = nuevo; // si lista vacía, el nuevo también es el último
        }
        
        else if (indice == tamano) 
        {
            // insertar al final
            nuevo.setAnterior(anterior);
            if (anterior != null) anterior.setSiguiente(nuevo);
            anterior = nuevo;
        } 
        else 
        {
            NodoDoble<T> actual = cabeza;
            // recorrer hasta el nodo anterior a la posición deseada
            for (int i = 0; i < indice - 1; i++) 
            {
                actual = (NodoDoble<T>) actual.getSiguiente();            
            }

        NodoDoble<T> siguiente = (NodoDoble<T>) actual.getSiguiente();
        nuevo.setSiguiente(siguiente);
        nuevo.setAnterior(actual);
        actual.setSiguiente(nuevo);
        siguiente.setAnterior(nuevo);
    }
    tamano++;
    }
    

    @Override
    public T obtener(int indice) 
    {
        if (indice < 0) //0,1,2,3,4,5,,..... y=si yo le pido un elemento en la posicion -1 me salta error pero como no quiero que me salte error devuelvo null
            return null; //si el indice ingresado es nulo retornar nulo

        NodoDoble<T> nuevo = cabeza; //se crea un nuevo nodo el cual se le asigna ser la "cabeza"
        int i = 0; //control de variable

        while (nuevo != null)  //mientras que el nodo siguiente sea distinto e nulo
        {
            if (i == indice) 
                return nuevo.getDato(); //y si i(variable de control) es igual al indice pasado por parametro, devolver el dato que se encuentra en ese indice
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();//va pasando al siguiente
            i++;
        }
        return null; //si no se encuentra devuelve null
    }

    private T desconectar(NodoDoble<T> nodo) {
        NodoDoble<T> ant = nodo.getAnterior();
        NodoDoble<T> sig = (NodoDoble<T>) nodo.getSiguiente();

        if (ant != null) 
            ant.setSiguiente(sig);
        else cabeza = sig;

        if (sig != null) 
            sig.setAnterior(ant);
        else anterior = ant;

        nodo.setSiguiente(null); //desconecta totalemnte
        nodo.setAnterior(null); //desconecta totaLMENTE
        return nodo.getDato();
    }

    public T quitar(T elemento) {
        if (cabeza == null || elemento == null) return null;

        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.getDato().equals(elemento)) 
                return desconectar(actual); //MUCHISIMO MAS FACIL <)
            actual = (NodoDoble<T>) actual.getSiguiente();
        }
        return null;
    }

    public boolean eliminar(T elemento) //esto teoricamente funciona :(
    {
         return quitar(elemento) != null;
    }
        /*if (cabeza == null || elemento == null) return false;

        NodoDoble<T> nuevo = cabeza;
        NodoDoble<T> anterior = null;

        while (nuevo != null) 
        {
            if (nuevo.getDato().equals(elemento)) 
            {
                if (anterior == null) 
                {
                    cabeza = (NodoDoble<T>) nuevo.getSiguiente();
                    if (cabeza != null) cabeza.setAnterior(null);
                    else anterior = null;
                } 
                else 
                {
                    anterior.setSiguiente(nuevo.getSiguiente());
                    if (nuevo.getSiguiente() != null)
                        ((NodoDoble<T>) nuevo.getSiguiente()).setAnterior(anterior);
                    else
                        anterior = anterior;
                }

                return true;
            }

            anterior = nuevo;
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        return false;*/

    public T quitar(int indice) { //REVISION===============================================================================
        
        
        if (obtener(indice) == null) return null;

        NodoDoble<T> actual = cabeza;
        int i = 0;
        while (actual != null) {
            if (i == indice) return desconectar(actual);
            actual = (NodoDoble<T>)actual.getSiguiente(); 
            i++;
        }
        return null;
    }
        /*if (elemento == null) return null;

        if (indice == 0) 
        {
            T dato = cabeza.getDato();
            NodoDoble<T> aux = cabeza;
            cabeza = (NodoDoble<T>) cabeza.getSiguiente();
            if (cabeza != null) cabeza.setAnterior(null);
            else anterior = null;
            aux.setSiguiente(null);
            return dato;
        }

        NodoDoble<T> anterior = cabeza;
        int i = 0;

        while (anterior != null && i < indice - 1) 
        {
            anterior = (NodoDoble<T>) anterior.getSiguiente();
            i++;
        }

        NodoDoble<T> nodoAEliminar = (NodoDoble<T>) anterior.getSiguiente();
        anterior.setSiguiente(nodoAEliminar.getSiguiente());

        if (nodoAEliminar.getSiguiente() != null)
            ((NodoDoble<T>) nodoAEliminar.getSiguiente()).setAnterior(anterior);
        else
            anterior = anterior;

        nodoAEliminar.setSiguiente(null);
        nodoAEliminar.setAnterior(null);

        return nodoAEliminar.getDato();*/
    

    public boolean eliminar(int indice) 
    {
        return quitar(indice)!=null;
        //===============================================
        /*T elemento = obtener(indice);
        if (elemento == null) return false;

        if (indice == 0) 
        {
            cabeza = (NodoDoble<T>) cabeza.getSiguiente();
            if (cabeza != null) cabeza.setAnterior(null);
            else anterior = null;
            return true;
        }

        NodoDoble<T> anterior = cabeza;
        int i = 0;

        while (anterior != null && i < indice - 1) 
        {
            anterior = (NodoDoble<T>) anterior.getSiguiente();
            i++;
        }

        NodoDoble<T> nodoAEliminar = (NodoDoble<T>) anterior.getSiguiente();
        anterior.setSiguiente(nodoAEliminar.getSiguiente());

        if (nodoAEliminar.getSiguiente() != null)
            ((NodoDoble<T>) nodoAEliminar.getSiguiente()).setAnterior(anterior);
        else
            anterior = anterior;

        return true;*/
    }

    @Override
    public boolean contiene(T elemento) 
    {
        return indiceDe(elemento) != -1;
    }

    @Override
    public int indiceDe(T dato) //PERFECTISIMO
    {
        if (dato == null) return -1;

        NodoDoble<T> nuevo = cabeza;
        int indice = 0;

        while (nuevo != null) 
        {
            if (nuevo.getDato().equals(dato)) return indice;
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
            indice++;
        }
        return -1;
    }

    @Override
    public T buscar(Predicate<T> criterio) 
    {
        if (criterio == null) return null;

        NodoDoble<T> temp = cabeza;

        while (temp != null) 
        {
            if (criterio.test(temp.getDato())) return temp.getDato();
            temp = (NodoDoble<T>) temp.getSiguiente();
        }
        return null;
    }

    public TDALista<T> ordenarTotal(Comparator<T> comp) //EDITA LISTA ORIGINAL
    {
        if (cabeza == null) return this;

        NodoDoble<T> nuevo = cabeza;

        while (nuevo != null) 
        {
            NodoDoble<T> menor = nuevo;
            NodoDoble<T> temp = (NodoDoble<T>) nuevo.getSiguiente();

            while (temp != null) 
            {
                if (comp.compare(temp.getDato(), menor.getDato()) < 0) menor = temp;
                temp = (NodoDoble<T>) temp.getSiguiente();
            }

            T aux = nuevo.getDato();
            nuevo.setDato(menor.getDato());
            menor.setDato(aux);

            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        return this;
    }
    

    @Override
    public TDALista<T> ordenarParcial(Comparator<T> comp) 
    {
        if (cabeza == null) return this;

        ListaEnlazadaDoble<T> resultado = new ListaEnlazadaDoble<>();
        NodoDoble<T> nuevo = cabeza;

        while (nuevo != null) 
        {
            resultado.agregar(nuevo.getDato());
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        NodoDoble<T> i = resultado.cabeza;

        while (i != null) 
        {
            NodoDoble<T> menor = i;
            NodoDoble<T> j = (NodoDoble<T>) i.getSiguiente();

            while (j != null) 
            {
                if (comp.compare(j.getDato(), menor.getDato()) < 0) menor = j;
                j = (NodoDoble<T>) j.getSiguiente();
            }

            T aux = i.getDato();
            i.setDato(menor.getDato());
            menor.setDato(aux);

            i = (NodoDoble<T>) i.getSiguiente();
        }

        return resultado;
    }

    @Override
    public int tamano() //DIVINOOOOO :)
    {
        int contador = 0;
        NodoDoble<T> nuevo = cabeza;

        while (nuevo != null) 
        {
            contador++;
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        return contador;
    }

    @Override
    public boolean esVacio() 
    {
        return cabeza == null;
    }

    @Override
    public void vaciar() 
    {
        cabeza = null;
        anterior = null;
    }

    @Override
    public TDALista<T> invertir() 
    {
        NodoDoble<T> anterior = null;//anterior inicializado en nuli
        NodoDoble<T> nuevo = cabeza; // nuevo es el inicio de la lista

        while (nuevo != null) //mientras el nuevo sea distiendo de nulo
        {
            NodoDoble<T> siguiente = (NodoDoble<T>) nuevo.getSiguiente(); // se inicializa el nodo siguiente que apunta al siguiente del nuevo

            nuevo.setSiguiente(anterior);
            nuevo.setAnterior(siguiente);

            anterior = nuevo;
            nuevo = siguiente;
        }

        NodoDoble<T> temp = cabeza;
        cabeza = anterior;
        anterior = temp;

        return this;
    }

    @Override
    public TDALista<T> concatenar(TDALista<T> otra) 
    {
        ListaEnlazadaDoble<T> resultado = new ListaEnlazadaDoble<>();

        NodoDoble<T> nuevo = cabeza;
        while (nuevo != null) 
        {
            resultado.agregar(nuevo.getDato());
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        for (int i = 0; i < otra.tamano(); i++)
            resultado.agregar(otra.obtener(i));

        return resultado;
    }

    @Override
    public TDALista<T> intercalar(TDALista<T> otra) 
    {
        ListaEnlazadaDoble<T> resultado = new ListaEnlazadaDoble<>();

        NodoDoble<T> nuevo = cabeza;
        int j = 0;

        while (nuevo != null && j < otra.tamano()) 
        {
            resultado.agregar(nuevo.getDato());
            resultado.agregar(otra.obtener(j));
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
            j++;
        }

        while (nuevo != null) 
        {
            resultado.agregar(nuevo.getDato());
            nuevo = (NodoDoble<T>) nuevo.getSiguiente();
        }

        while (j < otra.tamano()) 
        {
            resultado.agregar(otra.obtener(j));
            j++;
        }

        return resultado;
    }
}