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
	
	String texto;
	Opcion[] opcion=Opcion.values();
	private Opcion(String texto) {
		this.texto=texto;
	}
	
	private boolean esOrdinalValido(int ordinal) {
		if(ordinal<ordinal() || ordinal>=0) {
			return true;
		}
		return false;		
	}
	
	public Opcion get(int ordinal) {
		if(!esOrdinalValido(ordinal)==false) {
			throw new IllegalArgumentException("ERROR: El ordinal introducido no es válido.");
		}
		return opcion[ordinal];
	}
	
	public String toString() {
		return "0.-"+opcion[0].texto+ " \n1.-"+opcion[1].texto+ " \n"+
				"2.-"+opcion[2].texto+ " \n3.-"+opcion[3].texto+ " \n"+
				"4.-"+opcion[4].texto+ " \n5.-"+opcion[5].texto+ " \n"+
				"6.-"+opcion[6].texto+ " \n7.-"+opcion[7].texto+ " \n"+
				"8.-"+opcion[8].texto+ " \n9.-"+opcion[9].texto+ " \n"+
				"10.-"+opcion[10].texto+ " \n11.-"+opcion[11].texto+ " \n"+
				"12.-"+opcion[12].texto+ " \n13.-"+opcion[13].texto+ " \n"+
				"14.-"+opcion[14].texto+ " \n15.-"+opcion[15].texto+ " \n"+
				"16.-"+opcion[16].texto+ " \n";
	}
}
