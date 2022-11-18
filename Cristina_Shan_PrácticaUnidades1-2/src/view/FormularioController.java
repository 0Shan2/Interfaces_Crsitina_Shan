package view;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import model.Person;

public class FormularioController {

	    @FXML
	    private Button btnCancelarForm;

	    @FXML
	    private Button btnGuardarForm;

	    @FXML
	    private TextField codigoField;

	    @FXML
	    private TextField nombreField;
	    
	    @FXML
	    private TextField materialesField;
	    
	    @FXML
	    private TextField cantidadField;

	    @FXML
	    private TextField precioField;
	    
	    @FXML
	    private ToggleGroup nuevoOp;

	 // Este componente ser� un di�logo. Campos auxiliares para su gesti�n
	    private Stage dialogStage;
	    private Person person;
	    private boolean okClicked = false;
		
	    
	     //M�todo para inicializar el controlador que se llama cuando se carga el FXML
	    @FXML
	    private void initialize() {
	    	
	    }
		
	    
	    public void Items(Person person) {
	    	this.person = person;
	    	codigoField.setText(person.getCodigo());
	    	nombreField.setText(person.getNombre());
	    	materialesField.setText(person.getMaterial());
	    	cantidadField.setText(Integer.toString(person.getCantidad_Stock()));
	    	precioField.setText(Integer.toString(person.getPrecio()));
	    }
	    
	    //Devuelve true si el usuario hace click en el bot�n "OK"
	    public boolean isOkClicked() {
	        return okClicked;
	    }
	    
	    @FXML
	    void GuardarForm(ActionEvent event) {
	    	 if (isInputValid()) {
	    		 
	    		 person = new Person(codigoField.getText(), nombreField.getText(),
	    				 materialesField.getText(), Integer.parseInt(cantidadField.getText()),
	    				 Integer.parseInt(precioField.getText()));
//	             person.setCodigo(codigoField.getText());
//	             person.setNombre(nombreField.getText());
//	             person.setMaterial(materialesField.getText());
//	             person.setCantidad_Stock(Integer.parseInt(cantidadField.getText()));
//	             person.setPrecio(Integer.parseInt(precioField.getText()));
	            
	             okClicked = true;
	             dialogStage.close();
	         }
	    }
	    
	    //Manejador del bot�n "Cancel" 
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	    
	    
	     // Valida los campos de texto del usuario
	      //true si los campos son v�lidos
	    private boolean isInputValid() {
	        String errorMessage = "";

	        if (codigoField.getText() == null || codigoField.getText().length() == 0) {
	            errorMessage += "El campo c�digo est� vac�o\n"; 
	        }
	        if (nombreField.getText() == null || nombreField.getText().length() == 0) {
	            errorMessage += "El campo nombre est� vac�o\n"; 
	        }
	        if (materialesField.getText() == null || materialesField.getText().length() == 0) {
	            errorMessage += "El campo materiales est� vac�o\n"; 
	        }

	        if (cantidadField.getText() == null || cantidadField.getText().length() == 0) {
	            errorMessage += "El campo cantidad code est� vac�o\n"; 
	        } else {
	            // Se intenta convertir el c�digo postal en entero y si da un error se muestra un mensaje
	            try {
	                Integer.parseInt(cantidadField.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "La cantidad solo puede ser un n�mero entero.\n"; 
	            }
	        }
	        if (precioField.getText() == null || precioField.getText().length() == 0) {
	            errorMessage += "El campo precio est� vac�o\n"; 
	        }


	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	        	// Se muestra un alert si no se puede eliminar la fila
	    		Alert errorAlert = new Alert(AlertType.ERROR);
	        	
	    		errorAlert.setTitle("Hay campos incorrectos");
	    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
	    		errorAlert.setContentText(errorMessage);
	    		
	    		errorAlert.showAndWait();
	            return false;
	        }
	    }

	    @FXML
	    void CancelarForm(ActionEvent event) {
	    	//Cerrar la ventana
	    	 dialogStage.close();
	    }

	    
	    /**
	     * M�todo set de la propiedad dialogStage
	     * 
	     * @param dialogStage
	     */
	    public void setDialogStage(Stage dialogStage) {
	        this.dialogStage = dialogStage;
	    }


		public void setPerson(Person person) {
			// TODO Auto-generated method stub
			
		}

}
