package org.academiadecodigo.teamgreen.pokemon;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SoundHandler {
    public static void RunMusic(String path) {System.out.println(path);
        try {

            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            ;
        }
    }
}
