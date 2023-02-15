package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.LinkedHashSet;
import java.util.Set;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Turismos {
	
	
	//DECLARACION
	
	private Set<Turismo> coleccionTurismos;
	
	
	//CONSTRUCTORES
	
	public Turismos() {
		coleccionTurismos=new LinkedHashSet<>();
	}
	
	
	//METODOS DE CLASE
	
	public Set<Turismo> get(){
		return coleccionTurismos;
	}
	
	public int getCantidad() {
		return coleccionTurismos.size();
	}

	public void insertar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puedes insertar un turismo nulo");
		}
		if(coleccionTurismos.add(turismo)==false) {
			throw new IllegalArgumentException("ERROR:El turismo que desea insertar ya existe.");
		}
		coleccionTurismos.add(turismo);
	}
	public Turismo buscar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puede buscar un turismo nulo.");
		}
		for(Turismo i:coleccionTurismos) {
			turismo.equals(i);
			return turismo;
		}
		return null;
	}
	public void borrar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puede borrar un turismo nulo.");
		}
		if(coleccionTurismos.remove(turismo)==false) {
			throw new IllegalArgumentException("ERROR:El turismo que desea borrar no existe.");
		}
		coleccionTurismos.remove(turismo);
	}
}
