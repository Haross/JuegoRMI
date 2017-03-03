package rmiSC;
import java.net.URL;
import rmiSC.Servicios;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import objects.Preguntas;
import objects.Score;

public class Cliente {
     public List<Preguntas> getPreQue(){
         List<Preguntas> preg = null;
         try{
             Registry myRegistry = LocateRegistry.getRegistry("192.168.0.15", 1099);
              Servicios objetoRemoto = (Servicios)Naming.lookup("//192.168.0.15/ObjetoRemoto");
               preg =  objetoRemoto.getQuesAns();
              for (Preguntas p : preg) {
                  System.out.println(p.getPregunta());
                  System.out.println("------------------------\n");
                  
             }
           return preg;
         }catch(Exception e){
             System.out.println("Error: "+e);
         }
           return null;  
           
     }
     public List<Score> getScores(String user, Long score){
        try{  Registry myRegistry = LocateRegistry.getRegistry("192.168.0.15", 1099);
              Servicios objetoRemoto = (Servicios)Naming.lookup("//192.168.0.15/ObjetoRemoto");
                 objetoRemoto.updateScore(user, score);
                 
              return objetoRemoto.getScores();
        }catch(Exception e){
            System.out.println("ER "+e);
        }

        return null;
     }
     public boolean entrarRMI (String u, String p){

        try{
             URL url = getClass().getResource("security.policy");
            System.setProperty("java.security.policy", url.toString()); 
            if (System.getSecurityManager() == null) {
                  System.setSecurityManager(new RMISecurityManager());
            }
            Registry myRegistry = LocateRegistry.getRegistry("192.168.0.15", 1099);
           
            Servicios objetoRemoto = (Servicios)Naming.lookup("//192.168.0.15/ObjetoRemoto");
            if(objetoRemoto.insertUser(u,p)){
                System.out.println("usuario insertado");
                return true;
            }else{
                System.out.println("usuario existente");
                return false;
            }
            

        }catch(Exception e){
            System.out.println("Algo fallo en el Cliente j :'v");
        }
        return false;
    }
}