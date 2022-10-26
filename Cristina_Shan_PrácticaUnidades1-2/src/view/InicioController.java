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
			  //Para a�adir items al choiceBox
		   ChoiceLocation.getItems().addAll("Espa�a", "Francia" ,"Reino Unido", "Alemania", "Italia", "Polonia", "Austria", "Hungr�a");
			  //Para poner por defecto una opci�n
		   ChoiceLocation.setValue("Espa�a");
	   }
	   
	   
	   
	   
	   
	   
	   public BorderPane getRootLayout() {
			return rootInicio;
		}

		public void setRootLayout(BorderPane rootLayout) {
			this.rootInicio = rootLayout;
		}	

}
