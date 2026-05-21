package com.example.pract5;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.util.ArrayList;

public class LeerCSV {


     //Convierte un valor numérico en formato String a entero.
    private static int convertirNumero(String valor) {

        if (valor == null || valor.trim().isEmpty()) {
            return 0;
        }

        // Elimina espacios en blanco al inicio y final
        String raw = valor.trim();

        try {

            // Convierte valores terminados en K
            if (raw.endsWith("K")) {

                double val =
                        Double.parseDouble(
                                raw.replace("K", "")
                        );

                return (int)(val * 1000);

                // Convierte valores terminados en M
            } else if (raw.endsWith("M")) {

                double val =
                        Double.parseDouble(
                                raw.replace("M", "")
                        );

                return (int)(val * 1_000_000);

            } else {

                // Convierte números normales eliminando comas
                return Integer.parseInt(
                        raw.replace(",", "")
                );
            }

        } catch (Exception e) {

            return 0;
        }
    }

    //Lee un archivo CSV y carga todos los juegos en una lista.
    public static ArrayList<Game> cargar(String ruta) {
        ArrayList<Game> lista = new ArrayList<>();

        try {

            // Crea el lector del archivo CSV
            CSVReader reader =
                    new CSVReader(
                            new FileReader(ruta)
                    );

            // Saltar encabezado
            reader.readNext();
            String[] datos;

            // Lee cada fila del archivo mientras existan datos
            while ((datos = reader.readNext()) != null) {
                String titulo = datos[1];
                String fecha  = datos[2];
                String team   = datos[3];

                double rating = 0;

                // Convierte el rating a double
                try {
                    if (!datos[4].isEmpty()) {
                        rating = Double.parseDouble(datos[4]);
                    }
                } catch (Exception e) {
                    rating = 0;
                }

                // Convierte datos numéricos usando convertirNumero()
                int timesListed = convertirNumero(datos[5]);
                int reviews     = convertirNumero(datos[6]);
                int plays       = convertirNumero(datos[10]);
                int playing     = convertirNumero(datos[11]);
                int backlogs    = convertirNumero(datos[12]);
                int wishlist    = convertirNumero(datos[13]);

                Game juego =
                        new Game(titulo, fecha, team, rating, timesListed, reviews, plays, playing,
                                backlogs, wishlist);
                lista.add(juego);
            }
            reader.close();
            System.out.println("Juegos cargados: " + lista.size());

        } catch (Exception e) {
            System.out.println("Error leyendo CSV");
            e.printStackTrace();
        }
        return lista;
    }
}
