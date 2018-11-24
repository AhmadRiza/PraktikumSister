/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author riza
 */
public class Server {
    
    public static void main(String[] args) throws RemoteException {
        
        Registry registry = LocateRegistry.createRegistry(1099);
        Data data = new Data();
        registry.rebind("data", data);
        
        System.out.println("Server is running on");
    }
    
}
