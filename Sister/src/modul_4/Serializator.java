/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_4;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 *
 * @author LAB_TI
 */
public class Serializator {

    public static byte[] serializeObject(List<Mahasiswa> data) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out;
        byte[] result = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(data);
            out.flush();
            result = bos.toByteArray();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return result;
    }

    public static List<Mahasiswa> deserializeObject(byte[] args) {
        ByteArrayInputStream bis = new ByteArrayInputStream(args);
        ObjectInput in = null;
        List<Mahasiswa> result = null;
        try {
            in = new ObjectInputStream(bis);
            result = (List<Mahasiswa>) in.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                // ignore close exception
            }
        }
        return result;
    }

}
