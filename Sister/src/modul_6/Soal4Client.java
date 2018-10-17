/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 *
 * @author riza
 */
public class Soal4Client {

    private static int SERVICE_PORT = 8888;

    public static void main(String[] args) {

        try {
            String host = "localhost";

            //send
            Socket daytime = new Socket(host, SERVICE_PORT);
            daytime.setSoTimeout(3000);

            BufferedReader reader = new BufferedReader(new InputStreamReader(daytime.getInputStream()));
            System.out.println("Result : " + reader.readLine());
            
            daytime.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
