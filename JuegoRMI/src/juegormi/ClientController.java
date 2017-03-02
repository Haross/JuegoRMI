/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegormi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;
import rmiSC.Cliente;

/**
 * FXML Controller class
 *
 * @author Josseline
 */
public class ClientController implements Initializable {
JFXTextField score, user, password;
JFXButton Iniciar, r1, r2, r3;
Text nombreUsuario, pregunta;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Cliente c = new Cliente();
        c.test();
    }    
    
}
