package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.*;

public interface IVista {
	
	public void setControlador(IControlador controlador);
	
	public abstract void comenzar();
	
	public abstract void terminar();
	
	
}