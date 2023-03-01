package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Modelo modelo,Vista vista) {
		if(modelo==null) {
			throw new NullPointerException("ERROR: El modelo no puede ser nulo");
		}
		if(vista==null) {
			throw new NullPointerException("ERROR: La vista no puede ser nula");
		}
		this.modelo=modelo;
		this.vista=vista;
		vista.setControlador(this);
	}
	
	
	//	COMENZAR Y TERMINAR 
	public void comenzar() {
		modelo.comenzar();
	}
	public void terminar() {
		modelo.terminar();
	}

	
	//	INSERTAR
	public void insertar(Cliente cliente) {
		modelo.insertar(cliente);
	}
	public void insertar(Turismo turismo) {
		modelo.insertar(turismo);
	}
	public void insertar(Alquiler alquiler) {
		modelo.insertar(alquiler);
	}
	
	
	//	BUSCAR
	public Cliente buscar(Cliente cliente) {
		return modelo.buscar(cliente);
		
	}
	public Turismo buscar(Turismo turismo) {
		return modelo.buscar(turismo);
	}
	public Alquiler buscar(Alquiler alquiler) {
		return modelo.buscar(alquiler);
	}
	
	
	// MODIFICAR Y DEVOLVER
	public void modificar(Cliente cliente, String nombre, String telefono) {
		modelo.modificar(cliente, nombre, telefono);
	}
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) {
		modelo.devolver(alquiler, fechaDevolucion);
	}
	
	
	//BORRAR
	public void borrar(Cliente cliente) {
		modelo.borrar(cliente);
	}
	public void borrar(Turismo turismo) {
		modelo.borrar(turismo);
	}
	public void borrar(Alquiler alquiler) {
		modelo.borrar(alquiler);
	}
	
	
	//	LISTAR
	public List<Cliente> getClientes(){
		return modelo.getClientes();
	}
	public List<Turismo> getTurismos(){
		return modelo.getTurismos();
	}
	public List<Alquiler> getAlquileres(){
		return modelo.getAlquileres();
	}
	
	
	//	LISTAR CON PARAMETROS
	public List<Alquiler> getAlquileres(Cliente cliente){
		return modelo.getAlquileres(cliente);
	}
	public List<Alquiler> getAlquileres(Turismo turismo){
		return modelo.getAlquileres(turismo);
	}
	
}
