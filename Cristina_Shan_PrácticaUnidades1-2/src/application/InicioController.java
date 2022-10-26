package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InicioController {

	@FXML
	private ChoiceBox<String> ChoiceLocation;


	//Pantalla principal en donde se muestra o a�ade el contenido
	private BorderPane rootInicio;

	/*------- INICIALIZADOR -----------------------------------------------------------------------------------------------------*/
	@FXML
	private void initialize() {

		System.out.print(ChoiceLocation);
		/* -- CHOICE BOX -------------------------------------------------------------------------------------------- */
		// Para a�adir items al choiceBox
		ChoiceLocation.getItems().addAll("Espa�a", "Francia", "Reino Unido", "Alemania", "Italia", "Polonia", "Austria",
				"Hungr�a");

		// Para poner por defecto una opci�n
		ChoiceLocation.setValue("Espa�a");
	}

	/* -- MOSTRAR LA P�GINA DE SERVICIO AL CLIENTE -------------------------------------------------------------------------------------------- */
	@FXML
	void AyudaCliente(ActionEvent event) {
		try {
			// Cargamos el archivo Controles Din�micos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(InicioController.class.getResource("/view/SAyuda.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();

			// Se sit�a en el centro del dise�o principal
			rootInicio.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/* -- NOS ABRA EL CENTRO DE ADMINISTRACI�N -------------------------------------------------------------------------------------------- */
	@FXML
	void AbrirListas(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Menu.fxml"));
			// Se carga la venta
			Parent root = loader.load();

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* -- REDIRECCI�N A LA P�GINA DE INICIO -------------------------------------------------------------------------------------------- */
	@FXML
	void VolverInicio(ActionEvent event) {
		// Cargo la vista
		try {
			Node source = (Node) event.getSource();
			Stage stage = (Stage) source.getScene().getWindow();
			// Cargamos el ARCHIVO
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(InicioController.class.getResource("/view/InicioStore.fxml"));
			rootInicio = (BorderPane) loader.load();
			stage.setTitle("Inicio");
			InicioController IniCon = loader.getController();
			IniCon.setRootLayout(rootInicio);
			Scene scene = new Scene(rootInicio);
			stage.setScene(scene);
			stage.show();
			// Se sit�a en el centro del dise�o principal

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*-- GETTERS Y SETTERS ------------------------------------------------------------------------------------------------------*/
	public BorderPane getRootLayout() {
		return rootInicio;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootInicio = rootLayout;
	}

}
