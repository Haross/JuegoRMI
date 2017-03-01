package juegormi;
import java.rmi.*;

class Cliente {
    static public void main (String args[]){

        try{

            Servicios objetoRemoto = (Servicios)Naming.lookup("//localhost/ObjetoRemoto");
            System.out.println (objetoRemoto.eco("minuscula"));

        }catch(Exception e){
            System.out.println("Algo fallo en el Cliente :'v");
        }

    }
}