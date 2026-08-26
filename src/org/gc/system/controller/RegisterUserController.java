package org.gc.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.gc.system.service.UserService;
import org.gc.system.service.UserStatus;
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
    private UserService userService = new UserService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }

    @FXML
    public void onCreateUser(MouseEvent event) {
        boolean isValidEmail = validate.validateEmail(txtEmail.getText().trim());
        if (isValidEmail == false) {
            alertInfo.viewAlert("ERROR", "ERROR EMAIL", "ERROR DE CAMPO", "HAS INGRESADO UN EMAIL INCORRECTO");
            return;
        }

        String user, name, lastName, email, password, confirmPassword;
        user = txtUser.getText().trim();
        name = txtName.getText().trim();
        lastName = txtLastName.getText().trim();
        email = txtEmail.getText().trim();
        password = pwdPassword.getText().trim();
        confirmPassword = pwdConfirmPassword.getText().trim();

        if (validate.emptyText(user) == true
                || validate.emptyText(name) == true
                || validate.emptyText(lastName) == true
                || validate.emptyText(email) == true
                || validate.emptyText(password) == true
                || validate.emptyText(confirmPassword) == true) {

            alertInfo.viewAlert("ERROR", "ERROR DE CAMPOS VACIOS", "ERROR DE CAMPO", "DEJO CAMPOS VACIOS DEL FORMULARIO");
            return;

        }
        String msgField = "";
        if (validate.validateLengthText(user, 25) == false) {
            msgField = "El campo Usuario es mayor a 25 caracteres";
        }
        if (validate.validateLengthText(name, 50) == false) {
            msgField = "El campo Nombres es mayor a 50 caracteres";
        }
        if (validate.validateLengthText(lastName, 50) == false) {
            msgField = "El campo Apellido es mayor a 50 caracteres";
        }
        if (validate.validateLengthText(email, 50) == false) {
            msgField = "El campo Email es mayor a 50 caracteres";
        }
        if (validate.validateLengthText(password, 35) == false) {
            msgField = "$El campo Contraseña es mayyor a 35 caracteres";
            return;
        }
        if (msgField.isEmpty() == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CAMPO", "ERROR", msgField);
            return;
        }

        if (validate.equalsText(password, confirmPassword) == false) {
            alertInfo.viewAlert("ERROR", "ERROR DE CONTRASEÑA", "ERROR", "SUS CONTRASEÑAS NO COINCIDEN");
            return;
        }
        UserStatus status
                = userService.createUser(user, name, lastName, email, password);
        switch (status) {
            case UserStatus.ERROR_USER_CREATE ->
                System.out.println("Error al crear en ctrl");
            case UserStatus.USER_CREATED ->
                System.out.println("Si se creo el usuario");
            case UserStatus.FIELDS_EMPTY ->
                System.out.println("Los campos no estan vacios");
            case UserStatus.VALUE_LENGHT_INVALID ->
                System.out.println("Error desconocido");
        }
    }

}
