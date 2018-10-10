/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modul_2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author riza
 */
public class SoundHelper {
    
    public static void playSound(File file) throws FileNotFoundException, IOException{
        InputStream in = new FileInputStream(file);
        AudioStream audioStream = new AudioStream(in);
        AudioPlayer.player.start(audioStream);    
    }
    
    
}
