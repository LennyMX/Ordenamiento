package com.example.pract5;

public class ShellSort {

    //Ordena un arreglo de enteros utilizando el algoritmo shellSort
    public static void sort(int[] arreglo) {

        // Obtiene el tamaño del arreglo
        int n = arreglo.length;

        //El gap inicia en la mitad del tamaño del arreglo y se reduce a la mitad en cada iteración
        for (int gap = n / 2;
             gap > 0;
             gap /= 2) {

            // Recorre el arreglo desde la posición gap
            for (int i = gap; i < n; i++) {

                // Guarda temporalmente el elemento actual
                int temp = arreglo[i];
                int j;

                //Desplaza elementos mayores hacia la derecha hasta encontrar la posición correcta
                for (j = i;
                     j >= gap &&
                             arreglo[j - gap] > temp;
                     j -= gap) {

                    arreglo[j] = arreglo[j - gap];
                }

                // Inserta el elemento en su posición correcta
                arreglo[j] = temp;
            }
        }
    }
}
