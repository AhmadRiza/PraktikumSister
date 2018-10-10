/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modul_4;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class EchoServer {
    public static final int SERVICE_PORT = 8888;
    public static final int BUFSIZE = 256;

    private DatagramSocket socket;

    public EchoServer() {
        try {
            socket = new DatagramSocket(SERVICE_PORT);
            System.out.println("Server active on port "+socket.getLocalPort());
        } catch (Exception e) {
            System.out.println("Unable to bind port");
            e.printStackTrace();
        }

    }

    public void serviceClients(){
        byte[] buffer = new byte[BUFSIZE];
        for(;;){
            try {

                DatagramPacket packet = new DatagramPacket(buffer, BUFSIZE);
                socket.receive(packet);

                System.out.println("Packet receive data from"
                        +packet.getAddress()+" : "
                        +packet.getPort()
                        +" of length "+packet.getLength()
                        );
                
//                save data to local
                FileHelper.write(packet.getData(), Tugas3.LOCATION);
                
                socket.send(packet);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.serviceClients();
    }

}
