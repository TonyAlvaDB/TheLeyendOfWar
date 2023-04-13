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
public class ObjectChest extends SuperObject{
    GamePanel gamePanel;
    public ObjectChest(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Chest";
        
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/chest_2.png"));
            uTool.scaleImage(image, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        
    }
}
