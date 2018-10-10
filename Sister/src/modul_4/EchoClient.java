/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_4;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static modul_4.Tugas3.SERVICE_PORT;

/**
 *
 * @author riza
 */
public class EchoClient {

    private DatagramSocket socket;
    public static final int SERVICE_PORT = 8888;
    public static final int BUFSIZE = 256;

    private static final String host = "localhost";
    private static final int timeout = 3000;

    InetAddress addr = null;

    public EchoClient() {
        try {
            addr = InetAddress.getByName(host);
            socket = new DatagramSocket();
            socket.setSoTimeout(timeout);
        } catch (SocketException | UnknownHostException ex) {
        }
    }

    public byte[] receiveData() throws IOException {

        byte[] recbuf = new byte[BUFSIZE];
        DatagramPacket receivePacket = new DatagramPacket(recbuf, BUFSIZE);

        boolean timeout = false;

        try {
            socket.receive(receivePacket);
        } catch (InterruptedIOException e) {
            timeout = true;
        }
        
        if (!timeout) {
            System.out.println("Packet received!");
            System.out.println("Details : " + receivePacket.getAddress());
            return receivePacket.getData();
        } else {
            System.out.println("packet lost!");
        }
        
        return null;
    }

    public void sendDataToServer(List<Mahasiswa> data) throws SocketException, UnknownHostException, IOException {

        byte[] barray = Serializator.serializeObject(data);
        DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
        System.out.println("Sending packet to " + host);
        socket.send(packet);
    }

}
