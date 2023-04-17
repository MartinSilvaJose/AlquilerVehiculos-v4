package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.*;

public abstract class Vista {
	
	//	DECLARACION
	protected Controlador controlador;
	
	//	SETTER	
	public void setControlador(Controlador controlador) {
		if(controlador==null) {
			throw new NullPointerException("No puedes pasar un controlador nulo.");
		}
		this.controlador=controlador;
	}
	
	
	//	COMENZAR Y TERMINAR
	public abstract void comenzar();
	
	public abstract void terminar();
	
	
}
