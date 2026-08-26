package org.gc.system.controller;

import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.gc.system.utils.ViewFactory;

public class LoginController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    @FXML
    public void onRegister(MouseEvent event) {
        ViewFactory viewFacto = new ViewFactory();
        viewFacto.viewRegister();
    }
}

