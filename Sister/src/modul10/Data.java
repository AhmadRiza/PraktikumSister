/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author riza
 */
public class Data extends UnicastRemoteObject implements DataInterface{

    public Data() throws RemoteException{
    }

    @Override
    public int jumlah(int a, int b) {
        return a+b;
    }

    @Override
    public int kurang(int a, int b) {
        return a-b;
    }

    @Override
    public int kali(int a, int b) {
        return a*b;
    }

    @Override
    public int bagi(int a, int b) {
        return a/b;
    }
    
}
