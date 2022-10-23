package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class ListController {


	    @FXML
	    private TableView<Person> TablaLista;
	    
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
	    
	    private void initialize() {
	    	
	    	// Asociamos cada columna del TableView a una propiedad de la clase Person 
	    	ColCodigo.setCellValueFactory(new PropertyValueFactory<Person,String>("Código"));
	    	ColNombre.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
	    	ColMaterial.setCellValueFactory(new PropertyValueFactory<Person,String>("Material"));
	    	ColCantidad.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Cantidad_Stock"));
	    	ColPrecio.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Precio"));
	    	
	    	 // Para conseguir que la primera columna sea editable (se define a nivel de columna siempre que tabla y columna sean editables) 
	    	ColCodigo.setCellFactory(TextFieldTableCell.forTableColumn());
	        
	        // Se rellena la tabla con objetos de la clase Person
	    	TablaLista.setItems(data); 
	    	
	    	
	    	
	    }

	    
	    
}
