package org.iesalandalus.programacion.alquilervehiculos.vista;
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
		controlador.comenzar();
		Consola.mostrarCabecera();
		Consola.mostrarMenu();
		Consola.elegirOpcion();
	}
	public void terminar() {
		controlador.terminar();
	}
	
	
	//	EJECUTAR	
	public void ejecutar(Opcion opcion) {
		switch(opcion) {
		case SALIR:
			controlador.terminar();
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
		controlador.insertar(Consola.leerCliente());
	}
	public void insertarTurismo() {
		Consola.mostrarCabecera();
		controlador.insertar(Consola.leerTurismo());
	}
	public void insertarAlquiler() {
		Consola.mostrarCabecera();
		controlador.insertar(Consola.leerAlquiler());
	}
	
	//	BUSCAR
	public void buscarCliente() {
		Consola.mostrarCabecera();
		controlador.buscar(Consola.leerClienteDni());
		// imprimir datos con syso y controlarlo
	}
	public void buscarTurismo() {
		Consola.mostrarCabecera();
		controlador.buscar(Consola.leerTurismo());
	}
	public void buscarAlquiler() {
		Consola.mostrarCabecera();
		controlador.buscar(Consola.leerAlquiler());
	}
	
	
	//	MODIFICAR Y DEVOLVER
	public void modificarCliente() {
		Consola.mostrarCabecera();
		controlador.modificar(Consola.leerCliente(),Consola.leerNombre(),Consola.leerTelefono());
	}
	public void devolverAlquiler() {
		Consola.mostrarCabecera();
		controlador.devolver(Consola.leerAlquiler(),Consola.leerFechaDevolucion());
	}
	
	
	//	BORRAR
	public void borrarCliente() {
		Consola.mostrarCabecera();
		controlador.borrar(Consola.leerCliente());
	}
	public void borrarTurismo() {
		Consola.mostrarCabecera();
		controlador.borrar(Consola.leerTurismo());
	}
	public void borrarAlquiler() {
		Consola.mostrarCabecera();
		controlador.borrar(Consola.leerAlquiler());
	}
	
	
	//	LISTAR
	public void listarClientes() {
		Consola.mostrarCabecera();
		controlador.getClientes();
	}
	public void listarTurismos() {
		Consola.mostrarCabecera();
		controlador.getTurismos();
	}
	public void listarAlquileres() {
		Consola.mostrarCabecera();
		controlador.getAlquileres();
	}
	
	
	//	LISTAR CON PARAMETROS
	public void listarAlquileresCliente() {
		Consola.mostrarCabecera();
		controlador.getAlquileres(Consola.leerCliente());
	}
	public void listarAlquileresTurismo() {
		Consola.mostrarCabecera();
		controlador.getAlquileres(Consola.leerTurismo());
	}
}
