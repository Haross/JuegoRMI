package rmiSC;
import java.rmi.*;

interface Servicios extends Remote {
        String eco (String s) throws RemoteException;

       /* //Conseguir las preguntas y respuestas 
        String getQuesAns () throws RemoteException;

        //Obtiene los puntajes del cliente
        String getScores() throws RemoteException;

        //Insertar score para la BD
        Boolean insertScore(String user_score) throws RemoteException;

        //Insertar nuevo usuario
        Boolean insertUser(String nuevo_user) throws RemoteException; */
}