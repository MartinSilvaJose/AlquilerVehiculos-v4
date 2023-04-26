package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ficheros.FuenteDatosFicheros;
import org.iesalandalus.programacion.alquilervehiculos.vista.IVista;
import org.iesalandalus.programacion.alquilervehiculos.vista.iugrafica.VistaGrafica;
import org.iesalandalus.programacion.alquilervehiculos.vista.iutextual.VistaTexto;

public class MainApp {

	public static void main(String[] args) {
		Modelo modelo=new ModeloCascada(new FuenteDatosFicheros());
		IVista vista=new VistaGrafica();
		Controlador controlador= new Controlador(modelo,vista);
		controlador.comenzar();
	}

}
