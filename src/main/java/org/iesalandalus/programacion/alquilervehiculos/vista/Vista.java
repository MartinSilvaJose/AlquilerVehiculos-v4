package org.iesalandalus.programacion.alquilervehiculos.vista;
import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.*;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

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
		System.out.println("Hasta la próxima.");
	}
	
	
	//	EJECUTAR	
	public void ejecutar(Opcion opcion) {
		switch(opcion) {
		case SALIR:
			terminar();
			System.exit(0);
			break;
		case INSERTAR_CLIENTE:
			insertarCliente();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case INSERTAR_TURISMO:
			insertarTurismo();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case INSERTAR_ALQUILER:
			insertarAlquiler();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BUSCAR_CLIENTE:
			buscarCliente();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BUSCAR_TURISMO:
			buscarTurismo();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BUSCAR_ALQUILER:
			buscarAlquiler();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case MODIFICAR_CLIENTE:
			modificarCliente();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case DEVOLVER_ALQUILER:
			devolverAlquiler();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BORRAR_CLIENTE:
			borrarCliente();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BORRAR_TURISMO:
			borrarTurismo();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case BORRAR_ALQUILER:
			borrarAlquiler();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case LISTAR_CLIENTES:
			listarClientes();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case LISTAR_TURISMOS:
			listarTurismos();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case LISTAR_ALQUILERES:
			listarAlquileres();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case LISTAR_ALQUILERES_CLIENTE:
			listarAlquileresCliente();
			System.out.println("Operación realizada con éxito");
			comenzar();
			break;
		case LISTAR_ALQUILERES_TURISMO:
			listarAlquileresTurismo();
			System.out.println("Operación realizada con éxito");
			comenzar();
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
		Cliente cliente=controlador.buscar(Consola.leerClienteDni());
		if(cliente==null) {
			System.out.println("ERROR:El cliente que busca no existe");
		}
		else {
			System.out.println(cliente);
		}

	}
	public void buscarTurismo() {
		Consola.mostrarCabecera();
		Turismo turismo=controlador.buscar(Consola.leerTurismoMatricula());
		if(turismo==null) {
			System.out.println("ERROR:El turismo que busca no existe");
		}
		else {
			System.out.println(turismo);

		}

	}
	public void buscarAlquiler() {
		Consola.mostrarCabecera();
		Alquiler alquiler=controlador.buscar(Consola.leerAlquiler());
		if(alquiler==null) {
			System.out.println("ERROR:El Alquiler que busca no existe");
		}
		else {
			System.out.println(alquiler);
		}
	}
	
	
	//	MODIFICAR Y DEVOLVER
	public void modificarCliente() {
		Consola.mostrarCabecera();
		try {
			Cliente cliente=controlador.buscar(Consola.leerClienteDni());
			controlador.modificar(cliente,Consola.leerNombre(),Consola.leerTelefono());
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
