package view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Pagination;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Person;

public class AdminTablaController implements Initializable {
	
	@FXML
    private Pagination pagination;

	@FXML
	private TextField filtrarCodigoField;
	// Listener para el campo de textoField
		InvalidationListener textListener = new InvalidationListener() {
			@Override
			public void invalidated(Observable observable) {
				StringProperty sp = (StringProperty) observable;
				System.out.println(observable.toString() + ", " + sp.get());				
			}
		};
	 
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
			new Person("R00003", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5,
					2300),
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
			new Person("SP00001", "Marry Sets",
					"Oro de 18k y platino con diamantes brillantes redondos  y rubis incrustrados", 5, 9250),
			new Person("SP00002", "Wedding pink Sets", "Oro blanco de 18k", 2, 8125),
			new Person("SC00001", "Valentine Sets", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5,
					5300),
			new Person("SPe00001", "Brithday Sets", "Diamantes marquesa", 3, 1500),
			new Person("SPe00002", "Hojarldre Sets", "Platino con esmeraldas", 1, 1950)

	);

	// Lista auxiliar para TablaMujer
	private ObservableList<Person> dataMujer = FXCollections.observableArrayList(
			new Person("R00001", "T&C Ring", "Oro de 18k y platino con diamantes brillantes redondos", 5, 3250),
			new Person("R00002", "Else Hoop Ring", "Platino con dos diamantes brillantes redondos", 2, 2125),
			new Person("R00003", "X Atlas Ring", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5,
					2300),
			new Person("C00001", "Victoria Pendant", "Platino con diamantes marquesa", 3, 6500),
			new Person("C00002", "T&C Pendant", "Oro de 18k y platino con diamantes brillantes redondos", 1, 2950));

	// Lista auxiliar para TableHombre
	private ObservableList<Person> dataHombre = FXCollections.observableArrayList(
			new Person("HP00001", "Man's Pulsera", "Oro de 18k", 2, 3250),
			new Person("HR00001", "Hoop Ring", "Platino", 1, 1125),
			new Person("HC00001", "X Atlas", "Oro nrego de 18k con perlas incustradas", 5, 5300),
			new Person("HPe00001", "Pendant Thor", "Platino con diamantes marquesa", 2, 6500),
			new Person("HPe00002", "Pendant Scporpio", "Diamantes brillantes redondos", 3, 2200));

	// Lista auxiliar para Table para los Niños
	private ObservableList<Person> dataN = FXCollections.observableArrayList(
			new Person("NP00001", "Pulsera TT", "Oro rosa con diamantes pequeños", 5, 1950),
			new Person("NP00002", "Else Snow", "Oro blanco con un bonito diseño de invirno", 2, 1925),
			new Person("NC00001", "Terra Colgat", "Oro y plata", 5, 1200),
			new Person("NPe00001", "Little Magic Pendant", "Platino con diamantes marquesa", 3, 1500),
			new Person("NPe00002", "Junior Senior", "Platino con diamantes brillantes estrellados", 1, 1950));

	// Lista auxiliar para Table para los Sets
	private ObservableList<Person> dataSets = FXCollections.observableArrayList(
			new Person("SP00001", "Marry Sets",
					"Oro de 18k y platino con diamantes brillantes redondos  y rubis incrustrados", 5, 9250),
			new Person("SP00002", "Wedding pink Sets", "Oro blanco de 18k", 2, 8125),
			new Person("SC00001", "Valentine Sets", "Oro rosa de 18k con más de 40 diamantes brillantes redondos", 5,
					5300),
			new Person("SPe00001", "Brithday Sets", "Diamantes marquesa", 3, 1500),
			new Person("SPe00002", "Hojarldre Sets", "Platino con esmeraldas", 1, 1950));

	// Para filtrar por código
	private ObservableList<Person> filtro;
	
	/*
	 * -- INICIALIZADOR--------------------------------------------------------------------------------------------
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		filtro = FXCollections.observableArrayList();
		// TODO Auto-generated method stub
		// Asociamos cada columna del TableView a una propiedad de la clase Person
		ColCodigo.setCellValueFactory(new PropertyValueFactory<Person, String>("Codigo"));
		ColNombre.setCellValueFactory(new PropertyValueFactory<Person, String>("Nombre"));
		ColMaterial.setCellValueFactory(new PropertyValueFactory<Person, String>("Material"));
		ColCantidad.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Cantidad_Stock"));
		ColPrecio.setCellValueFactory(new PropertyValueFactory<Person, Integer>("Precio"));
		

		// Para conseguir que la primera columna sea editable (se define a nivel de
		// columna siempre que tabla y columna sean editables)
		ColCodigo.setCellFactory(TextFieldTableCell.forTableColumn());

		// Se rellena la tabla con objetos de la clase Person
		TablaLista.setItems(data);
		
		
		// Cuando eliminamos un item, da un error
		//------------- LISTENERS -------------------------------------------------------
		//Cuando insertamos algo en el TextField se notifica por consola
		filtrarCodigoField.textProperty().addListener(textListener);
		
		
		// Prueba de listener al añadir un nuevo elemento
		TablaLista.getItems().addListener((Observable observable) -> {
    		System.out.println("Añadido a la tabla -> " + observable);
    	});
		
		
		
		
	}

	// ---- MÉTODOS PARA CAMBIAR LA TABLA DIRECTAMENTE EN LA MISMA VENTANA
	// -------------------------------------------------------
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
	

    @FXML
    void buscarCodigo(KeyEvent event) {
    	String filtroCodigo = this.filtrarCodigoField.getText();
    	// Si esl texto esta vacío
    	if (filtroCodigo.isEmpty()) {
    		this.TablaLista.setItems(data);
    	} else {
    		this.filtro.clear();
    		for(Person p : this.data) {
    			if (p.getCodigo().toLowerCase().contains(filtroCodigo.toLowerCase())) {
    				this.filtro.add(p);
    			}
    		}
    		this.TablaLista.setItems(filtro);
    	}
    }

	/*
	 * ---- MÉTODO QUE ABRE LA GUÍA
	 * -----------------------------------------------------------------------------
	 * ---------------
	 */
	@FXML
	void abrirGuia(ActionEvent event) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Guia.fxml"));
			// Se carga la venta
			Parent root = loader.load();

			// crear una escena que viene del padre
			Scene scene = new Scene(root);
			Stage stage = new Stage();

			// Modal hasta que no termine con el formulario no me deja volver a la ventana
			// anterior
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// --------- MÉTODOS CON CONSECUENCIA EN EL FORMULARIO------------------------------------------------------
	@FXML
	void btnAgregar(ActionEvent event) {
		try {
			// Cargamos la vista
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Formulario.fxml"));
			// Cargamos la ventana
			Parent root = loader.load();
			// Cogemos el controlador
			FormDialogController controlador = loader.getController();
			controlador.inicializarAtributos(data);
			// Creamos la Scene
			Scene scene = new Scene(root);
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setScene(scene);
			stage.showAndWait();

			// Cogemos la persona devuelta
			Person pItem = controlador.getPersona();
			if (pItem != null) {
				// Añadimos el item a nuestro ObservableList
				this.data.add(pItem);
				// En caso de que filtremos el codigo y sea similar se añade al ObservableList filtro
				if (pItem.getCodigo().toLowerCase().contains(this.filtrarCodigoField.getText().toLowerCase())) {
					this.filtro.add(pItem);
				}
				// Refrescamos la tabla
				this.TablaLista.refresh();
			}
		} catch (IOException ex) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setHeaderText(null);
			alert.setTitle("Error al intentar agregar un item.");
			alert.setContentText(ex.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	void btnActualizar(ActionEvent event) {
		Person seleccionado = this.TablaLista.getSelectionModel().getSelectedItem();
		if(seleccionado == null) {
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Debe selecionar un item de la tabla.");
            alert.showAndWait();
		} else {
			try {
				// Cargamos la vista
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Formulario.fxml"));
				// Cargamos la ventana
				Parent root = loader.load();
				// Cogemos el controlador
				FormDialogController controlador = loader.getController();
				controlador.inicializarAtributos(data, seleccionado);
				// Creamos la Scene
				Scene scene = new Scene(root);
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setScene(scene);
				stage.showAndWait();
				
				//Cogemos la persona 
				Person aux = controlador.getPersona();
				if (aux != null) {
					if (aux.getCodigo().toLowerCase().contains(this.filtrarCodigoField.getText().toLowerCase())) {
						this.filtro.add(aux);
					}
					this.TablaLista.refresh();
				}
			} catch (IOException ex) {
				Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error al intentar modificar un item.");
                alert.setContentText(ex.getMessage());
                alert.showAndWait();
			}
		}
	}

	@FXML
	void btnEliminar(ActionEvent event) {
		int selectItem = TablaLista.getSelectionModel().getSelectedIndex();
		//Si seleccionamos una fila, se nos muestra una alerta
		if (selectItem >= 0) {
			//Si se ha selecionado una fila, se muestra un pop up de confirmación
			Alert confirm = new Alert(AlertType.CONFIRMATION);
			confirm.setTitle("Confirmación para eliminar");
			confirm.setContentText("¿Esta seguro de eliminar la fila actual?");
			
			//Si el usuario acepta, entonces se lleva a cabo la acción
			confirm.showAndWait().ifPresent(response -> {
    			if (response == ButtonType.OK) {
    				TablaLista.getItems().remove(selectItem);
    				this.filtro.remove(selectItem);
    		    }
    		});
			//Si no hemos seleccionado nada
		}else {
			// Se nos muestra un error
			Alert errorAlert = new Alert(AlertType.ERROR);
			errorAlert.setTitle("Error al eliminar");
			errorAlert.setHeaderText("Se ha producido un error");
			errorAlert.setContentText("No ha seleccionado ninguna fila o la tabla esta vacía");
			errorAlert.showAndWait();
		}
	}
	
	
	

}
