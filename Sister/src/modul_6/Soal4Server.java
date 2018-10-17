/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketImpl;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riza
 */
public class Soal4Server{

    private static int SERVICE_PORT = 8888;

    public static void main(String[] args) {
        int total = 1;
        try {
            System.out.println("Daytime server started");
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            for (int i = 0;i<10;i++) {
                final int no = i+1;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Socket nextClient = server.accept();
                            OutputStream out = nextClient.getOutputStream();

                            PrintStream pout = new PrintStream(out);
                            System.out.println(nextClient.getPort() + " " + nextClient.getInetAddress());
                            String reply = "Ahlan pengunjung di thread-"+no;
                            pout.print(reply);
                            Thread.sleep(2000);
                            
                            out.flush();

                            out.close();

                            nextClient.close();
                        } catch (IOException |InterruptedException ex) {
                        }
                    }
                }).start();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
