package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

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
	
	public void comprobarAlquiler(Cliente cliente,Turismo turismo,LocalDate fechaAlquiler)throws OperationNotSupportedException {
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
					throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
				}
				if(i.getFechaDevolucion().isAfter(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
				if(i.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
			}
			if(i.getTurismo().equals(turismo)) {
				if(i.getFechaDevolucion()==null) {
					throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
				}
				if(i.getFechaDevolucion().isEqual(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El turismo tiene un alquiler posterior.");
				}
				if(i.getFechaDevolucion().isAfter(fechaAlquiler)) {
					throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
				}
			}


		}
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		comprobarAlquiler(alquiler.getCliente(),alquiler.getTurismo(),alquiler.getFechaAlquiler());
		coleccionAlquileres.add(alquiler);
	}
	
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		}
		if(fechaDevolucion==null) {
			throw new OperationNotSupportedException("ERROR:No puedes confirmar una devolución si la fecha es nula");
		}
		if(!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		alquiler.devolver(fechaDevolucion);
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		for(Alquiler i:coleccionAlquileres) {
			if(i.equals(alquiler)) {
				return alquiler;
			}
		}
		return null;
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if(!coleccionAlquileres.contains(alquiler)) {
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
			coleccionAlquileres.remove(alquiler);
		
	}
}
