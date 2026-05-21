package com.example.pract5;

public class QuickSort {

    //Metodo principal del algoritmo
    public static void sort(int[] arreglo) {
        // Inicia el ordenamiento desde la posición 0 hasta el final
        quicksort(arreglo, 0, arreglo.length - 1);
    }

    //Metodo recursivo que divide el arreglo en particiones
    private static void quicksort(int[] arreglo, int inicio, int fin) {

        if (inicio < fin) {
            // Obtiene la posición final del pivote
            int pivote = particion(arreglo, inicio, fin);

            // Ordena la parte izquierda del pivote
            quicksort(arreglo, inicio, pivote - 1);

            // Ordena la parte derecha del pivote
            quicksort(arreglo, pivote + 1, fin);
        }
    }

    //Realiza la partición del arreglo.
    private static int particion(int[] arreglo, int inicio, int fin) {

        // Selecciona el último elemento como pivote
        int pivote = arreglo[fin];
        int i = inicio - 1;

        // Recorre el arreglo desde inicio hasta antes del pivote
        for (int j = inicio; j < fin; j++) {
            if (arreglo[j] <= pivote) {

                i++;

                // Intercambia elementos
                int temp = arreglo[i];
                arreglo[i] = arreglo[j];
                arreglo[j] = temp;
            }
        }

        // Coloca el pivote en su posición correcta
        int temp = arreglo[i + 1];
        arreglo[i + 1] = arreglo[fin];
        arreglo[fin] = temp;
        return i + 1;
    }
}
