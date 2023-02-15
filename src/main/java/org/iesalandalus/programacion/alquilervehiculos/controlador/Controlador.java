package org.iesalandalus.programacion.alquilervehiculos.controlador;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private Vista vista;
	private Modelo modelo;
	
	public Controlador(Modelo modelo,Vista vista) {
		this.modelo=modelo;
		this.vista=vista;
	}
}
