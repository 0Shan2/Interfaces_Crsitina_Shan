package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;

public class InicioController {

	   @FXML
	    private ChoiceBox<Object> ChoiceLocation;
	   
	   private BorderPane rootInicio;
	   
	   private void initialize() {
		   
		   /*CHOICE BOX  -------------------------------------------------------------------------------------------------------------------------------- */
			  //Para añadir items al choiceBox
		   ChoiceLocation.getItems().addAll("España", "Francia" ,"Reino Unido", "Alemania", "Italia", "Polonia", "Austria", "Hungría");
			  //Para poner por defecto una opción
		   ChoiceLocation.setValue("España");
	   }
	   
	   
	   
	   
	   
	   
	   public BorderPane getRootLayout() {
			return rootInicio;
		}

		public void setRootLayout(BorderPane rootLayout) {
			this.rootInicio = rootLayout;
		}	

}
