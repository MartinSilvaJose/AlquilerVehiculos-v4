package org.iesalandalus.programacion.alquilervehiculos.modelo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.*;
public class Modelo {
	
	//DECLARACION
	
	private Clientes clientes;
	private Alquileres alquileres;
	private Turismos turismos;
	
	public Modelo(){
		
	}
	
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
		
		clientes.insertar(new Cliente(cliente));
	}
	
	public void insertar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: no puedes insertar un turismo nulo.");
		}
	
		turismos.insertar(new Turismo(turismo));
	}
	
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: no puedes insertar un alquiler nulo.");
		}
		
		alquileres.insertar(new Alquiler(alquiler));
	}
	
	
	//BUSCAR
	
	public Cliente buscar(Cliente cliente) {
		if(cliente==null) {
			throw new NullPointerException("ERROR: no puedes buscar un cliente nulo.");
		}
		
		cliente=clientes.buscar(cliente);
		return new Cliente(cliente);
	}
	
	public Turismo buscar(Turismo turismo) {
		if(turismo==null) {
			throw new NullPointerException("ERROR: no puedes buscar un turismo nulo.");
		}
		turismo=turismos.buscar(turismo=new Turismo(turismo));
		return turismo;
	}
	
	public Alquiler buscar(Alquiler alquiler) {
		if(alquiler==null) {
			throw new NullPointerException("ERROR: no puedes buscar un alquiler nulo.");
		}
		alquiler=new Alquiler(alquileres.buscar(alquiler=new Alquiler(alquiler)));
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
		List<Alquiler> alquilerPorCliente=alquileres.get(cliente);
		for(Alquiler i:alquilerPorCliente) {
			alquilerPorCliente.remove(i);
		}
		clientes.borrar(cliente);
	}
	
	public void borrar(Turismo turismo) {
		List<Alquiler> alquilerPorTurismo=alquileres.get(turismo);
		for(Alquiler i:alquilerPorTurismo) {
			alquilerPorTurismo.remove(i);
		}
		turismos.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) {
		alquileres.borrar(alquiler);
	}
	
	
	//GET
	
	public List<Cliente> getClientes(){
		List<Cliente> copiaClientes = new ArrayList<>(clientes.get());
		return copiaClientes;
		
	}
	
	public List<Turismo> getTurismos(){
		List<Turismo> copiaTurismos=new ArrayList<>(turismos.get());
		return copiaTurismos;
	}
	
	public List<Alquiler> getAlquileres(){
		List<Alquiler> copiaAlquileres=new ArrayList<>(alquileres.get());
		return copiaAlquileres;
	}
	
	//GET CON PARAMETROS
	public List<Alquiler> getAlquileres(Cliente cliente){
		List<Alquiler> copiaAlquileresPorCliente=new ArrayList<>(alquileres.get(cliente));
		return copiaAlquileresPorCliente;
	}
	
	public List<Alquiler> getAlquileres(Turismo turismo){
		List<Alquiler> copiaAlquileresPorTurismo=new ArrayList<>(alquileres.get(turismo));
		return copiaAlquileresPorTurismo;
	}
}
