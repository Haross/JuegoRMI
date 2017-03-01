package juegormi;
import java.rmi.*;
import java.rmi.server.*;

class ServiciosMetodos extends UnicastRemoteObject implements Servicios {
    ServiciosMetodos() throws RemoteException {
    }
    @Override
    public String eco(String s) throws RemoteException {
        return s.toUpperCase();
    }
}