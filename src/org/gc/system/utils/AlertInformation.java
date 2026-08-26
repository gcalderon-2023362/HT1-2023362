package org.gc.system.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertInformation {
    
    public AlertInformation() {
        // Constructor vacío público
    }
    
    public void viewAlert(String tipoAlerta, String titulo, String encabezado, String mensaje) {
        AlertType alertType = obtenerAlertType(tipoAlerta);
        
        Alert alert = new Alert(alertType);
        alert.setTitle(titulo);
        alert.setHeaderText(encabezado);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    
    private AlertType obtenerAlertType(String tipoAlerta) {
        AlertType tipo;
        
        switch (tipoAlerta.toUpperCase()) {
            case "INFORMATION":
                tipo = AlertType.INFORMATION;
                break;
            case "WARNING":
                tipo = AlertType.WARNING;
                break;
            case "ERROR":
                tipo = AlertType.ERROR;
                break;
            case "CONFIRMATION":
                tipo = AlertType.CONFIRMATION;
                break;
            case "NONE":
                tipo = AlertType.NONE;
                break;
            default:
                tipo = AlertType.INFORMATION;
                break;
        }
        
        return tipo;
    }
}
