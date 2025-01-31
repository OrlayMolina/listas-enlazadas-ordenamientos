package co.edu.uniquindio.lista.enlazada;

public class mainListaEnlazada {
    public static void main(String[] args) {
        ListaEnlazada<Integer> listaNumeros = new ListaEnlazada<>();
        listaNumeros.agregarInicio(5);
        listaNumeros.agregarInicio(4);
        listaNumeros.agregarInicio(7);
        listaNumeros.agregarFinal(8);
        listaNumeros.agregar(2, 6);

        if(listaNumeros.estaVacia()){
            System.out.println("Lista vacía.");
        }else {
            listaNumeros.imprimirLista();
        }
    }
}
