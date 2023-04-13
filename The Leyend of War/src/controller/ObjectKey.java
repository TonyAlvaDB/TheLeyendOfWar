/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.io.IOException;
import javax.imageio.ImageIO;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class ObjectKey extends SuperObject {
    
    GamePanel gamePanel;
    
    public ObjectKey(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Key";
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/key_1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        
    }
}
