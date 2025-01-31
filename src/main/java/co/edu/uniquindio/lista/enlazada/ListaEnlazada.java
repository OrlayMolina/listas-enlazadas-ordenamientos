package co.edu.uniquindio.lista.enlazada;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Iterable<Nodo<T>> {

    private Nodo<T> primero;
    private Nodo<T> ultimo;
    private int tamanio;

    public ListaEnlazada(){
        this.primero = null;
        this.ultimo = null;
        this.tamanio = 0;
    }

    public void agregarInicio(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if(primero == null){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            primero.setPrevio(nuevoNodo);
            nuevoNodo.setSiguiente(primero);
            primero = nuevoNodo;
        }
        tamanio++;
    }

    public void agregarFinal(T valor){
        Nodo<T> nuevoNodo = new Nodo<>(valor);
        if(ultimo == null){
            primero = ultimo = nuevoNodo;
        }else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public void agregar(int indice, T valor) {
        Nodo<T> nodoNuevo = new Nodo<>(valor);

        if (indiceValido(indice)) {
            if (indice == 0) {
                nodoNuevo.setSiguiente(primero);
                if (primero != null) {
                    primero.setPrevio(nodoNuevo);
                }
                primero = nodoNuevo;
                if (ultimo == null) {
                    ultimo = nodoNuevo;
                }
            } else {
                Nodo<T> temp = primero;
                int aux = 0;

                while (temp != null && aux < indice - 1) {
                    temp = temp.getSiguiente();
                    aux++;
                    System.out.println("=== " + aux + " === temp " + temp.getValor());
                }

                assert temp != null;
                nodoNuevo.setSiguiente(temp.getSiguiente());
                nodoNuevo.setPrevio(temp);

                if (temp.getSiguiente() != null) {
                    temp.getSiguiente().setPrevio(nodoNuevo);
                } else {
                    ultimo = nodoNuevo;
                }
                temp.setSiguiente(nodoNuevo);
            }
        } else {
            throw new IndexOutOfBoundsException("El índice está fuera del tamaño de la lista.");
        }
    }

    // TODO pendiente arreglar método
    public T obtenerNodo(Nodo<T> nodo){
        Nodo<T> temp = primero;
        if(primero == null){
            throw new NoSuchElementException("La lista esta vacía");
        }
        while(!primero.equals(nodo)){
            temp = temp.getSiguiente();
        }
        return temp.getValor();
    }

    public boolean estaVacia(){
        return tamanio == 0;
    }

    public boolean indiceValido(int index){
        return index >= 0 && index < this.tamanio;
    }

    public void imprimirLista(){
        Nodo<T> temp = primero;
        if(primero == null){
            throw new NoSuchElementException("La lista está vacía.");
        }else{
            while (temp != null){
                System.out.print(temp.getValor() + " ");
                temp = temp.getSiguiente();
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Nodo<T>> iterator() {
        return new ListaEnlazadaIterator();
    }

    public class ListaEnlazadaIterator implements Iterator<Nodo<T>>{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Nodo<T> next() {
            return null;
        }
    }
}
