/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class Tugas3 {
    
    public static final String LOCATION ="/data/server_data3.ser";
    public static final int SERVICE_PORT = 8888;
    public static final int BUFSIZE = 256;

    private static final String host = "localhost";
    private static final long timeout = 3000;

    public static void sendDataToServer(List<Mahasiswa> data) throws SocketException, UnknownHostException, IOException {
        InetAddress addr = InetAddress.getByName(host);
        DatagramSocket socket = new DatagramSocket();
        socket.setSoTimeout(2000);
        
        byte[] barray = Serializator.serializeObject(data);
        
        DatagramPacket packet = new DatagramPacket(barray, barray.length, addr, SERVICE_PORT);
        System.out.println("Sending packet to " + host);
        socket.send(packet);
    }

    public static void showMenu() {
        System.out.println("------------------------");
        System.out.println("1. Insert Mahasiswa ");
        System.out.println("2. Update Mahasiswa");
        System.out.println("3. Delete Mahasiswa ");
        System.out.println("4. Print Mahasiswa ");
        System.out.println("5. Save Mahasiswa ");
        System.out.println("6. Exit ");
        System.out.print("Pilih : ");

    }
    
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Mahasiswa> mhsList = new ArrayList<>();
        
                
        while (true) {
            showMenu();
            try {
                int input = Integer.parseInt(br.readLine());
                System.out.println("------------------------");
                String nama, nim, asal, kelas;
                int idx;
                Mahasiswa m;
                switch (input) {
                    case 1:
                        System.out.println("#insert");
                        System.out.print("Nim : ");
                        nim = br.readLine();
                        System.out.print("Nama : ");
                        nama = br.readLine();
                        System.out.print("Asal: ");
                        asal = br.readLine();
                        System.out.print("Kelas: ");
                        kelas = br.readLine();
                        m = new Mahasiswa(nim, nama, asal, kelas);
                        mhsList.add(m);
                        System.out.println(m + " added!!");
                        System.out.println("");
                        break;
                    case 2:
                        System.out.println("#update");
                        System.out.print("Index: ");
                        idx = Integer.parseInt(br.readLine());
                        
                        if(idx>mhsList.size()-1){
                            System.out.println("Not Found!");
                            break;
                        }
                        
                        System.out.println("update ->"+mhsList.get(idx));
                        System.out.print("Nim : ");
                        nim = br.readLine();
                        System.out.print("Nama : ");
                        nama = br.readLine();
                        System.out.print("Asal: ");
                        asal = br.readLine();
                        System.out.print("Kelas: ");
                        kelas = br.readLine();
                        m = new Mahasiswa(nim, nama, asal, kelas);
                        mhsList.remove(idx);
                        mhsList.add(idx, m);
                        System.out.println(m + " updated!!");
                        System.out.println("");
                        break;
                        
                    case 3:
                        System.out.println("# delete");
                        System.out.print("Index: ");
                        idx = Integer.parseInt(br.readLine());
                         
                        if(idx>mhsList.size()-1){
                            System.out.println("Not Found!");
                            break;
                        }
                        m = mhsList.get(idx);
                        mhsList.remove(idx);
                        System.out.println(m + " deleted!!");
                        break;
                    case 4:
                        System.out.println("#print");
                        if(!FileHelper.isExist(LOCATION)){
                            System.out.println("Save First!");
                            break;
                        }
                        
                        int i = 0;
                       
                        for (Mahasiswa mhs : FileHelper.read(LOCATION)) {
                            System.out.printf("%d. %s", i++, mhs);
                            System.out.println("");
                        }
                        break;
                    case 5:
                        System.out.println("#serializing participant");
                        sendDataToServer(mhsList);
                        break;
                    default:
                        System.out.println("Thanks you!");
                        return ;
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }


        }




    }

}
