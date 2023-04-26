package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros.FuenteDatosFicheros;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;
import org.iesalandalus.programacion.alquilervehiculos.vista.VistaTexto;

public class MainApp {
//	VERSION 1
	public static void main(String[] args) {
		Modelo modelo=new ModeloCascada(new FuenteDatosFicheros());
		Vista vista=new VistaTexto();
		Controlador controlador= new Controlador(modelo,vista);
		controlador.comenzar();
		//Se me escucha?s
	}

}
