package org.iesalandalus.programacion.alquilervehiculos.vista.iugrafica;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.vista.IVista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class VistaGrafica extends Application implements IVista {

	private Controlador controladorMVC;
	
	@Override
	public void setControlador(Controlador controlador) {
		if(controlador==null) {
			throw new NullPointerException("No puedes pasar un controlador nulo.");
		}
		this.controladorMVC=controlador;
	}
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("iugVentanas.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void comenzar() {
		launch(this.getClass());
		
	}

	@Override
	public void terminar() {
		controladorMVC.terminar();
		
	}


	
}
