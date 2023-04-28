package org.iesalandalus.programacion.alquilervehiculos.vista.iugrafica.controladoresvistas;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.iesalandalus.programacion.alquilervehiculos.controlador.IControlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ControladorEscenaPrincipal {
	private IControlador controladorMVC;
	
	@FXML
	private void initialize() {
		System.out.println("Llaamada a incialice");
	}
    public void setControladorMVC(IControlador controlador) 
    {           
        controladorMVC = controlador;        
    }
    
//    Panel Cliente
    @FXML
    private Button btnCBorrar;
    @FXML
    private Button btnCBuscar;
    @FXML
    private Button btnCInsertar;
    @FXML
    private Button btnCModificar;
    @FXML
    private TextField tfCDni;
    
//    Lista Clientes
    @FXML
    private TableView<Cliente> tvClientes;
    @FXML
    private TableColumn<Cliente, String> tcCDni;
    @FXML
    private TableColumn<Cliente, String> tcCNombre;
    @FXML
    private TableColumn<Cliente, String> tcCTelefono;
//    Panel Vehículo
    @FXML
    private Button btnVBorrar;
    @FXML
    private Button btnVBuscar;
    @FXML
    private Button btnVInsertar;
    @FXML
    private Button btnVMostrarEstadisticas;   
    @FXML
    private TextField tfVMatricula;

    
//    Lista Vehículos
    @FXML
    private TableView<Vehiculo> tvVehiculos;
    @FXML
    private TableColumn<Vehiculo, Integer> tvVCilindrada;
    @FXML
    private TableColumn<Vehiculo, String> tvVMatricula;
    @FXML
    private TableColumn<Vehiculo, String> tvVModelo;
    @FXML
    private TableColumn<Vehiculo, Integer> tvVPlazas;
    @FXML
    private TableColumn<Vehiculo, Integer> tvVPma;
    @FXML
    private TableColumn<Vehiculo, String> tcVMarca;


    
//    Panel Alquiler
    @FXML
    private Button btnABorrar;
    @FXML
    private Button btnABuscar;
    @FXML
    private Button btnADevolver;
    @FXML
    private Button btnAInsertar;    
    @FXML
    private DatePicker dpAFecha;
    
//    Lista Alquileres
    
    @FXML
    private TableColumn<Alquiler, Cliente> tcACliente;
    @FXML
    private TableColumn<Alquiler, LocalDate> tcAFechaAlquiler;
    @FXML
    private TableColumn<Alquiler, LocalDate> tcAFechaDevolucion;
    @FXML
    private TableColumn<Alquiler, Vehiculo> tcAVehiculo;
    @FXML
    private TableView<Alquiler> tvAlquileres;










    @FXML
    void insertarCliente(ActionEvent event) {
        try 
        {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../vistas/EscenaSecundaria.fxml"));
            
            Parent raiz=loader.load();
                    
            ControladorEscenaSecundaria controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setAccion("Clientes");
            Scene escena=new Scene(raiz);
            
            Stage escenario=new Stage();
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.setScene(escena);
            escenario.setTitle("Insertar Cliente");
            escenario.showAndWait();
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ControladorEscenaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    void insertarVehiculo(ActionEvent event) {
        try 
        {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../vistas/EscenaSecundaria.fxml"));
            
            Parent raiz=loader.load();
                    
            ControladorEscenaSecundaria controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setAccion("Vehiculos");
            Scene escena=new Scene(raiz);
            
            Stage escenario=new Stage();
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.setScene(escena);
            escenario.setTitle("Insertar Vehiculo");
            escenario.showAndWait();
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ControladorEscenaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void insertarAlquiler(ActionEvent event) {
        try 
        {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("../vistas/EscenaSecundaria.fxml"));
            
            Parent raiz=loader.load();
                    
            ControladorEscenaSecundaria controlador=loader.getController();
            controlador.setControladorMVC(controladorMVC);
            controlador.setAccion("Alquileres");
            Scene escena=new Scene(raiz);
            
            Stage escenario=new Stage();
            escenario.initModality(Modality.APPLICATION_MODAL);
            escenario.setScene(escena);
            escenario.setTitle("Insertar Alquiler");
            escenario.showAndWait();
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(ControladorEscenaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void borrarAlquiler(ActionEvent event) {

    }

    @FXML
    void borrarCliente(ActionEvent event) {

    }

    @FXML
    void borrarVehiculo(ActionEvent event) {

    }

    @FXML
    void buscarAlquiler(ActionEvent event) {

    }

    @FXML
    void buscarCliente(ActionEvent event) {

    }

    @FXML
    void buscarVehiculo(ActionEvent event) {

    }

    @FXML
    void devolverAlquiler(ActionEvent event) {

    }

    @FXML
    void modificarCliente(ActionEvent event) {

    }

    @FXML
    void mostrarEstadisticas(ActionEvent event) {

    }
}


