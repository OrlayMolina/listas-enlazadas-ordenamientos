package co.edu.uniquindio.lista.mergesort;

public class Ordenamiento {

    public static void mergesort(int[] a, int bajo, int alto) {
        int len, pivote, m1, m2;

        if (bajo == alto) {
            return;
        } else {
            len = alto - bajo + 1;
            pivote = (bajo + alto) / 2;

            mergesort(a, bajo, pivote);
            mergesort(a, pivote + 1, alto);

            int[] temp = new int[len];
            for (int i = 0; i < len; i++) {
                temp[i] = a[bajo + i];
            }

            m1 = 0;
            m2 = pivote - bajo + 1;

            for (int i = 0; i < len; i++) {
                if (m2 <= alto - bajo) {
                    if (m1 <= pivote - bajo) {
                        if (temp[m1] > temp[m2]) {
                            a[i + bajo] = temp[m2++];
                        } else {
                            a[i + bajo] = temp[m1++];
                        }
                    } else {
                        a[i + bajo] = temp[m2++];
                    }
                } else {
                    a[i + bajo] = temp[m1++];
                }
            }
        }
    }

    public static void quickSort(int[] arreglo, int inferior, int superior) {
        int i = inferior;
        int j = superior;
        int pivote = arreglo[(inferior + superior) / 2];

        do {
            while (arreglo[i] < pivote) {
                i++;
            }
            while (arreglo[j] > pivote) {
                j--;
            }
            if (i <= j) {
                int auxiliar = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = auxiliar;
                i++;
                j--;
            }
        } while (i <= j);

        if (j > inferior) {
            quickSort(arreglo, inferior, j);
        }
        if (i < superior) {
            quickSort(arreglo, i, superior);
        }
    }

    public static void stoogeSort(int arreglo[], int inicio, int fin) {
        int k;

        // Intercambiar si el primer elemento es mayor que el último
        if (arreglo[inicio] > arreglo[fin]) {
            int temp = arreglo[inicio];
            arreglo[inicio] = arreglo[fin];
            arreglo[fin] = temp;
        }

        // Caso base: si hay 1 o 2 elementos, ya está ordenado
        if (inicio + 1 >= fin) {
            return;
        }

        // Calcular k como un tercio del tamaño del segmento actual
        k = (fin - inicio + 1) / 3;

        // Aplicar StoogeSort en las dos primeras partes
        stoogeSort(arreglo, inicio, fin - k);
        stoogeSort(arreglo, inicio + k, fin);

        // Aplicar StoogeSort nuevamente en las dos primeras partes para asegurar ordenación
        stoogeSort(arreglo, inicio, fin - k);
    }
}
