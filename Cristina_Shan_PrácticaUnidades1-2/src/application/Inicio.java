package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Inicio extends Application {
	private BorderPane rootInicio;

	@Override
	public void start(Stage primaryStage) {
		try {
			// Carga el diseño del archivo FXML en la variable rootLayout
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Inicio.class.getResource("/view/InicioStore.fxml"));
			rootInicio = (BorderPane) loader.load();

			// Pasamos al controlador de menu el objeto con el BorderPane principal
			InicioController inicioController = loader.getController();
			inicioController.setRootLayout(rootInicio);

			// Mostramos la escena del BorderPane de la variable rootLayot
			Scene scene = new Scene(rootInicio);
			primaryStage.setScene(scene);
			// Opciones de pantalla
			primaryStage.setResizable(false);
			//primaryStage.setMaximized(false);
			primaryStage.setTitle("Joyería SIX");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}