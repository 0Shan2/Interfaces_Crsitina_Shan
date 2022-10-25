package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

public class MenuController {
	

	@FXML
	    private TableView<Person> TablaLista;
	 
	 @FXML
	    private TableView<Person> tablaHombre;
	    
	    @FXML
	    private TableColumn<Person, String> ColCodigo;
	    
	    @FXML
	    private TableColumn<Person, String> ColNombre;
	    
	    @FXML
	    private TableColumn<Person, String> ColMaterial;
	    
	    @FXML
	    private TableColumn<Person, Integer> ColCantidad;
	    
	    @FXML
	    private TableColumn<Person, Integer> ColPrecio;
	    
	    // Lista auxiliar para TableView
	    private ObservableList<Person> data = FXCollections.observableArrayList(
	    	    new Person("R00001", "T&C Ring", "Oro de 18k y platino con diamantes brillantes redondos", 5, 3250),
	    	    new Person("R00002", "Else Hoop Ring", "Platino con dos diamantes brillantes redondos", 2, 2125),	
	    	    new Person("R00003", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 2300),
	    	    new Person("C00001", "Victoria Pendant", "Platino con diamantes marquesa", 3, 6500),
	    	    new Person("C00002", "T&C Pendant", "Oro de 18k y platino con diamantes brillantes redondos", 1, 2950)
	    	);
	    
	    // Lista auxiliar para TableHombre
	    private ObservableList<Person> data2 = FXCollections.observableArrayList(
	    	    new Person("P00001", "T&C Ring", "Oro de 18k y platino con diamantes brillantes redondos", 5, 3250),
	    	    new Person("P00002", "Else Hoop Ring", "Platino con dos diamantes brillantes redondos", 2, 2125),	
	    	    new Person("C00001", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 2300),
	    	    new Person("Pe00001", "Victoria Pendant", "Platino con diamantes marquesa", 3, 6500),
	    	    new Person("Pe00002", "T&C Pendant", "Oro de 18k y platino con diamantes brillantes redondos", 1, 2950)
	    	);
	
	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout;
  
    @FXML
    private void initialize() {
    	
    	// Asociamos cada columna del TableView a una propiedad de la clase Person 
    	ColCodigo.setCellValueFactory(new PropertyValueFactory<Person,String>("Codigo"));
    	ColNombre.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
    	ColMaterial.setCellValueFactory(new PropertyValueFactory<Person,String>("Material"));
    	ColCantidad.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Cantidad_Stock"));
    	ColPrecio.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Precio"));
    	
    	 // Para conseguir que la primera columna sea editable (se define a nivel de columna siempre que tabla y columna sean editables) 
    	ColCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
        
        // Se rellena la tabla con objetos de la clase Person
    	TablaLista.setItems(data); 
    	tablaHombre.setItems(data2); 
    }
    
    //Abrimos en otra pantalla nuestro Form Controller
    @FXML
    private void abrirFormulario(ActionEvent event) {    	
    	try {
    		
    		  FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/FormController.fxml"));
    		  //Se carga la venta
    		  Parent root=loader.load();

    		  //crear una escena que viene del padre
    		  Scene scene =new Scene(root);
    		  Stage stage= new Stage();

    		  //Modal hasta que no termine con el formulario no me deja volver a la ventana anterior
    		  stage.initModality(Modality.APPLICATION_MODAL);
    		  stage.setScene(scene);
    		  stage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @FXML
    void abrirTablaHombre(ActionEvent event) {
    	try {
			// Cargamos el archivo Page Form
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/view/TablaHombre.fxml"));
			AnchorPane listadoControles = (AnchorPane) loader.load();

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    
    @FXML
    private void cerrarListado(ActionEvent event) {    	
    	// Se elimina el contenido del nodo central
    	rootLayout.setCenter(null);	
    }

	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
    
}
