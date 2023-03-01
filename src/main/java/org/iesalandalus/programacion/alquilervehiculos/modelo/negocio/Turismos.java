package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Turismos {
	
	
	//DECLARACION
	
	private List<Turismo> coleccionTurismos;
	
	
	//CONSTRUCTORES
	
	public Turismos() {
		coleccionTurismos=new ArrayList<>();
	}
	
	
	//METODOS DE CLASE
	
	public List<Turismo> get(){
		List<Turismo> copia=new ArrayList<>();
		for(Turismo i:coleccionTurismos) {
			copia.add(i);
		}
		return copia;
	}
	
	public int getCantidad() {
		return coleccionTurismos.size();
	}

	public void insertar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puedes insertar un turismo nulo");
		}
		if(coleccionTurismos.contains(turismo)) {
			throw new IllegalArgumentException("ERROR:El turismo que desea insertar ya existe.");
		}
		coleccionTurismos.add(turismo);
	}
	public Turismo buscar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puede buscar un turismo nulo.");
		}
		for(Turismo i:coleccionTurismos) {
			if(turismo.equals(i)) {
				return turismo;
			}

		}
		return null;
	}
	public void borrar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR:No puede borrar un turismo nulo.");
		}
		if(!coleccionTurismos.contains(turismo)) {
			throw new IllegalArgumentException("ERROR:El turismo que desea borrar no existe.");
		}
		coleccionTurismos.remove(turismo);
	}
}
