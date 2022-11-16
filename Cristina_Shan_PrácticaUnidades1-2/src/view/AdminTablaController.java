package view;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

public class AdminTablaController {


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
	    
	 // Este componente será un diálogo. Campos auxiliares para su gestión
	    private Stage dialogStage;
	    private Person person;
	    private boolean okClicked = false;

	    // Lista auxiliar para TableView
	    private ObservableList<Person> data = FXCollections.observableArrayList(
	    	    new Person("R00001", "T&C Ring", "Oro de 18k y platino con diamantes brillantes redondos", 5, 3250),
	    	    new Person("R00002", "Else Hoop Ring", "Platino con dos diamantes brillantes redondos", 2, 2125),
	    	    new Person("R00003", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 2300),
	    	    new Person("C00001", "Victoria Pendant", "Platino con diamantes marquesa", 3, 6500),
	    	    new Person("C00002", "T&C Pendant", "Oro de 18k y platino con diamantes brillantes redondos", 1, 2950),
	    	    new Person("HP00001", "Man's Pulsera", "Oro de 18k", 2, 3250),
	    	    new Person("HR00001", "Hoop Ring", "Platino", 1, 1125),
	    	    new Person("HC00001", "X Atlas", "Oro nrego de 18k con perlas incustradas", 5, 5300),
	    	    new Person("HPe00001", "Pendant Thor", "Platino con diamantes marquesa", 2, 6500),
	    	    new Person("HPe00002", "Pendant Scporpio", "Diamantes brillantes redondos", 3, 2200),
	    	    new Person("NP00001", "Pulsera TT", "Oro rosa con diamantes pequeños", 5, 1950),
	    	    new Person("NP00002", "Else Snow", "Oro blanco con un bonito diseño de invirno", 2, 1925),
	    	    new Person("NC00001", "Terra Colgat", "Oro y plata", 5, 1200),
	    	    new Person("NPe00001", "Little Magic Pendant", "Platino con diamantes marquesa", 3, 1500),
	    	    new Person("NPe00002", "Junior Senior", "Platino con diamantes brillantes estrellados", 1, 1950),
	    	    new Person("SP00001", "Marry Sets", "Oro de 18k y platino con diamantes brillantes redondos  y rubis incrustrados", 5, 9250),
	    	    new Person("SP00002", "Wedding pink Sets", "Oro blanco de 18k", 2, 8125),
	    	    new Person("SC00001", "Valentine Sets", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 5300),
	    	    new Person("SPe00001", "Brithday Sets", "Diamantes marquesa", 3, 1500),
	    	    new Person("SPe00002", "Hojarldre Sets", "Platino con esmeraldas", 1, 1950)

	    	);

	    //Lista auxiliar para TablaMujer
	    private ObservableList<Person> dataMujer = FXCollections.observableArrayList(
	    	    new Person("R00001", "T&C Ring", "Oro de 18k y platino con diamantes brillantes redondos", 5, 3250),
	    	    new Person("R00002", "Else Hoop Ring", "Platino con dos diamantes brillantes redondos", 2, 2125),
	    	    new Person("R00003", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 2300),
	    	    new Person("C00001", "Victoria Pendant", "Platino con diamantes marquesa", 3, 6500),
	    	    new Person("C00002", "T&C Pendant", "Oro de 18k y platino con diamantes brillantes redondos", 1, 2950)
       );

	    // Lista auxiliar para TableHombre
	    private ObservableList<Person> dataHombre = FXCollections.observableArrayList(
	    	    new Person("HP00001", "Man's Pulsera", "Oro de 18k", 2, 3250),
	    	    new Person("HR00001", "Hoop Ring", "Platino", 1, 1125),
	    	    new Person("HC00001", "X Atlas", "Oro nrego de 18k con perlas incustradas", 5, 5300),
	    	    new Person("HPe00001", "Pendant Thor", "Platino con diamantes marquesa", 2, 6500),
	    	    new Person("HPe00002", "Pendant Scporpio", "Diamantes brillantes redondos", 3, 2200)
	    	);

	 // Lista auxiliar para Table para los Niños
	    private ObservableList<Person> dataN = FXCollections.observableArrayList(
	    	    new Person("NP00001", "Pulsera TT", "Oro rosa con diamantes pequeños", 5, 1950),
	    	    new Person("NP00002", "Else Snow", "Oro blanco con un bonito diseño de invirno", 2, 1925),
	    	    new Person("NC00001", "Terra Colgat", "Oro y plata", 5, 1200),
	    	    new Person("NPe00001", "Little Magic Pendant", "Platino con diamantes marquesa", 3, 1500),
	    	    new Person("NPe00002", "Junior Senior", "Platino con diamantes brillantes estrellados", 1, 1950)
	    	);

	 // Lista auxiliar para Table para los Sets
	    private ObservableList<Person> dataSets = FXCollections.observableArrayList(
	    	    new Person("SP00001", "Marry Sets", "Oro de 18k y platino con diamantes brillantes redondos  y rubis incrustrados", 5, 9250),
	    	    new Person("SP00002", "Wedding pink Sets", "Oro blanco de 18k", 2, 8125),
	    	    new Person("SC00001", "Valentine Sets", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5, 5300),
	    	    new Person("SPe00001", "Brithday Sets", "Diamantes marquesa", 3, 1500),
	    	    new Person("SPe00002", "Hojarldre Sets", "Platino con esmeraldas", 1, 1950)
	    	);



	// Pantalla principal en la que se añade o quita contenido
	private BorderPane rootLayout;
	

	/* -- INICIALIZADOR -------------------------------------------------------------------------------------------- */
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
    }


    @FXML
    void abrirlista(ActionEvent event) {
    	TablaLista.setItems(data);
    }

    @FXML
    void abrirTablaMujer(ActionEvent event) {
    	TablaLista.setItems(dataMujer);
    }

    @FXML
    void abrirTablaHombre(ActionEvent event) {
    	TablaLista.setItems(dataHombre);
    }

    @FXML
    void abrirTablaN(ActionEvent event) {
    	TablaLista.setItems(dataN);
    }

    @FXML
    void abrirTablaSets(ActionEvent event) {
    	TablaLista.setItems(dataSets);
    }
    
    //Rellenamos los datos para añadirlos
    public void setPerson(Person person) {
    	this.person = person;
    	ColCodigo.setText(person.getCodigo());
    	ColNombre.setText(person.getNombre());
    	ColMaterial.setText(person.getMaterial());
    	ColCantidad.setText(Integer.toString(person.getCantidad_Stock()));
    	ColPrecio.setText(Integer.toString(person.getPrecio()));
    }
    
    ///* -- ABIRMOS EL FORMULARIO -------------------------------------------------------------------------------------------- */
    @FXML
    private void abrirFormulario(ActionEvent event) {
    	try {

    		  FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Formulario.fxml"));
    		  //Se carga la venta
    		  Parent root=loader.load();

    		  //crear una escena que viene del padre
    		  Scene scene =new Scene(root);
    		  Stage stage= new Stage();

    		  //Modal hasta que no termine con el formulario no me deja volver a la ventana anterior
    		  stage.initModality(Modality.APPLICATION_MODAL);
    		  stage.setScene(scene);
    		  stage.setResizable(false);
    		  stage.showAndWait();

		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /* ---- ABRE LA GUÍA -------------------------------------------------------------------------------------------- */
    @FXML
    void abrirGuia(ActionEvent event) {
    	try {

  		  FXMLLoader loader=new FXMLLoader(getClass().getResource("/view/Guia.fxml"));
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
    
    
    //---------- ABIRIR  INICIO -------------------------------------------------------------------
    @FXML
    void abrirInicio(ActionEvent event) {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/InicioStore.fxml"));
			// Se carga la venta
			Parent root = loader.load();

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.WINDOW_MODAL);
			stage.setResizable(false);
			stage.setScene(scene);
			stage.showAndWait();

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
	
	//----------------------------------------------------------------------------------------------------
	 @FXML
	    void eliminarForm(ActionEvent event) {

	    }

	    @FXML
	    void openForm(ActionEvent event) {

	    }

	    @FXML
	    void updateForm(ActionEvent event) {

	    }

}
