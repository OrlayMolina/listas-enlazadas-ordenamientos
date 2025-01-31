package co.edu.uniquindio.lista.mergesort;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainSort {
    public static void main(String[] args) {
        int[] arreglo = {38, 27, 43, 3, 9, 82, 10};

        Ordenamiento.mergesort(arreglo, 0, arreglo.length - 1);

        List<Integer> lista = Arrays.stream(arreglo)
                .boxed()
                .toList();

        lista.forEach(numero -> System.out.print(numero + " "));
    }
}
