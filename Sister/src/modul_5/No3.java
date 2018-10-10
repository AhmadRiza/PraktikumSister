/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author riza
 */
public class No3 {

    public static String getConsoleInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        return br.readLine();
    }

    public static void showMenu() {
        System.out.println("------------------------");
        System.out.println("1. Tambah mahasiswa ");
        System.out.println("2. Tampil mahasiswa ");
        System.out.print("Pilih : ");
    }

    public static Mahasiswa addMahasiswa() throws IOException {
        System.out.println("Insert Mahasiswa");
        System.out.print("Nama : ");
        String nama = getConsoleInput();
        System.out.print("NIM : ");
        String nim = getConsoleInput();
        System.out.print("Asal : ");
        String asal = getConsoleInput();
        System.out.print("Kelas : ");
        String kelas = getConsoleInput();
        return new Mahasiswa(nim, nama, asal, kelas);
    }

    public static void main(String[] args) {
        List<Mahasiswa> list = new ArrayList<>();
        try {
            MyClient<Mahasiswa, List<Mahasiswa>> client = new MyClient<>("localhost", 8888);
            
            while (true) {
                showMenu();
                String select = getConsoleInput();

                if (select.equals("1")) {
            
                    client.post(addMahasiswa(), new ClientCallback() {
                        @Override
                        public void onResponse(Object data) {
                            list.clear();
                            list.addAll((List<Mahasiswa>) data);
                        }

                        @Override
                        public void onError(String msg) {
                            System.out.println(msg);
                        }
                    });

                } else if (select.equals("2")) {
                    int i = 0;
                    for (Mahasiswa m : list) {
                        System.out.println((++i) + m.toString());
                    }

                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
