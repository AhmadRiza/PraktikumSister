/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author riza
 */
public interface DataInterface extends Remote{
    
    public int jumlah(int a, int b) throws RemoteException;
    public int kurang(int a, int b) throws RemoteException;
    public int kali(int a, int b) throws RemoteException;
    public int bagi(int a, int b) throws RemoteException;
    
}
