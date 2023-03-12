package org.iesalandalus.programacion.alquilervehiculos.vista;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.*;

public class Vista {
	
	//	DECLARACION
	private Controlador controlador;
	
	//	SETTER	
	public void setControlador(Controlador controlador) {
		if(controlador==null) {
			throw new NullPointerException("No puedes pasar un controlador nulo.");
		}
		this.controlador=controlador;
	}
	
	
	//	COMENZAR Y TERMINAR
	public void comenzar() {
		Consola.mostrarCabecera();
		Consola.mostrarMenu();
		ejecutar(Consola.elegirOpcion());
	}
	public void terminar() {
		controlador.terminar();
	}
	
	
	//	EJECUTAR	
	public void ejecutar(Opcion opcion) {
		switch(opcion) {
		case SALIR:
			System.exit(0);
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			break;
		case INSERTAR_TURISMO:
			insertarTurismo();
			break;
		case INSERTAR_ALQUILER:
			insertarAlquiler();
			break;
		case BUSCAR_CLIENTE:
			buscarCliente();
			break;
		case BUSCAR_TURISMO:
			buscarTurismo();
			break;
		case BUSCAR_ALQUILER:
			buscarAlquiler();;
			break;
		case MODIFICAR_CLIENTE:
			modificarCliente();
			break;
		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			break;
		case BORRAR_CLIENTE:
			borrarCliente();
			break;
		case BORRAR_TURISMO:
			borrarTurismo();
			break;
		case BORRAR_ALQUILER:
			borrarAlquiler();
			break;
		case LISTAR_CLIENTES:
			listarClientes();
			break;
		case LISTAR_TURISMOS:
			listarTurismos();
			break;
		case LISTAR_ALQUILERES:
			listarAlquileres();
			break;
		case LISTAR_ALQUILERES_CLIENTE:
			listarAlquileresCliente();
			break;
		case LISTAR_ALQUILERES_TURISMO:
			listarAlquileresTurismo();
			break;
		}
				
	}
	
	
	//	INSERTAR 
	public void insertarCliente() {
		Consola.mostrarCabecera();
		try {
			controlador.insertar(Consola.leerCliente());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
	public void insertarTurismo() {
		Consola.mostrarCabecera();
		try {
			controlador.insertar(Consola.leerTurismo());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
	public void insertarAlquiler() {
		Consola.mostrarCabecera();
		try {
			controlador.insertar(Consola.leerAlquiler());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
	
	//	BUSCAR
	public void buscarCliente() {
		Consola.mostrarCabecera();
		if(controlador.buscar(Consola.leerClienteDni())==null) {
			System.out.println("ERROR:El cliente que busca no existe");
		}
		else {
			System.out.println(controlador.buscar(Consola.leerClienteDni()));
		}

	}
	public void buscarTurismo() {
		Consola.mostrarCabecera();
		if(controlador.buscar(Consola.leerTurismoMatricula())==null) {
			System.out.println("ERROR:El turismo que busca no existe");
		}
		else {
			System.out.println(controlador.buscar(Consola.leerTurismoMatricula()));

		}

	}
	public void buscarAlquiler() {
		Consola.mostrarCabecera();
		if(controlador.buscar(Consola.leerAlquiler())==null) {
			System.out.println("ERROR:El Alquiler que busca no existe");
		}
		else {
			System.out.println(controlador.buscar(Consola.leerAlquiler()));
		}
	}
	
	
	//	MODIFICAR Y DEVOLVER
	public void modificarCliente() {
		Consola.mostrarCabecera();
		try {
			controlador.modificar(Consola.leerCliente(),Consola.leerNombre(),Consola.leerTelefono());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	public void devolverAlquiler() {
		Consola.mostrarCabecera();
		try {
			controlador.devolver(Consola.leerAlquiler(),Consola.leerFechaDevolucion());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//	BORRAR
	public void borrarCliente() {
		Consola.mostrarCabecera();
		try {
			controlador.borrar(controlador.buscar(Consola.leerClienteDni()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
	public void borrarTurismo() {
		Consola.mostrarCabecera();
		try {
			controlador.borrar(controlador.buscar(Consola.leerTurismoMatricula()));
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}

	}
	public void borrarAlquiler() {
		Consola.mostrarCabecera();
		try {
			controlador.borrar(Consola.leerAlquiler());
		} catch (IllegalArgumentException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch (OperationNotSupportedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	//	LISTAR
	public void listarClientes() {
		Consola.mostrarCabecera();
		System.out.println(controlador.getClientes());

	}
	public void listarTurismos() {
		Consola.mostrarCabecera();
		System.out.println(controlador.getTurismos());
	}
	public void listarAlquileres() {
		Consola.mostrarCabecera();
		System.out.println(controlador.getAlquileres());
	}
	
	
	//	LISTAR CON PARAMETROS
	public void listarAlquileresCliente() {
		Consola.mostrarCabecera();
		try {
			controlador.getAlquileres(Consola.leerCliente());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void listarAlquileresTurismo() {
		Consola.mostrarCabecera();
		try {
			controlador.getAlquileres(Consola.leerTurismo());
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}
	}
}
