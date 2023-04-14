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
public class ObjectHeart extends SuperObject{
    
    GamePanel gamePanel;
    
    public ObjectHeart(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        name = "Heart";
        
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/full_heart.png"));
            image2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/mid_heart.png"));
            image3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("objects/empty_heart.png"));
            image = uTool.scaleImage(image, gamePanel.TILE_SIZE-5, gamePanel.TILE_SIZE-5);
            image2 = uTool.scaleImage(image2, gamePanel.TILE_SIZE-5, gamePanel.TILE_SIZE-5);
            image3 = uTool.scaleImage(image3, gamePanel.TILE_SIZE-5, gamePanel.TILE_SIZE-5);
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
        
    }
}
