package view;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class InicioController {

	   @FXML
	    private ChoiceBox<Object> ChoiceLocation;
	   
	   private void initialize() {
		   
		   /*CHOICE BOX  -------------------------------------------------------------------------------------------------------------------------------- */
			  //Para a�adir una l�nea de separaci�n
		   ChoiceLocation.getItems().addAll("Espa�a", "Francia" ,"Reino Unido", "Alemania", "Italia", "Polonia", "Austria", "Hungr�a");
			  //Para poner por defecto una opci�n
		   ChoiceLocation.setValue("Espa�a");
	   }

}
