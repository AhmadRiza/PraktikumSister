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
public class Soal1 {
    
    private static void writeFile(String path, String text) throws FileNotFoundException, IOException{
        OutputStream output = new FileOutputStream(path);
        for (int i = 0; i < text.length(); i++) {
            output.write((byte)text.charAt(i));
        }
        output.close();
    }
    
    private static String readFile(String path) throws FileNotFoundException, IOException{
        InputStream input = new FileInputStream(path);
        StringBuilder result = new StringBuilder();
        int bit = input.read();
        while (bit!=-1) {
            result.append((char)bit);
            bit = input.read();
        }
        input.close();
        return result.toString();
    }
    
    
    public static void main(String[] args) {
        String targetPath = "/data/newFile.txt";
        String refDir = "/data/copythis.txt";
        try {
//            make new file
            writeFile(targetPath, "");
//            copy file
            String copy = readFile(refDir);
//            paste to new file
            writeFile(targetPath, copy);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
}
