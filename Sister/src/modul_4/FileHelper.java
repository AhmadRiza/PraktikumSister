/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_4;

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
public class FileHelper {
    
    public static void write(byte[] data, String to){
        try (FileOutputStream fos = new FileOutputStream(to)) {
            fos.write(data);
        }catch(Exception ex){
        }
    }
    
    public static List<Mahasiswa> read(String from){
        List<Mahasiswa> pList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(from));
            pList = (List<Mahasiswa>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return pList;
        
    }
    
    public static boolean isExist(String fileName) {
        File f = new File(fileName);
        return (f.exists() && !f.isDirectory());
    }
    
}
