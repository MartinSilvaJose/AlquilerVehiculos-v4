package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

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

	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		if(turismo==null) {
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		if(coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
		coleccionTurismos.add(turismo);
	}
	public Turismo buscar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		for(Turismo i:coleccionTurismos) {
			if(turismo.equals(i)) {
				return i;
			}

		}
		return null;
	}
	public void borrar(Turismo turismo) throws OperationNotSupportedException {
		if(turismo==null) {
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		if(!coleccionTurismos.contains(turismo)) {
			throw new OperationNotSupportedException( "ERROR: No existe ningún turismo con esa matrícula.");
		}
		coleccionTurismos.remove(turismo);
	}
}
