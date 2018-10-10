/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

/**
 *
 * @author riza
 */
public class FileHelper<V extends  Object> {
    
    private String location;

    public FileHelper(String location) {
        this.location = location;
    }
    
    
    
    public void write(byte[] data){
        try (FileOutputStream fos = new FileOutputStream(location)) {
            fos.write(data);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public List<Mahasiswa> read(){
        List<Mahasiswa> pList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(location));
            pList = (List<Mahasiswa>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return pList;
        
    }
    
    public boolean isExist() {
        File f = new File(location);
        return (f.exists() && !f.isDirectory());
    }
    
}

