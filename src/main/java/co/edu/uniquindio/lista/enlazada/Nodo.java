package co.edu.uniquindio.lista.enlazada;

public class Nodo<T> {

    private T valor;
    private Nodo<T> previo;
    private Nodo<T> siguiente;

    public Nodo (T valor){
        this.valor = valor;
        this.previo = null;
        this.siguiente = null;
    }

    public void setValor(T valor){
        this.valor = valor;
    }

    public T getValor(){
        return this.valor;
    }

    public void setPrevio(Nodo<T> nodo){
        this.previo = nodo;
    }

    public Nodo<T> getPrevio(){
        return this.previo;
    }

    public void setSiguiente(Nodo<T> nodo){
        this.siguiente = nodo;
    }

    public Nodo<T> getSiguiente(){
        return this.siguiente;
    }
}
