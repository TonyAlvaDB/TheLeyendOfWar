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
public class ObjectHeart extends Entity{
    

    
    public ObjectHeart(GamePanel gamePanel){
 
        super(gamePanel);
        name = "Heart";
        image = setup("objects/full_heart.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        image2 = setup("objects/mid_heart.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        image3 = setup("objects/empty_heart.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
       
        
    }
}
