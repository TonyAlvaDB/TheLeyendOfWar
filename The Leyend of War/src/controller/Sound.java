/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Sound {
    Clip clip;
    URL soundURL[] = new URL[30];
    FloatControl fc;
    public int volumeScale = 3;
    public float volume;
    
    public Sound(){
        soundURL[0] = getClass().getResource("/sound/boss.wav");
        soundURL[1] = getClass().getResource("/sound/confurtatis.wav");
        soundURL[2] = getClass().getResource("/sound/retro_ambience_acute_01.wav");
        soundURL[3] = getClass().getResource("/sound/proyectile.wav");
        soundURL[4] = getClass().getResource("/sound/damage_to_human.wav");
        soundURL[5] = getClass().getResource("/sound/sowrd_swing.wav");
        soundURL[6] = getClass().getResource("/sound/retro_event_acute_08.wav");
        soundURL[7] = getClass().getResource("/sound/retro_powerup_23.wav");
        soundURL[8] = getClass().getResource("/sound/retro_roar_02.wav");
        soundURL[9] = getClass().getResource("/sound/retro_weird_07.wav");
        soundURL[10] = getClass().getResource("/sound/toccata.wav");
        soundURL[11] = getClass().getResource("/sound/retro_charge_07.wav");
        soundURL[12] = getClass().getResource("/sound/items.wav");
        soundURL[13] = getClass().getResource("/sound/pick.wav");
        soundURL[14] = getClass().getResource("/sound/monster_damage.wav");

    }
    public void setFile(int i){
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            fc = (FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            checkVolume();
            
        } catch (Exception e) {
        }
    }
    public void play(){
        clip.start();
    }

    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
    public void checkVolume(){
        switch(volumeScale){
            case 0:
                volume =  -80f;
                break;
            case 1:
                volume = -20f;
                break;
            case 2:
                volume = -12f;
                break;
            case 3:
                volume = -5f;
                break;
            case 4:
                volume = 1f;
                break;
            case 5:
                volume = 6f;
                break;
        }
        fc.setValue(volume);
    }
}
