/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_6;

import java.io.IOException;

/**
 *
 * @author riza
 */
public class Soal3 extends Thread {
    
    boolean isPaused = false;
    
    @Override
    public void run() {
        int curVal = 0;
        int increment = 2;
        try {
            while (true) {
                if (isPaused) {
                    isPaused = false;
                    curVal += 1;
                    increment = -2;
                }
                curVal += increment;
                System.out.print(curVal + " ");
                Thread.sleep(1000);
            }
            
        } catch (InterruptedException ex) {
        }
        
    }

    public void setIsPaused(boolean isPaused) {
        this.isPaused = isPaused;
    }
    
    
    public static void main(String[] args) throws IOException {
        Soal3 counter = new Soal3();
        counter.start();
        
        System.out.println("Press enter to backward");
        System.in.read();
        counter.suspend();
        counter.setIsPaused(true);
        counter.resume();
        
        System.out.println("Press enter to stop");
        System.in.read();
        counter.stop();
    }
    
    
    
}
