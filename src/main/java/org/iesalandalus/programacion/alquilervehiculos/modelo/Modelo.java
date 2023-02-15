package org.iesalandalus.programacion.alquilervehiculos.modelo;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.*;
public class Modelo {
	
	//DECLARACION
	
	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;
	
	
	//COMENZAR & TERMINAR
	
	public void comenzar() {
		clientes= new Clientes();
		alquileres=new Alquileres();
		turismos=new Turismos();
	}
	
	public void terminar() {
		System.out.println("El modelo ha terminado");
	}
	
	
	//INSERTAR
	
	public void insertar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: no puedes insertar un cliente nulo.");
		}
		cliente=new Cliente(cliente);
		clientes.insertar(cliente);
	}
	
	public void insertar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: no puedes insertar un turismo nulo.");
		}
		turismo=new Turismo(turismo);
		turismos.insertar(turismo);
	}
	
	public void insertar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: no puedes insertar un alquiler nulo.");
		}
		alquiler=new Alquiler(alquiler);
		alquileres.insertar(alquiler);
	}
	
	
	//BUSCAR
	
	public Cliente buscar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: no puedes buscar un cliente nulo.");
		}
		cliente=new Cliente(cliente);
		clientes.buscar(cliente);
		return cliente;
	}
	
	public Turismo buscar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: no puedes buscar un turismo nulo.");
		}
		turismo=new Turismo(turismo);
		turismos.buscar(turismo);
		return turismo;
	}
	public Alquiler buscar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: no puedes buscar un alquiler nulo.");
		}
		alquiler=new Alquiler(alquiler);
		alquileres.buscar(alquiler);
		return alquiler;
	}
	
	
	//MODIFICAR & DEVOLVER
	
	public void  modificar(Cliente cliente,String nombre,String telefono) {
		clientes.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) {
		alquileres.devolver(alquiler, fechaDevolucion);
	}
	
	
	//BORRAR
	
	public void borrar(Cliente cliente) {
		clientes.borrar(cliente);
	}
	
	public void borrar(Turismo turismo) {
		turismos.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) {
		alquileres.borrar(alquiler);
	}
	
	
	//get
	
	public Set<Cliente> getClientes(){
		Set<Cliente> copiaClientes = new LinkedHashSet<>(clientes.get().size());
		for(Cliente i:clientes.get()) {
			copiaClientes.add(i);
		}
		return copiaClientes;
	}
	
	public Set<Turismo> getTurismos(){
		Set<Turismo> copiaTurismos=new LinkedHashSet<>(turismos.get().size());
		for(Turismo i:turismos.get()) {
			copiaTurismos.add(i);
		}
		return copiaTurismos;
	}
	
	public Set<Alquiler> getAlquileres(){
		Set<Alquiler> copiaAlquileres=new LinkedHashSet<>(alquileres.get().size());
		for(Alquiler i:alquileres.get()) {
			copiaAlquileres.add(i);
		}
		return copiaAlquileres;
	}
}
