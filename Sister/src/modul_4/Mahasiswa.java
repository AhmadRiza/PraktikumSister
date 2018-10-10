/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_4;
import java.io.Serializable;

/**
 *
 * @author LAB_TI
 */
public class Mahasiswa implements Serializable {

    private String nim;
    private String nama;
    private String asal;
    private String kelas;

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

        return nim + "/" + nama + "/" + asal + "/" + kelas;

    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAsal(String asal) {
        this.asal = asal;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    
    
}
