package org.iesalandalus.programacion.alquilervehiculos.vista.iugrafica.controladoresvistas;

import org.iesalandalus.programacion.alquilervehiculos.controlador.IControlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class ControladorEscenaSecundaria {
	
	private IControlador controladorMVC;
	
    @FXML
    private Button btnInsertarAlquiler;

    @FXML
    private Button btnInsertarCliente;

    @FXML
    private Button btnInsertarVehiculo;

    @FXML
    private DatePicker dpInsertarAlquiler;

    @FXML
    private GridPane gpAlquileres;

    @FXML
    private GridPane gpClientes;

    @FXML
    private GridPane gpVehiculos;

    @FXML
    private RadioButton rbAutobus;

    @FXML
    private RadioButton rbFurgoneta;

    @FXML
    private RadioButton rbTurismo;

    @FXML
    private TextField tfAlquilerCliente;

    @FXML
    private TextField tfAlquilerVehiculo;

    @FXML
    private TextField tfClienteDni;

    @FXML
    private TextField tfClienteNombre;

    @FXML
    private TextField tfClienteTelefono;

    @FXML
    private TextField tfVehiculoCilindrada;

    @FXML
    private TextField tfVehiculoMarca;

    @FXML
    private TextField tfVehiculoMatricula;

    @FXML
    private TextField tfVehiculoModelo;

    @FXML
    private TextField tfVehiculoPlazas;

    @FXML
    private TextField tfVehiculoPma;

    @FXML
    void InsertarAlquiler(ActionEvent event) {

    }

    @FXML
    void InsertarVehiculo(ActionEvent event) {

    }

    @FXML
    void insertarCliente(ActionEvent event) {

    }
    public void setControladorMVC(IControlador controlador) 
    {   
        controladorMVC = controlador;        
    }
    public void setAccion(String interfaz)
    {
        if(interfaz.equals("Clientes")) {
        	gpClientes.setVisible(true);
        }else if(interfaz.equals("Vehiculos")) {
        	gpVehiculos.setVisible(true);
        }else if(interfaz.equals("Alquileres")) {
        	gpAlquileres.setVisible(true);
        }
    }
}

