package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cliente {
	private String ER_NOMBRE="[a-zA-Z]+[ ]";
	private String ER_DNI="([0-9]{8})([a-zA-Z])";
	private String ER_TELEFONO="[0-9]{9}";
	private String nombre,dni,telefono;
	
	
	//CONSTRUCTORES
	
	public Cliente(String nombre,String dni,String telefono) {
		setNombre(nombre);
		setTelefono(telefono);
		setDni(dni);
	}
	
	public Cliente(Cliente c) {
		setNombre(c.getNombre());
		setTelefono(c.getTelefono());
		setDni(c.getDni());
	}
	
	
	//NOMBRE
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre==null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}
		if(nombre.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El nombre no puede estar vacio.");
		}
		if(!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no cumple el formato deseado, debe de empezar por una letra del abecedario");
		}
		
		String [] palabras = nombre.trim().split("\\s");
		for(int i=0;i<nombre.length();i++) {
			String palabra=palabras[i].trim();
			palabra=palabra.toUpperCase().charAt(0)+"";
			nombre=palabra+" ";
		}
		this.nombre = nombre;
	}
	
	
	//DNI
	
	public String getDni() {
		
		return dni;
	}
	private void setDni(String dni) {

		
		if(dni==null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if(dni.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El DNI no puede estar vacio.");
		}
		if(dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no cumple el formato deseado.");
		}
		if(!comprobarLetraDni(dni)) {
			throw new IllegalArgumentException("ERROR: El DNI no es válido.");
		}

		this.dni = dni;
		
	}
	
	
	//TELEFONO
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		if(telefono==null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}
		if(telefono.trim().isEmpty()) {
			throw new IllegalArgumentException("ERROR: El teléfono no puede estar vacio.");
		}
		if(telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("ERROR: El teléfono no cumple el formato deseado.");
		}
		this.telefono = telefono;
	}
	
	
	//METODO DE CLASE
	
	private boolean comprobarLetraDni(String dni) {
		Pattern pat=Pattern.compile(ER_DNI);
		Matcher mat=pat.matcher(dni);
		
		String [] letraDni= {"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
		int calculo=(Integer.parseInt(mat.group(1)))%23;
		
		if(letraDni[calculo].equals(mat.group(2))) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//EQUALS & HASCODE
	
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dni, other.dni);
	}

	@Override
	public String toString() {
		return nombre + ", " + dni + ", " + telefono + ".";
	}
	
	
}
