package com.example.pract5;

public class RadixSort {

    //Ordena un arreglo de enteros utilizando el algoritmo RadixSort.
    public static void sort(int[] arreglo) {
        // Obtiene el número más grande del arreglo
        int max = getMax(arreglo);

        //Recorre cada posición decimal unidades, decenas y centenas
        for (int exp = 1;
             max / exp > 0;
             exp *= 10) {

            // Ordena según el dígito actual
            ordenarPorDigito(arreglo, exp);
        }
    }

    //Getter del valor máximo del arreglo.
    private static int getMax(int[] arreglo) {
        int max = arreglo[0];

        // Recorre el arreglo buscando el mayor valor
        for (int i = 1; i < arreglo.length; i++) {

            if (arreglo[i] > max) {
                max = arreglo[i];
            }
        }
        return max;
    }

    //Ordena el arreglo según un dígito específico
    private static void ordenarPorDigito(int[] arreglo, int exponente) {
        int n = arreglo.length;

        // Arreglo auxiliar donde se almacenará el resultado ordenado
        int[] output = new int[n];
        int[] count = new int[10];

        //Cuenta cuántas veces aparece cada dígito en la posición actual
        for (int i = 0; i < n; i++) {
            count[(arreglo[i] / exponente) % 10]++;
        }

        //Convierte el arreglo count en posiciones acumuladas para determinar la posición correcta de cada elemento
        for (int i = 1; i < 10; i++) {

            count[i] += count[i - 1];
        }

        //Construye el arreglo ordenado recorriendo desde el final
        for (int i = n - 1; i >= 0; i--) {
            output[count[(arreglo[i] / exponente) % 10] - 1]
                    = arreglo[i];

            count[(arreglo[i] / exponente) % 10]--;
        }

        //Copia el resultado ordenado nuevamente al arreglo original
        for (int i = 0; i < n; i++) {

            arreglo[i] = output[i];
        }
    }
}
