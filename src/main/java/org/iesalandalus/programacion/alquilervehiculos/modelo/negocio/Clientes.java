package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;
import java.util.LinkedHashSet;
import java.util.Set;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;

public class Clientes {
	
	
	//DECLARACION
	
	public Set<Cliente> coleccionClientes;
	
	
	//CONSTRUCTORES
	
	public Clientes() {
		coleccionClientes= new LinkedHashSet<>();
	}
	
	
	//METODOS DE CLASE
	
	public Set<Cliente> get() {
		Set<Cliente> copiaClientes = new LinkedHashSet<>(coleccionClientes.size());
		for(Cliente i:coleccionClientes) {
			copiaClientes.add(i);
		}
		return copiaClientes;
	}
	
	public int getCantidad() {
		int cantidad=coleccionClientes.size();
		return cantidad;
	}
	
	public void insertar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}
		if(coleccionClientes.add(cliente)==false) {
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
				return cliente;
			}
		}
		return null;
	}
	
	public void borrar(Cliente cliente) {
		if(coleccionClientes.remove(cliente)==false) {
			throw new IllegalArgumentException("ERROR:El cliente que deseas borrar no existe.");
		}
		coleccionClientes.remove(cliente);
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) {
		if(cliente==null) {
			throw new NullPointerException("ERROR:El cliente que quiere modificar es nulo.");
		}
		if(nombre==null) {//No creo que sea necesario porque lo mandaré al setter y de allí me mandaría la excepcción, pero de esta manera sabre diferenciar donde me falla diferenciando ambas excepciones.
			throw new NullPointerException("ERROR:No puede modificar por un nombre nulo.");
		}
		if(telefono==null) {//No creo que sea necesario porque lo mandaré al setter y de allí me mandaría la excepcción, pero de esta manera sabre diferenciar donde me falla diferenciando ambas excepciones.
			throw new NullPointerException("ERROR:No puede modificar por un telefono nulo");
		}
		if(buscar(cliente)==null) {
			throw new IllegalArgumentException("ERROR: El cliente que desea modificar no existe.");
		}
		Cliente clienteModificado=buscar(cliente);
		clienteModificado.setNombre(nombre);
		clienteModificado.setTelefono(telefono);
		coleccionClientes.remove(cliente);
		cliente=clienteModificado;
		coleccionClientes.add(cliente);
	}
	
}
