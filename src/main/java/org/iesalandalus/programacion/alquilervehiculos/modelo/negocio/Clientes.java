package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.ArrayList;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Clientes {
	
	
	//DECLARACION
	
	private List<Cliente> coleccionClientes;
	
	
	//CONSTRUCTORES
	
	public Clientes() {
		coleccionClientes= new ArrayList<>();
	}
	
	
	//METODOS DE CLASE
	
	public List<Cliente> get() {
		List <Cliente> copia=new ArrayList<>();
		for(Cliente i:coleccionClientes) {
			copia.add(i);
		}
		return copia;
	}
	
	public int getCantidad() {
		return coleccionClientes.size();
 
	}
	
	public void insertar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if(coleccionClientes.contains(cliente)) {
			throw new IllegalArgumentException("ERROR:El cliente ya se encuentra en la lista,");
		}
		coleccionClientes.add(cliente);
	}
	
	public Cliente buscar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo");
		}
		for(Cliente i:coleccionClientes) {
			if(cliente.equals(i)) {
				return i;
			}
		}
		return null;
	}
	
	public void borrar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo");
		}
		if(!coleccionClientes.contains(cliente)) {
			throw new IllegalArgumentException("ERROR:El cliente que deseas borrar no existe.");
		}
		coleccionClientes.remove(cliente);
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) {
		if(cliente==null) {
			throw new NullPointerException("ERROR:El cliente que quiere modificar es nulo.");
		}

		if(buscar(cliente)==null) {
			throw new IllegalArgumentException("ERROR: El cliente que desea modificar no existe.");
		}
		buscar(cliente).setNombre(nombre);
		buscar(cliente).setTelefono(telefono);
		
	}
	
}
