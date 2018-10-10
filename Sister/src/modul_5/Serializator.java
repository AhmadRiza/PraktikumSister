/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_5;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 *
 * @author LAB_TI
 */

public class Serializator <V extends Object> {
    
    public byte[] serializeObject(V data) {
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

    public V deserializeObject(byte[] args) {
        ByteArrayInputStream bis = new ByteArrayInputStream(args);
        ObjectInput in = null;
        V result = null;
        try {
            in = new ObjectInputStream(bis);
            result = (V) in.readObject();

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
