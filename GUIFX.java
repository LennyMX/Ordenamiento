package com.example.pract5;

import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;

public class GUIFX extends Application {
    private TableView<Game> tabla;
    private Label lblTiempo;

    @Override
    public void start(Stage stage) {
        ArrayList<Game> lista = LeerCSV.cargar("games.csv");
        ObservableList<Game> datos = FXCollections.observableArrayList(lista);
        tabla = new TableView<>();

        // TITULO DEL VIDEOJUEGO
        TableColumn<Game, String> colTitulo = new TableColumn<>("Titulo");
        colTitulo.setCellValueFactory(
                data -> new SimpleStringProperty(
                        data.getValue().getTitulo()
                )
        );

        // FECHA DE LANZAMIENTO
        TableColumn<Game, String> colFecha =
                new TableColumn<>("Release Date");

        colFecha.setCellValueFactory(
                data -> new SimpleStringProperty(
                        data.getValue().getFecha()
                )
        );

        // TEAM O DESARROLLADOR
        TableColumn<Game, String> colTeam =
                new TableColumn<>("Team");

        colTeam.setCellValueFactory(
                data -> new SimpleStringProperty(
                        data.getValue().getTeam()
                )
        );

        // RATING
        TableColumn<Game, Number> colRating =
                new TableColumn<>("Rating");

        colRating.setCellValueFactory(
                data -> new SimpleDoubleProperty(
                        data.getValue().getRating()
                )
        );

        // TIMES LISTED
        TableColumn<Game, Number> colTimesListed =
                new TableColumn<>("Times Listed");

        colTimesListed.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getTimesListed()
                )
        );

        // REVIEWS
        TableColumn<Game, Number> colReviews =
                new TableColumn<>("Reviews");

        colReviews.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getReviews()
                )
        );

        // PLAYS
        TableColumn<Game, Number> colPlays =
                new TableColumn<>("Plays");

        colPlays.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getPlays()
                )
        );

        // PLAYING
        TableColumn<Game, Number> colPlaying =
                new TableColumn<>("Playing");

        colPlaying.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getPlaying()
                )
        );

        // BACKLOGS
        TableColumn<Game, Number> colBacklogs =
                new TableColumn<>("Backlogs");

        colBacklogs.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getBacklogs()
                )
        );

        // WISHLIST
        TableColumn<Game, Number> colWishlist =
                new TableColumn<>("Wishlist");

        colWishlist.setCellValueFactory(
                data -> new SimpleIntegerProperty(
                        data.getValue().getWishlist()
                )
        );

        // Agrega todas las columnas a la tabla
        tabla.getColumns().addAll( colTitulo, colFecha, colTeam, colRating, colTimesListed,
                colReviews, colPlays, colPlaying, colBacklogs, colWishlist);
        tabla.setItems(datos);

        // ComboBox para seleccionar la columna a ordenar
        ComboBox<String> comboColumna = new ComboBox<>();

        comboColumna.getItems().addAll("Plays", "Playing", "Backlogs", "Wishlist", "Times Listed",
                "Reviews");
        comboColumna.setValue("Plays");

        // CheckBox de QuickSort
        CheckBox chkQuick = new CheckBox("QuickSort");
        chkQuick.setSelected(true);

        // CheckBox de MergeSort
        CheckBox chkMerge = new CheckBox("MergeSort");
        chkMerge.setSelected(true);

        // CheckBox de ShellSort
        CheckBox chkShell = new CheckBox("ShellSort");
        chkShell.setSelected(true);

        // CheckBox de Selección Directa
        CheckBox chkSeleccion = new CheckBox("Seleccion");
        chkSeleccion.setSelected(true);

        // CheckBox de RadixSort
        CheckBox chkRadix = new CheckBox("RadixSort");
        chkRadix.setSelected(true);

        // CheckBox de Arrays.sort
        CheckBox chkSort = new CheckBox("Arrays.sort");
        chkSort.setSelected(true);

        // CheckBox de Arrays.parallelSort
        CheckBox chkParallel = new CheckBox("Parallel");
        chkParallel.setSelected(true);

        Button btnOrdenar = new Button("Comparar Algoritmos");

        lblTiempo = new Label("Selecciona columna y algoritmos");

        btnOrdenar.setOnAction(e -> {

            //Verifica que al menos un algoritmo esté seleccionado
            boolean alguno =
                    chkQuick.isSelected() ||
                            chkMerge.isSelected() ||
                            chkShell.isSelected() ||
                            chkSeleccion.isSelected() ||
                            chkRadix.isSelected() ||
                            chkSort.isSelected() ||
                            chkParallel.isSelected();
            if (!alguno) {

                Alert alerta = new Alert(Alert.AlertType.WARNING);
                alerta.setTitle("Advertencia");
                alerta.setHeaderText(null);
                alerta.setContentText("Selecciona al menos un algoritmo.");
                alerta.showAndWait();
                return;
            }
            String columna = comboColumna.getValue();
            int[] arreglo = new int[lista.size()];

            //Llena el arreglo con los valores correspondientes a la columna elegida
            for (int i = 0; i < lista.size(); i++) {
                Game g = lista.get(i);
                switch (columna) {

                    case "Plays": arreglo[i] = g.getPlays();
                        break;

                    case "Playing": arreglo[i] = g.getPlaying();
                        break;

                    case "Backlogs": arreglo[i] = g.getBacklogs();
                        break;

                    case "Wishlist": arreglo[i] = g.getWishlist();
                        break;

                    case "Times Listed": arreglo[i] = g.getTimesListed();
                        break;

                    case "Reviews": arreglo[i] = g.getReviews();
                        break;

                    default:
                        arreglo[i] = g.getPlays();
                }
            }

            //Si un algoritmo no está seleccionado el valor permanece en -1
            long tQuick     = -1;
            long tMerge     = -1;
            long tShell     = -1;
            long tSeleccion = -1;
            long tRadix     = -1;
            long tSort      = -1;
            long tParallel  = -1;

            // QuickSort
            if (chkQuick.isSelected()) {

                int[] copia = arreglo.clone();

                tQuick = MedidorTiempo.medir(() ->
                        QuickSort.sort(copia));
            }

            // MergeSort
            if (chkMerge.isSelected()) {

                int[] copia = arreglo.clone();

                tMerge = MedidorTiempo.medir(() ->
                        MergeSort.sort(copia));
            }

            // ShellSort
            if (chkShell.isSelected()) {

                int[] copia = arreglo.clone();

                tShell = MedidorTiempo.medir(() ->
                        ShellSort.sort(copia));
            }

            // Selección Directa
            if (chkSeleccion.isSelected()) {

                int[] copia = arreglo.clone();

                tSeleccion = MedidorTiempo.medir(() ->
                        SeleccionDirecta.sort(copia));
            }

            // RadixSort
            if (chkRadix.isSelected()) {

                int[] copia = arreglo.clone();

                tRadix = MedidorTiempo.medir(() ->
                        RadixSort.sort(copia));
            }

            // Arrays.sort
            if (chkSort.isSelected()) {

                int[] copia = arreglo.clone();

                tSort = MedidorTiempo.medir(() ->
                        Arrays.sort(copia));
            }

            // Arrays.parallelSort
            if (chkParallel.isSelected()) {

                int[] copia = arreglo.clone();

                tParallel = MedidorTiempo.medir(() ->
                        Arrays.parallelSort(copia));
            }

            // Actualiza el label
            lblTiempo.setText(
                    "Ordenando por: " + columna
            );

            // Muestra la ventana con la gráfica comparativa
            GraficaBarras.mostrar( columna, tQuick, tMerge, tShell, tSeleccion, tRadix,
                    tSort, tParallel);
        });

        // Contenedor superior con ComboBox y botón
        HBox filaColumna = new HBox(15);

        filaColumna.getChildren().addAll(
                new Label("Ordenar por:"),
                comboColumna,
                btnOrdenar,
                lblTiempo
        );

        filaColumna.setPadding(
                new Insets(10, 10, 5, 10)
        );

        // Contenedor de algoritmos
        HBox filaCheckboxes = new HBox(15);

        filaCheckboxes.getChildren().addAll(
                new Label("Algoritmos:"), chkQuick, chkMerge, chkShell, chkSeleccion,
                chkRadix, chkSort, chkParallel);

        filaCheckboxes.setPadding(
                new Insets(5, 10, 10, 10)
        );

        // Contenedor principal de controles
        VBox controles = new VBox(5);

        controles.getChildren().addAll(
                filaColumna,
                filaCheckboxes
        );

        // Contenedor central
        VBox centro = new VBox(10);

        centro.getChildren().add(tabla);

        centro.setPadding(new Insets(10));

        // Permite que la tabla crezca automáticamente
        VBox.setVgrow(tabla, Priority.ALWAYS);
        BorderPane root = new BorderPane();
        root.setTop(controles);
        root.setCenter(centro);
        Scene scene = new Scene(root, 1300, 700);
        stage.setScene(scene);
        stage.setTitle("Analisis de Algoritmos");
        stage.show();
    }

    public static void main(String[] args) {

        launch(args);
    }
}
