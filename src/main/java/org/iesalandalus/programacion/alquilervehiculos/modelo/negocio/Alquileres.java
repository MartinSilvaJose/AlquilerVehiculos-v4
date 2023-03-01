package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.*;
public class Alquileres {

	
	//DECLARACION
	
	private List<Alquiler> coleccionAlquileres;
	
	
	//CONSTRUCTORES
	
	public Alquileres() {
		coleccionAlquileres= new ArrayList<>();
	}
	
	
	//METODOS DE CLASE
	
	public List<Alquiler> get(){
		List<Alquiler> copia=new ArrayList<>();
		for(Alquiler i:coleccionAlquileres) {
			copia.add(i);
		}
		return copia;
	}
	
	public List<Alquiler> get(Cliente cliente){
		if(cliente==null) {
			throw new NullPointerException("ERROR: El cliente del cual deseas obtener una lista no puede ser nulo.");
		}
		List<Alquiler> alquilerPorCliente=new ArrayList<>();
		for(Alquiler i:coleccionAlquileres) {
			if(i.getCliente().equals(cliente));
				alquilerPorCliente.add(i);
		}
		return alquilerPorCliente;
	}
	
	public List<Alquiler> get(Turismo turismo){
		if(turismo==null) {
			throw new NullPointerException("ERROR:El turismo del cual desea obtener un lista no puede ser nulo.");
		}
		List<Alquiler> alquilerPorTurismo=new ArrayList<>();
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
			if(i.getFechaDevolucion().isBefore(fechaAlquiler)) {
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
		if(!coleccionAlquileres.contains(alquiler)) {
			throw new IllegalArgumentException("ERROR:La devolución no se ha podido realizar porque este alquiler no se encuentra en la lista.");
		}
		buscar(alquiler).setFechaDevolucion(fechaDevolucion);
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No se puede buscar un cliente nulo.");
		}
		for(Alquiler i:coleccionAlquileres) {
			if(i.equals(alquiler)) {
				return alquiler;
			}
		}
		return null;
	}
	
	public void borrar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR:No se puede borrar un cliente nulo.");
		}
		if(!coleccionAlquileres.contains(alquiler)) {
			throw new IllegalArgumentException("ERROR:No se borrar el cliente ya que no existe en la lista.");
		}
			coleccionAlquileres.add(alquiler);
		
	}
}
