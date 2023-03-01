package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	private static String PATRON_FECHA="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/([0-9]{4})";
	private static DateTimeFormatter FORMATO_FECHA=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private Consola() {
		
	}
	
	public static void mostrarCabecera() {
		System.out.println("PROGRAMA DE ALQUILER DE COCHES");
		System.out.println("------------------------------");
	}
	
	public static void mostrarMenu() {
		System.out.println("Administrador de alquileres, clientes y turismos.");
		for(Opcion opcion:Opcion.values()) {
			System.out.println(opcion);
		}
	}
	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		String cadenaIntroducida=Entrada.cadena();
		return cadenaIntroducida;
	}
	private static int leerEntero(String mensaje) {
		System.out.println(mensaje);
		int enteroIntroducido=Entrada.entero();
		return enteroIntroducido;
	}
	private static LocalDate leerFecha(String mensaje) {
		System.out.println(mensaje);
		String fechaIntroducida;
		do {
			fechaIntroducida=Entrada.cadena();
		}while(!fechaIntroducida.matches(PATRON_FECHA));
		LocalDate fechaCorrecta=LocalDate.parse(fechaIntroducida);
		fechaCorrecta.format(FORMATO_FECHA);
		return fechaCorrecta;
	}
	public static Opcion elegirOpcion(){
		int opcionElegida=-1;
		do {
			opcionElegida=leerEntero("Introduzca la opción a elegir.");
		}while(opcionElegida>Opcion.values().length || opcionElegida<1);
		
		return Opcion.get(opcionElegida);
		
	}
	public static Cliente leerCliente() {
		String dni=leerCadena("Introduza el dni del cliente.");
		Cliente cliente= new Cliente(leerNombre(),dni,leerTelefono());
		
		return cliente;
	}
	
	public static Cliente leerClienteDni() {
		return Cliente.getClienteConDni(leerCadena("Introduce el dni."));
	}
	
	public static String leerNombre() {
		String nombre=leerCadena("Introduzca el nombre.");
		return nombre;
	}
	public static String leerTelefono() {
		String telefono=leerCadena("Introduzca el telefono.");
		return telefono;
	}
	public static Turismo leerTurismo() {
		String marca=leerCadena("Introduzca la marca.");
		String modelo=leerCadena("Introduzca el modelo.");
		String matricula=leerCadena("Introduzca la matricula.");
		int cilindrada=leerEntero("Introduzca la cilindrada.");
		Turismo turismo= new Turismo(marca,modelo,cilindrada,matricula);
		return turismo;
	}
	
	public static Turismo leerTurismoMatricula() {
		return Turismo.getTurismoConMatricula(leerCadena("Introduce la matricula."));
	}
	public static Alquiler leerAlquiler() {
		Cliente cliente=new Cliente(leerCliente());
		Turismo turismo=new Turismo(leerTurismo());
		LocalDate fecha=leerFecha("Introduzca la fecha de alquiler");
		Alquiler alquiler=new Alquiler(cliente, turismo, fecha);
		return alquiler;
	}
	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion=leerFecha("Introduzca la fecha de devolución.");
		return fechaDevolucion;
	}
}
