/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_11;

/**
 *
 * @author riza
 */
public class PolyAlfabeticCaesar {

    public static void main(String[] args) {
        String plain = "AHMAD RIZA";
        String key = "GANTENG";
        
        System.out.println("Plain : "+plain);
        
        String encrypted = encript(plain, key);
        System.out.println("Encrypted = "+encrypted);
       
        String decrypted = decript(encrypted, key);
        System.out.println("Decrypted = "+decrypted);
    }

    public static String encript(String plain, String key) {
        String formatedKey = key;
        while (formatedKey.length() < plain.length()) {
            formatedKey += key;
        }
        String fixKey = formatedKey.substring(0, plain.length());
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < plain.length(); i++) {
            builder.append((char) (plain.charAt(i) + (fixKey.charAt(i) - 65)));
        }

        return builder.toString();
    }
    public static String decript(String encrypted, String key) {
        String formatedKey = key;
        while (formatedKey.length() < encrypted.length()) {
            formatedKey += key;
        }
        String fixKey = formatedKey.substring(0, encrypted.length());
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < encrypted.length(); i++) {
            builder.append((char) (encrypted.charAt(i) - (fixKey.charAt(i) - 65)));
        }

        return builder.toString();
    }

}
