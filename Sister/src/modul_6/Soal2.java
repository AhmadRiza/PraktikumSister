/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_6;

/**
 *
 * @author riza
 */
public class Soal2 {

    public static void main(String[] args) throws InterruptedException {

        int[] pasien = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        Thread dokter = new Dokter(pasien);
        dokter.start();
        dokter.join();
        Thread perawat1 = new Perawat(pasien,"Perawat 1",0);
        Thread perawat2 = new Perawat(pasien,"Perawat 2",1);
        perawat1.start();
        perawat2.start();

    }

}

class Dokter extends Thread {

    private int[] pasien;

    public Dokter(int[] pasien) {
        this.pasien = pasien;
    }

    @Override
    public void run() {
        System.out.println("Dokter mulai merawat pasien");
        for (int p : pasien) {
            System.out.println("Pasien ke-" + p+ " telah dirawat dokter");
            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {

            }
        }
        System.out.println("Dokter selesai merawat pasien");
    }

}

class Perawat extends Thread {

    private int[] pasien;
    private String name;
    int start;
    

    public Perawat(int[] pasien, String name, int start) {
        this.pasien = pasien;
        this.name = name;
        this.start = start;
    }

    @Override
    public void run() {
        System.out.println(name + " mulai merawat pasien");
        for (int i = start; i < pasien.length; i += 2) {
            System.out.println("Pasien ke-" + pasien[i] + " telah dirawat" + name);
            try {
                Thread.sleep(500);
                
//                bayar kasir
                new Kasir(pasien[i]).start();
                
            } catch (InterruptedException ex) {

            }
        }
        System.out.println(name + " selesai merawat pasien");
    }

}

class Kasir extends Thread {

    private int pasien;

    public Kasir(int pasien) {
        this.pasien = pasien;
    }

    @Override
    public void run() {
        try {
            System.out.println("Pasien ke-"+pasien+ " Telah membayar di kasir");
            Thread.sleep(500);
        } catch (InterruptedException ex) {

        }
    }

}
