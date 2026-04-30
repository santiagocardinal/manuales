package com.example;

/**
 * CONJUNTO — implementación de TDAConjunto usando ListaEnlazada como base.
 *
 * Un conjunto es una lista SIN DUPLICADOS donde el orden no importa.
 *
 * Hereda todo de ListaEnlazada y sobreescribe agregar() para
 * rechazar duplicados. Las operaciones de conjunto crean listas nuevas.
 *
 * Visualización:
 *   {10, 20, 30}  — sin repetidos, sin orden relevante
 */
public class Conjunto<T> extends ListaEnlazada<T> implements TDAConjunto<T>
{
    // ── CONSTRUCTORES ──────────────────────────────────────────

    public Conjunto() { super(); }

    public Conjunto(T[] elementos)
    {
        super();
        for (T elemento : elementos)
            this.agregar(elemento); // usa nuestro agregar() que rechaza duplicados
    }

    // ── SOBREESCRITURA DE agregar() ────────────────────────────

    /**
     * Agrega el elemento SOLO si no existe ya en el conjunto.
     * Es la única diferencia estructural con ListaEnlazada.
     *
     * Complejidad: O(n) — necesita verificar si ya existe
     */
    @Override
    public boolean agregar(T elemento)
    {
        if (elemento == null)  return false;  // no permitimos nulls
        if (contiene(elemento)) return false;  // no permitimos duplicados
        return super.agregar(elemento);        // delegamos al padre
    }

    // ── OPERACIONES DE CONJUNTO ────────────────────────────────

    /**
     * Retorna un NUEVO conjunto con todos los elementos de ambos conjuntos.
     * Los duplicados se evitan porque usamos agregar() del conjunto.
     *
     * Ejemplo:
     *   A = {1, 2, 3}
     *   B = {2, 3, 4}
     *   A ∪ B = {1, 2, 3, 4}
     *
     * Complejidad: O(n + m)
     */
    @Override
    public TDAConjunto<T> union(TDAConjunto<T> otro)
    {
        Conjunto<T> resultado = new Conjunto<>();

        // agregamos todos los de este conjunto
        for (int i = 0; i < tamano(); i++)
            resultado.agregar(this.obtener(i));

        // agregamos los de 'otro' — los duplicados son rechazados automáticamente
        for (int i = 0; i < otro.tamano(); i++)
            resultado.agregar(otro.obtener(i));

        return resultado;
    }

    /**
     * Retorna un NUEVO conjunto con los elementos comunes a ambos conjuntos.
     *
     * Ejemplo:
     *   A = {1, 2, 3}
     *   B = {2, 3, 4}
     *   A ∩ B = {2, 3}
     *
     * Complejidad: O(n * m)
     */
    @Override
    public TDAConjunto<T> interseccion(TDAConjunto<T> otro)
    {
        Conjunto<T> resultado = new Conjunto<>();

        // un elemento va al resultado solo si está en AMBOS conjuntos
        for (int i = 0; i < tamano(); i++)
        {
            T elemento = this.obtener(i);
            if (otro.contiene(elemento))
                resultado.agregar(elemento);
        }

        return resultado;
    }

    /**
     * Retorna un NUEVO conjunto con los elementos de este conjunto
     * que NO están en 'otro'.
     *
     * Ejemplo:
     *   A = {1, 2, 3}
     *   B = {2, 3, 4}
     *   A - B = {1}   ← solo lo que está en A y no en B
     *
     * Complejidad: O(n * m)
     */
    @Override
    public TDAConjunto<T> diferencia(TDAConjunto<T> otro)
    {
        Conjunto<T> resultado = new Conjunto<>();

        // un elemento va al resultado solo si NO está en 'otro'
        for (int i = 0; i < tamano(); i++)
        {
            T elemento = this.obtener(i);
            if (!otro.contiene(elemento))
                resultado.agregar(elemento);
        }

        return resultado;
    }

    /**
     * Retorna true si TODOS los elementos de este conjunto están en 'otro'.
     *
     * Ejemplo:
     *   A = {1, 2}
     *   B = {1, 2, 3}
     *   A.esSubconjuntoDe(B) → true   ← todos los de A están en B
     *
     *   A = {1, 4}
     *   B = {1, 2, 3}
     *   A.esSubconjuntoDe(B) → false  ← el 4 no está en B
     *
     * Complejidad: O(n * m)
     */
    @Override
    public boolean esSubconjuntoDe(TDAConjunto<T> otro)
    {
        for (int i = 0; i < tamano(); i++)
        {
            if (!otro.contiene(this.obtener(i)))
                return false; // encontramos un elemento que no está en 'otro'
        }
        return true; // todos los elementos de este conjunto están en 'otro'
    }

    // ── DEBUG ───────────────────────────────────────────────────

    @Override
    public String toString()
    {
        if (esVacio()) return "CONJUNTO VACÍO {}";

        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < tamano(); i++)
        {
            sb.append(obtener(i));
            if (i < tamano() - 1) sb.append(", ");
        }
        return sb.append("}").toString();
    }
}