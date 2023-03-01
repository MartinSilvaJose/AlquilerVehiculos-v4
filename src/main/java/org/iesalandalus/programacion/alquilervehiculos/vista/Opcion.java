package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
	SALIR("Salir"),
	INSERTAR_CLIENTE("Insertar cliente"),
	INSERTAR_TURISMO("Insertar turismo"),
	INSERTAR_ALQUILER("Insertar alquiler"),
	BUSCAR_CLIENTE("Buscar cliente"),
	BUSCAR_TURISMO("Buscar turismo"),
	BUSCAR_ALQUILER("Buscar alquiler"),
	MODIFICAR_CLIENTE("Modificar cliente"),
	DEVOLVER_ALQUILER("Devolver alquiler"),
	BORRAR_CLIENTE("Borrar cliente"),
	BORRAR_TURISMO("Borrar turismo"),
	BORRAR_ALQUILER("Borrar alquiler"),
	LISTAR_CLIENTES("Listar clientes"),
	LISTAR_TURISMOS("Listar turismos"),
	LISTAR_ALQUILERES("Listar alquileres"),
	LISTAR_ALQUILERES_CLIENTE("Listar los alquileres de un cliente"),
	LISTAR_ALQUILERES_TURISMO("Listar los alquileres de un turismo");
	
	private String texto;
	

	private Opcion(String texto) {
		this.texto=texto;
	}
	
	private static boolean esOrdinalValido(int ordinal) {
		if(ordinal<values().length || ordinal>=0) {
			return true;
		}
		return false;		
	}
	
	public static Opcion get(int ordinal) {
		if(esOrdinalValido(ordinal)==false) {
			throw new IllegalArgumentException("ERROR: El ordinal introducido no es válido.");
		}
		return values()[ordinal];
	}
	
	public String toString() {
		return String.format("%d.- %s.", ordinal(),texto);

	}
}
