/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class Serializator {

    public static void serialize(List<Mahasiswa> pList, String fileName) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(pList);
        } catch (IOException ex) {
        }

    }

    public static List<Mahasiswa> deserialize(String fileName) {
        List<Mahasiswa> pList = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
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
