package rmiSC;
import java.rmi.*;
import java.util.List;
import objects.Preguntas;
import objects.Score;

interface Servicios extends Remote {
        
        //Conseguir las preguntas y respuestas 
        List<Preguntas> getQuesAns () throws RemoteException;

      /*  //Obtiene los puntajes del cliente
        String getScores() throws RemoteException;

        //Insertar score para la BD
        Boolean insertScore(String user_score) throws RemoteException;
*/
        
         boolean updateScore(String user, long score) throws RemoteException;
         List<Score> getScores() throws RemoteException;
        //Insertar nuevo usuario
        boolean insertUser(String nuevo_user, String pass) throws RemoteException; 
}