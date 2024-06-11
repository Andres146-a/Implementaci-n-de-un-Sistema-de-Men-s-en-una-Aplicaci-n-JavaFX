package application;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Crear la barra de menú
        MenuBar menuBar = new MenuBar();

        // Crear menús principales
        Menu menuArchivo = new Menu("Archivo");
        Menu menuEditar = new Menu("Editar");
        Menu menuAyuda = new Menu("Ayuda");

        // Crear elementos de menú para "Archivo"
        MenuItem itemNuevo = new MenuItem("Nuevo");
        MenuItem itemAbrir = new MenuItem("Abrir");
        MenuItem itemGuardar = new MenuItem("Guardar");
        MenuItem itemSalir = new MenuItem("Salir");

        // Agregar acción a los elementos de menú "Archivo"
        itemNuevo.setOnAction(e -> mostrarMensaje("Nuevo archivo creado"));
        itemAbrir.setOnAction(e -> mostrarMensaje("Archivo abierto"));
        itemGuardar.setOnAction(e -> mostrarMensaje("Archivo guardado correctamente"));
        itemSalir.setOnAction(e -> {
            mostrarMensaje("Saliendo de la aplicación");
            primaryStage.close();
        });

        // Añadir elementos de menú a "Archivo"
        menuArchivo.getItems().addAll(itemNuevo, itemAbrir, itemGuardar, new SeparatorMenuItem(), itemSalir);

        // Crear elementos de menú para "Editar"
        MenuItem itemCopiar = new MenuItem("Copiar");
        MenuItem itemPegar = new MenuItem("Pegar");

        // Agregar acción a los elementos de menú "Editar"
        itemCopiar.setOnAction(e -> mostrarMensaje("Texto copiado"));
        itemPegar.setOnAction(e -> mostrarMensaje("Texto pegado"));

        // Añadir elementos de menú a "Editar"
        menuEditar.getItems().addAll(itemCopiar, itemPegar);

        // Crear elementos de menú para "Ayuda"
        MenuItem itemAcercaDe = new MenuItem("Acerca de");

        // Agregar acción al elemento de menú "Ayuda"
        itemAcercaDe.setOnAction(e -> mostrarMensaje("Acerca de la aplicación"));

        // Añadir elemento de menú a "Ayuda"
        menuAyuda.getItems().add(itemAcercaDe);

        // Añadir menús a la barra de menú
        menuBar.getMenus().addAll(menuArchivo, menuEditar, menuAyuda);

        // Crear un BorderPane y añadir la barra de menú en la parte superior
        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        // Crear la escena y añadir el BorderPane
        Scene scene = new Scene(root, 800, 600);

        // Cargar el archivo CSS
        String css = this.getClass().getResource("application.css").toExternalForm();
        scene.getStylesheets().add(css);

        // Configurar el escenario (Stage)
        primaryStage.setTitle("Ejemplo de Menú en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Método para mostrar mensajes en un diálogo de alerta
    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
