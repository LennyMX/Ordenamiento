package com.example.pract5;

public class MergeSort {

    //Método principal del algoritmo MergeSort
    public static void sort(int[] arreglo) {
        // Inicia el ordenamiento desde la primera hasta la última posición
        mergesort(arreglo, 0, arreglo.length - 1);
    }

    //Método recursivo que divide el arreglo en mitades
    private static void mergesort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda < derecha) {
            // Calcula la posición media del arreglo
            int medio = (izquierda + derecha) / 2;

            // Ordena la mitad izquierda
            mergesort(arreglo, izquierda, medio);

            // Ordena la mitad derecha
            mergesort(arreglo, medio + 1, derecha);

            // Combina ambas mitades ordenadas
            merge(arreglo, izquierda, medio, derecha);
        }
    }

    //Combina dos subarreglos ordenados en uno solo
    private static void merge(int[] arreglo, int izquierda, int medio, int derecha) {

        // Tamaño del subarreglo izquierdo
        int n1 = medio - izquierda + 1;

        // Tamaño del subarreglo derecho
        int n2 = derecha - medio;

        // Arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia elementos al arreglo izquierdo
        for (int i = 0; i < n1; i++)
            L[i] = arreglo[izquierda + i];

        // Copia elementos al arreglo derecho
        for (int j = 0; j < n2; j++)
            R[j] = arreglo[medio + 1 + j];

        // Índices auxiliares
        int i = 0;
        int j = 0;

        // Índice del arreglo principal
        int k = izquierda;

        // Compara ambos arreglos temporales
        while (i < n1 && j < n2) {

            // Inserta el menor elemento
            if (L[i] <= R[j]) {

                arreglo[k] = L[i];
                i++;

            } else {

                arreglo[k] = R[j];
                j++;
            }

            k++;
        }

        // Copia elementos restantes del arreglo izquierdo
        while (i < n1) {

            arreglo[k] = L[i];
            i++;
            k++;
        }

        // Copia elementos restantes del arreglo derecho
        while (j < n2) {

            arreglo[k] = R[j];
            j++;
            k++;
        }
    }
}
