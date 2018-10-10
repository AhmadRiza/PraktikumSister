/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riza
 */
public class IOStream {

    private static String readFile(String path) throws FileNotFoundException, IOException {
        InputStream is = new FileInputStream(path);
        StringBuilder builder = new StringBuilder();
        int data = is.read();
        while (data != -1) {
            builder.append((char) data);
            data = is.read();
        }
        is.close();
        return builder.toString();
    }
    
    private static void writeFile(String path, String text) throws FileNotFoundException, IOException{
        OutputStream os = new FileOutputStream(path);
        for (int i = 0; i < text.length(); i++) {
            os.write((byte) text.charAt(i));
        }
        os.close();
    }

    public static void main(String[] args) {
        try {
            System.out.println(readFile("/data/read.txt"));
            writeFile("/data/write.txt", "Hello world!");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
