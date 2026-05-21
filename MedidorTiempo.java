package com.example.pract5;

public class MedidorTiempo {

    public static long medir(Runnable metodo) {

        long inicio = System.nanoTime();

        metodo.run();

        long fin = System.nanoTime();

        return fin - inicio;
    }
}
