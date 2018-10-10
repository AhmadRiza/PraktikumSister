/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class DaytimeServer {

    public final static int SERVICE_PORT = 8888;
    public final static String LOCATION = "/data/res1.ser";

    public static void main(String[] args) {

        FileHelper<List<Mahasiswa>> fileHelper = new FileHelper<>(LOCATION);
        List<Mahasiswa> list = new ArrayList<>();
        Serializator<List<Mahasiswa>> serializator = new Serializator<>();
        
        try {
            ServerSocket server = new ServerSocket(SERVICE_PORT);
            System.out.println("Daytime server started");
            for (;;) {

                //receive
                Socket nextClient = server.accept();
                
                System.out.println("Received request from " +
                        nextClient.getInetAddress() + " : " +
                        nextClient.getPort());

//                BufferedReader reader = new BufferedReader(new InputStreamReader(nextClient.getInputStream()));

                 ObjectInputStream ois = new ObjectInputStream(nextClient.getInputStream());
                 Mahasiswa m =(Mahasiswa) ois.readObject();
                 list.add(m);
                 
                 
//                String dataReceived = reader.readLine();
                System.out.println("Data : " + m.toString());
                 fileHelper.write(serializator.serializeObject(list));

                nextClient.close();
                System.out.println("--------------------");
                //reply

                nextClient = server.accept();
                OutputStream out = nextClient.getOutputStream();
                
                ObjectOutputStream oos = new ObjectOutputStream(out);
                oos.writeObject(fileHelper.read());

                out.flush();

                out.close();

                nextClient.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
