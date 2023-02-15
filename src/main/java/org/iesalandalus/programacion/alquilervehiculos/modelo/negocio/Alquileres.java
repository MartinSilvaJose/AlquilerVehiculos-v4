package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
public class Alquileres {

	
	//DECLARACION
	
	private Set<Alquiler> coleccionAlquileres;
	
	
	//CONSTRUCTORES
	
	public Alquileres() {
		coleccionAlquileres= new LinkedHashSet<>();
	}
	
	
	//METODOS DE CLASE
	
	public Set<Alquiler> get(){
		return coleccionAlquileres;
	}
	
	public Set<Alquiler> get(Cliente cliente){
		if(cliente==null) {
			throw new NullPointerException("ERROR: El cliente del cual deseas obtener una lista no puede ser nulo.");
		}
		Set<Alquiler> alquilerPorCliente=new LinkedHashSet<>();
		for(Alquiler i:coleccionAlquileres) {
			if(i.getCliente().equals(cliente));
			alquilerPorCliente.add(i);
		}
		return alquilerPorCliente;
	}
	
	public Set<Alquiler> get(Turismo turismo){
		if(turismo==null) {
			throw new NullPointerException("ERROR:El turismo del cual desea obtener un lista no puede ser nulo.");
		}
		Set<Alquiler> alquilerPorTurismo=new LinkedHashSet<>();
		for(Alquiler i:coleccionAlquileres) {
			if(i.getTurismo().equals(turismo)) {
				alquilerPorTurismo.add(i);
			}
		}
		return alquilerPorTurismo;
	}
	
	public int getCantidad() {
		return coleccionAlquileres.size();

	}
	
	public void comprobarAlquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: No puede comprobar el alquiler con un cliente nulo.");
		}
		if(turismo==null) {
			throw new NullPointerException("ERROR: No puede comprobar el alquiler con un turismo nulo.");
		}
		if(fechaAlquiler==null) {
			throw new NullPointerException("ERROR: No puede comprobar el alquiler con una fecha de alquiler nula.");
		}
		
		for(Alquiler i:coleccionAlquileres) {
			if(i.getCliente().equals(cliente)) {
				if(i.getFechaDevolucion()==null) {
					throw new IllegalArgumentException("ERROR: Hay una fecha de devolucion pendiende de este cliente.");
				}
			}
			if(i.getTurismo().equals(turismo)) {
				if(i.getFechaDevolucion()==null) {
					throw new IllegalArgumentException("ERROR: Hay una fecha de devolucion pendiende de este turismo.");
				}
			}
			if(i.getFechaDevolucion().isAfter(fechaAlquiler)) {
				throw new IllegalArgumentException("ERROR: Hay una fecha de devolucion posterior a la fecha de Alquiler.");
				
			}
		}
	}
	
	public void insertar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No puedes insertar un alquiler nulo");
		}
		comprobarAlquiler(alquiler.getCliente(),alquiler.getTurismo(),alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}
	
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No puedes confirmar una devolución si el alquiler es nulo.");
		}
		if(fechaDevolucion==null) {
			throw new NullPointerException("ERROR:No puedes confirmar una devolución si la fecha es nula");
		}
		boolean devolucionAsignada=false;
		for(Alquiler i:coleccionAlquileres) {
			if(i.equals(alquiler)) {
				i.setFechaDevolucion(fechaDevolucion);
				devolucionAsignada=true;
			}
		}
		if(devolucionAsignada=false) {
			throw new IllegalArgumentException("ERROR:La devolución no se ha podido realizar porque este alquiler no se encuentra en la lista.");
		}
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No se puede buscar un cliente nulo.");
		}
		boolean alquilerEncontrado=false;
		for(Alquiler i:coleccionAlquileres) {
			if(i.equals(alquiler)) {
				alquilerEncontrado=true;
			}
		}
		if(alquilerEncontrado=false) {
			throw new IllegalArgumentException("ERROR:El alquiler no se encuentra en la lista de Alquileres");	
		}
		return alquiler;
	}
	
	public void borrar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No se puede borrar un cliente nulo.");
		}
		boolean alquilerEncontrado=false;
		for(Alquiler i:coleccionAlquileres) {
			if(i.equals(alquiler)) {
				coleccionAlquileres.remove(alquiler);
				alquilerEncontrado=true;
			}
			if(alquilerEncontrado=false) {
				throw new IllegalArgumentException("ERROR:No se borrar el cliente ya que no existe en la lista.");
			}
		}
		
	}
}
