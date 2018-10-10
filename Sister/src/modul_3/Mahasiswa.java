/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modul_3;

import java.io.Serializable;

/**
 *
 * @author LAB_TI
 */
public class Mahasiswa implements Serializable{

    private final String nim;
    private final String nama;
    private final String asal;
    private final String kelas;

    public Mahasiswa(String nim, String nama, String asal, String kelas) {
        this.nim = nim;
        this.nama = nama;
        this.asal = asal;
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public String getAsal() {
        return asal;
    }

    public String getKelas() {
        return kelas;
    }

    @Override
    public String toString() {
        
        return nim+"/"+nama+"/"+asal+"/"+kelas;

    }
    
    

}










