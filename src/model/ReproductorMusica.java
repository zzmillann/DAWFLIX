package model;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReproductorMusica {

    public void reproducirWav(String rutaArchivo) {
        try {
         
  InputStream inputStream = new BufferedInputStream(new FileInputStream(rutaArchivo));
AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);


            
            // Crea un Clip para reproducir
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Espera a que termine de reproducirse
            while (!clip.isRunning())
                Thread.sleep(10);
            while (clip.isRunning())
                Thread.sleep(10);
            clip.close();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            System.out.println("Error al reproducir el archivo de sonido: " + e.getMessage());
        }
    }
}