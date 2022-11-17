package model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

//Clase que tendra los atributos que queremos ver en TableList
public class Person {

	private final SimpleStringProperty Codigo;
	private final SimpleStringProperty Nombre;
	private final SimpleStringProperty Material;
	private final SimpleIntegerProperty Cantidad_Stock;
	private final SimpleIntegerProperty Precio;

	
	public Person(String codigo, String nombre, String material,
			Integer cantidad_Stock, Integer precio) {
		super();
		Codigo = new SimpleStringProperty(codigo);
		Nombre = new SimpleStringProperty(nombre);
		Material = new SimpleStringProperty(material);
		Cantidad_Stock = new SimpleIntegerProperty(cantidad_Stock);
		Precio = new SimpleIntegerProperty(precio);
	}
	
	

	public String getCodigo() {
		return Codigo.get();
	}

	public void setCodigo(String fCodigo) {
		Codigo.set(fCodigo);
	}


	public String getNombre() {
		return Nombre.get();
	}

	public void setNombre(String fNombre) {
		Nombre.set(fNombre);
	}

	public String getMaterial() {
		return Material.get();
	}

	public void setMaterial(String fMaterial) {
		Material.set(fMaterial);
	}


	public int getCantidad_Stock() {
		return Cantidad_Stock.get();
	}

	public int setCantidad_Stock(int fCantidad) {
		Cantidad_Stock.set(fCantidad);
		return fCantidad;
	}

	public int getPrecio() {
		return Precio.get();
	}

	public int setPrecio(int fPrecio) {
		Precio.set(fPrecio);
		return fPrecio;
	}


	public void add(Person nuevoItem) {
		// TODO Auto-generated method stub
		
	}












}
