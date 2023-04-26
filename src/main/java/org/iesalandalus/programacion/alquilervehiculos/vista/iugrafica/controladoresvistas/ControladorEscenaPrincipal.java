package org.iesalandalus.programacion.alquilervehiculos.vista.iugrafica.controladoresvistas;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControladorEscenaPrincipal {
	
    @FXML
    private Button btnCInsertar;

    @FXML
    private Button btnModificar;

    @FXML
    private TableColumn<?, ?> tcCDni;

    @FXML
    private TableColumn<?, ?> tcCNombre;

    @FXML
    private TableColumn<?, ?> tcCTelefono;

    @FXML
    private TableView<?> tvClientes;

    @FXML
    void insertarPersona(ActionEvent event) {

    }
}

