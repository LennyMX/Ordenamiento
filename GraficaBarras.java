package com.example.pract5;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class GraficaBarras {

    //Crea y muestra una ventana con una gráfica de barras
    public static void mostrar( String columna, long quick, long merge, long shell, long seleccion,
            long radix, long sort, long parallel) {

        CategoryAxis ejeX = new CategoryAxis();
        NumberAxis ejeY = new NumberAxis();
        ejeX.setLabel("Algoritmos");
        ejeY.setLabel("Nanosegundos");

        ejeX.setTickLabelRotation(15);
        ejeY.setAutoRanging(false);

        // Crea la gráfica de barras
        BarChart<String, Number> grafica = new BarChart<>(ejeX, ejeY);
        grafica.setTitle("Comparacion de Algoritmos Ordenando: " + columna);
        grafica.setLegendVisible(false);
        grafica.setCategoryGap(30);
        grafica.setBarGap(5);

        // Serie donde se almacenan las barras
        XYChart.Series<String, Number> serie = new XYChart.Series<>();
        long maximo = 0;

        // QuickSort
        if (quick != -1) {
            serie.getData().add(new XYChart.Data<>("QuickSort", quick));
            if (quick > maximo) maximo = quick;
        }

        // MergeSort
        if (merge != -1) {

            serie.getData().add(new XYChart.Data<>("MergeSort", merge));
            if (merge > maximo) maximo = merge;
        }

        // ShellSort
        if (shell != -1) {

            serie.getData().add(new XYChart.Data<>("ShellSort", shell));
            if (shell > maximo) maximo = shell;
        }

        // Selección Directa
        if (seleccion != -1) {

            serie.getData().add(new XYChart.Data<>("Seleccion", seleccion));
            if (seleccion > maximo) maximo = seleccion;
        }

        // RadixSort
        if (radix != -1) {

            serie.getData().add(new XYChart.Data<>("RadixSort", radix));
            if (radix > maximo) maximo = radix;
        }

        // Arrays.sort()
        if (sort != -1) {

            serie.getData().add(new XYChart.Data<>("Arrays.sort", sort));
            if (sort > maximo) maximo = sort;
        }

        // Arrays.parallelSort()
        if (parallel != -1) {

            serie.getData().add(new XYChart.Data<>("Parallel", parallel));
            if (parallel > maximo) maximo = parallel;
        }
        // Agrega la serie a la gráfica
        grafica.getData().add(serie);

//Ajusta el valor de Y para que se vean bien las barras
        long tope = (long)(maximo * 1.2);
        ejeY.setUpperBound(tope);
        // Valor mínimo del eje Y
        ejeY.setLowerBound(0);
        // División de marcas del eje Y
        ejeY.setTickUnit(tope / 5.0);
        VBox root = new VBox(grafica);
        root.setPadding(new Insets(15));
        Scene scene = new Scene(root, 1000, 600);
        Stage ventana = new Stage();
        ventana.setTitle("Resultados — " + columna);
        ventana.setScene(scene);


        ventana.setOnShown(e -> {

            // Recorre todas las barras de la gráfica
            for (XYChart.Data<String, Number> dato : serie.getData()) {

                // Verifica que el nodo sea una barra
                if (dato.getNode() instanceof StackPane barra) {

                    // Obtiene el valor de la barra
                    long valor = dato.getYValue().longValue();
                    Text etiqueta = new Text(String.format("%,d ns", valor));
                    etiqueta.setStyle("-fx-font-size: 10px;" + "-fx-font-weight: bold;");

                    // Agrega la etiqueta encima de la barra
                    barra.getChildren().add(etiqueta);

                    // Posiciona la etiqueta arriba y centrada
                    StackPane.setAlignment(etiqueta, Pos.TOP_CENTER);

                    // Ajusta la posición vertical
                    etiqueta.setTranslateY(-18);
                }
            }
        });
        ventana.show();
    }
}
