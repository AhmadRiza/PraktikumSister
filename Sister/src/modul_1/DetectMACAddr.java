/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_1;

import java.net.InetAddress;
import java.net.NetworkInterface;

/**
 *
 * @author riza
 */

public class DetectMACAddr {

    private static String getMacAddr(String localIP){
        try{
            InetAddress ia = InetAddress.getByName(localIP);
            NetworkInterface ni = NetworkInterface.getByInetAddress(ia);
            
            byte[] mac = ni.getHardwareAddress();
            
            StringBuilder builder = new  StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                builder.append(String.format("%02X%s", mac[i],(i<mac.length-1)?"-": ""));
            }
            return builder.toString();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return "unknown";    
    }
    
    private static String getLocalIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        System.out.println(getMacAddr("192.168.71.26"));
    }
    
}
