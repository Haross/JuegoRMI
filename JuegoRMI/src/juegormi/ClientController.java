/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegormi;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import objects.Preguntas;
import objects.Score;
import rmiSC.Cliente;

/**
 * FXML Controller class
 *
 * @author Josseline
 */
public class ClientController implements Initializable {
@FXML    
JFXTextField score, user, password;
@FXML    
JFXTextArea resultadosTxt;
@FXML
JFXButton Iniciar, r1, r2, r3;
@FXML
Text nombreUsuario, pregunta;
@FXML
AnchorPane UILogin, UIPregunta, UIResultados; 
    List<Preguntas> pq;
    int preguntaActual = 0;
    int sco = 0;
    public void entrar(){
        String usuario = user.getText();
        String pass = password.getText();
        if(usuario != null && pass !=null){
            Cliente c = new Cliente();
            if(c.entrarRMI(usuario, pass)){
                //usuario registrado exitosamente
            }
            pq = c.getPreQue();
            score.setText(sco +"");
            nombreUsuario.setText(usuario);
            UILogin.setVisible(false);
            UIPregunta.setVisible(true);
            UIResultados.setVisible(false);
            setPreguntaNext();
        }
        
        
    }
    public void salir(){
        Cliente c = new Cliente();
        pq = c.getPreQue();
        preguntaActual = 0;
        sco = 0;
        user.setText("");
        password.setText("");
        score.setText(sco +"");
        nombreUsuario.setText("");
        UILogin.setVisible(true);
        UIPregunta.setVisible(false);
        UIResultados.setVisible(false);
        
    }
    
    public void reiniciar(){
        Cliente c = new Cliente();
        pq = c.getPreQue();
        preguntaActual = 0;
        sco = 0;
        score.setText(sco +"");
        setPreguntaNext();
        UILogin.setVisible(false);
        UIPregunta.setVisible(true);
        UIResultados.setVisible(false);
    }
    
    public void checkR1(){
        
         Preguntas p = pq.get(preguntaActual);
         if(p.getRc().equals(r1.getText())){
             sco++;
             score.setText(sco +"");
             pq.remove(preguntaActual);
             setPreguntaNext();
             return;
         }else{
             showResultados();
         }
         
         
    }
    public void checkR2(){
        
         Preguntas p = pq.get(preguntaActual);
         
         if(p.getRc().equals(r2.getText())){
             sco++;
             score.setText(sco +"");
             pq.remove(preguntaActual);
            setPreguntaNext();
            return;
         }else{
             showResultados();
         }
         
    }
    public void showResultados(){
         Cliente c = new Cliente();
        List<Score> a= c.getScores(user.getText(), Long.parseLong( score.getText()));
        if(!a.isEmpty()){
            for(Score b:a){
            resultadosTxt.setText(b.getUsuario()+" -- " +b.getScore()+"\n");
        }
        }
        
        
        UILogin.setVisible(false);
        UIPregunta.setVisible(false);
        UIResultados.setVisible(true);
    }
    public void checkR3(){
        
         Preguntas p = pq.get(preguntaActual);
         if(p.getRc().equals(r3.getText())){
             sco++;
             score.setText(sco +"");
              pq.remove(preguntaActual);
             setPreguntaNext();
             return;
         }else{
             showResultados();
         }
        
    }
    
    public void setPreguntaNext(){
        if(pq != null){
            if(pq.isEmpty()){
                showResultados();
                return;
            }
            preguntaActual = (int) (Math.random()*pq.size());
            Preguntas p = pq.get(preguntaActual);
            System.out.println("ale " +preguntaActual);
            pregunta.setText(p.getPregunta());
            int aleatorio = (int) (Math.random()*3+1);
            switch(aleatorio){
                case 1:
                    setRespuestas(p.getR1(), p.getR2(), p.getRc());
                    break;
                case 2:
                    setRespuestas(p.getR2(), p.getRc(), p.getR1());
                    break;
                case 3:
                    setRespuestas(p.getRc(), p.getR1(), p.getR2());
                    break;
                default:
                    System.out.println("Aleatorio mal");
                    break;
            }
            
        }
        
    }
    
    public void setRespuestas(String a, String b, String c){
        r1.setText(a);
        r2.setText(b);
        r3.setText(c);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        UILogin.setVisible(true);
        UIPregunta.setVisible(false);
        UIResultados.setVisible(false);
        user.setLabelFloat(true);
        
    }    
    
}
