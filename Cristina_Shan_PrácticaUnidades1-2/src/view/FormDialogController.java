package view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.Person;

public class FormDialogController implements Initializable{

	@FXML
	private ToggleGroup nuevoOp;
	@FXML
	private Button btnCancelarForm;

	@FXML
	private Button btnGuardarForm;

	@FXML
	private TextField cantidadField;

	@FXML
	private TextField codigoField;

	@FXML
	private TextField materialesField;

	@FXML
	private TextField nombreField;

	@FXML
	private TextField precioField;
	
	//Variables para nuestro formulario 
	private Person persona;
	
	private ObservableList<Person> ObservableListPersonas;


	//Método que implementa initializable, inicializamos el controlador
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

	
	public void inicializarAtributos (ObservableList<Person> personas) {
		this.ObservableListPersonas = personas;
	}
	
	public void inicializarAtributos(ObservableList<Person> personas, Person paramp) {
		this.ObservableListPersonas = personas;
		this.persona = paramp;
		// cargamos los datos
		this.codigoField.setText(paramp.getCodigo());
		this.nombreField.setText(paramp.getNombre());
		this.materialesField.setText(paramp.getMaterial());
		// Le ponemos un "+ ' '" para que nos los cuente como texto
		this.cantidadField.setText(paramp.getCantidad_Stock() + "");
		this.precioField.setText(paramp.getPrecio() + "");
	}
	
	//------ ACTION EVENTs ---------------------------------------------------------------------------

	@FXML
	void GuardarForm(ActionEvent event) {
		// Recojemos los datos
		String codigo = this.nombreField.getText();
		String nombre = this.nombreField.getText();
		String materiales = this.materialesField.getText();
		int cantidad = Integer.parseInt( this.cantidadField.getText() );
		int precio = Integer.parseInt( this.precioField.getText() );
		
		// Creamos la persona
		Person PItem = new Person(codigo, nombre, materiales, cantidad, precio);
		
		// Comprobamos si existe
		if (!ObservableListPersonas.contains(PItem)) {
			// Para modificar
			if (this.persona != null) {
				//Modificamos el objeto
				this.persona.setCodigo(codigo);
				this.persona.setNombre(nombre);
				this.persona.setMaterial(materiales);
				this.persona.setCantidad_Stock(cantidad);
				this.persona.setPrecio(precio);
			}
			else {
				//Insertamos
				this.persona = PItem;
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setHeaderText(null);
				alert.setTitle("Datos");
				alert.setContentText("¡Su opreción se ha realizado con éxito!");
				alert.showAndWait();
			}
			// Se cierra la ventana
			Stage stage = (Stage) this.btnGuardarForm.getScene().getWindow();
			stage.close();
		} else {
			 Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("El item que se ha intentado añadir ya existe.");
            alert.showAndWait();
		}
	}
	
	
	@FXML
	void CancelarForm(ActionEvent event) {
		this.persona = null;
		// Se cierra la venta
		Stage stage = (Stage) this.btnCancelarForm.getScene().getWindow();
		stage.close();
	}
	
	public Person getPersona() {
		return persona;
	}

}
