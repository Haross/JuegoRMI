package rmiSC;
import java.net.URL;
import rmiSC.Servicios;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
     public void test (){

        try{
             URL url = getClass().getResource("security.policy");
            System.setProperty("java.security.policy", url.toString()); 
            if (System.getSecurityManager() == null) {
                  System.setSecurityManager(new RMISecurityManager());
            }
            Registry myRegistry = LocateRegistry.getRegistry("192.168.0.15", 1099);
             
            Servicios objetoRemoto = (Servicios)Naming.lookup("//192.168.0.15/ObjetoRemoto");
            System.out.println (objetoRemoto.eco("minuscula"));

        }catch(Exception e){
            System.out.println("Algo fallo en el Cliente :'v");
        }

    }
}