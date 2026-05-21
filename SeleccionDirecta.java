package com.example.pract5;

public class SeleccionDirecta {

    //Ordena un arreglo de enteros utilizando el algoritmo de Selección Directa
    public static void sort(int[] arreglo) {
        // Obtiene el tamaño del arreglo
        int n = arreglo.length;

        //Recorre el arreglo buscando la posición donde debe colocarse el siguiente número menor.
        for (int i = 0; i < n - 1; i++) {
            int minimo = i;

            //Busca un elemento menor en el resto del arreglo
            for (int j = i + 1; j < n; j++) {
                if (arreglo[j] < arreglo[minimo]) {
                    minimo = j;
                }
            }

            //Intercambia el elemento mínimo encontrado con el elemento en la posición actual
            int temp = arreglo[minimo];
            arreglo[minimo] = arreglo[i];
            arreglo[i] = temp;
        }
    }
}
