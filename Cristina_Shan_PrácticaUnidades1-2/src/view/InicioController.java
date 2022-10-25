package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class InicioController {

	   @FXML
	    private ChoiceBox<Object> ChoiceLocation;
	   
	   private void initialize() {
		   
		   /*CHOICE BOX  -------------------------------------------------------------------------------------------------------------------------------- */
			  //Para añadir una línea de separación
		   ChoiceLocation.getItems().addAll("España", "Francia" ,"Reino Unido", "Alemania", "Italia", "Polonia", "Austria", "Hungría");
			  //Para poner por defecto una opción
		   ChoiceLocation.setValue("España");
	   }

}
