/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_6;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riza
 */
public class Soal1 extends Thread {

    private int n1, n2, n3;
    
    private int total;
    
    public Soal1(int n1, int n2, int n3) {
        this.n1 = n1;
        this.n2 = n2;
        this.n3 = n3;
    }

    @Override
    public void run() {
        total = n1 + n2 + n3;
        System.out.print(total + " ");
        try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        }
    }

    public int getTotal() {
        return total;
    }
    
    

    public static void main(String[] args) throws InterruptedException {
        

        int[] data1 = {6, 9, 1, 2, 3, 5};
        int[] data2 = {7, 11, 6, 4, 3, 1};
        int[] data3 = {5, 4, 3, 2, 1, 12};
        int total =0;
        for (int i = 0; i < data1.length; i++) {
            Soal1 t = new Soal1(data1[i], data2[i], data3[i]);
            t.start();
            t.join();
            total+=t.getTotal();
        }
        
        System.out.println("Total = "+total);

    }
    
    
    

}
