package org.gc.system.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import org.gc.system.utils.ViewFactory;

public class RegisterUserController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    public void onCancelRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewLogin();
    }
    
    @FXML
    public void onCreateUser(MouseEvent event){
        
    }
    
}
