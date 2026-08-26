package org.gc.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.gc.system.utils.AlertInformation;
import org.gc.system.utils.Validations;
import org.gc.system.utils.ViewFactory;

public class RegisterUserController implements Initializable {

    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtEmail;
    @FXML
    private PasswordField pwdPassword;
    @FXML
    private PasswordField pwdConfirmPassword;
    
    private Validations validate = new Validations();
    private AlertInformation alertInfo = new AlertInformation();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Inicialización si es necesaria
    }

    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onCreateUser(MouseEvent event) {
        // 1. Obtener y limpiar los valores de los campos
        String user = txtUser.getText().trim();
        String name = txtName.getText().trim();
        String lastName = txtLastName.getText().trim();
        String email = txtEmail.getText().trim();
        String password = pwdPassword.getText().trim();
        String confirmPassword = pwdConfirmPassword.getText().trim();

        // 2. Validar campos vacíos PRIMERO (es lo más básico)
        if (validate.emptyText(user) || validate.emptyText(name) || 
            validate.emptyText(lastName) || validate.emptyText(email) || 
            validate.emptyText(password) || validate.emptyText(confirmPassword)) {
            
            alertInfo.viewAlert("ERROR", "CAMPOS VACÍOS", "Error de validación", "Por favor, complete todos los campos del formulario.");
            return; // Detenemos la ejecución aquí para no seguir validando
        }

        // 3. Validar el formato del email
        // OJO: Si validateEmail devuelve FALSE, significa que es INCORRECTO
        boolean isEmailValid = validate.validateEmail(email);
        if (!isEmailValid) { 
            alertInfo.viewAlert("ERROR", "EMAIL INVÁLIDO", "Error de validación", "Ha ingresado un formato de correo electrónico incorrecto.");
            return; // Detenemos la ejecución aquí
        }

        // 4. Validar que las contraseñas coincidan
        if (!validate.equalsText(password, confirmPassword)) {
            alertInfo.viewAlert("ERROR", "CONTRASEÑAS NO COINCIDEN", "Error de validación", "Las contraseñas ingresadas no son iguales.");
            return;
        }

        // 5. Si todo está correcto, aquí iría la lógica para guardar el usuario en la base de datos
        alertInfo.viewAlert("INFORMATION", "ÉXITO", "Registro exitoso", "El usuario se ha creado correctamente.");
        
        // Opcional: Redirigir al login después del éxito
        // ViewFactory viewFacto = new ViewFactory();
        // viewFacto.viewLogin();
    }
