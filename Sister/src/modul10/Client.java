/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 *
 * @author riza
 */
public class Client {
    
    private static String getInputString() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        return reader.readLine();
    }

    
    
    public static void main(String[] args) throws NotBoundException, MalformedURLException, RemoteException, IOException {
        
        DataInterface data = (DataInterface) Naming.lookup("rmi://localhost:1099/data");
        System.out.println("Client connected");
        
        while (true) {
            
            System.out.println("1. jumlah");
            System.out.println("2. kurang");
            System.out.println("3. kali");
            System.out.println("4. bagi");
            System.out.print("Pilih: ");
            int select = Integer.parseInt(getInputString());
            
            System.out.print("angka1: ");
            int a = Integer.parseInt(getInputString());
            System.out.print("angka2: ");
            int b = Integer.parseInt(getInputString());
            int c = 0;
            switch (select) {
                case 1:
                    c = data.jumlah(a, b);
                    break;
                case 2:
                    c = data.kurang(a, b);
                    break;
                case 3:
                    c = data.kali(a, b);
                    break;
                case 4:
                    c = data.bagi(a, b);
                    break;
                default:
                    System.out.println(">End<");

                    return ;
                    
            }
            System.out.println("Hasil = "+c);
            System.out.println("----------------------------");
        }
        
        
        
    }
    
}
