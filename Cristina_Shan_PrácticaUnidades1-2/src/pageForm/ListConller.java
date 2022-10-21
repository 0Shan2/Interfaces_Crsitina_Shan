package pageForm;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListConller {


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
	    
	    
	    private void initialize() {
	    	
	    	// Asociamos cada columna del TableView a una propiedad de la clase Person 
	    	ColCodigo.setCellValueFactory(new PropertyValueFactory<Person,String>("Código"));
	    	ColNombre.setCellValueFactory(new PropertyValueFactory<Person,String>("Nombre"));
	    	ColMaterial.setCellValueFactory(new PropertyValueFactory<Person,String>("Material"));
	    	ColCantidad.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Cantidad_Stock"));
	    	ColPrecio.setCellValueFactory(new PropertyValueFactory<Person,Integer>("Precio"));
	    	
	    	
	    	
	    	
	    }

	    
	    
}
