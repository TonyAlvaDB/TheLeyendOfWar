/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Entity;
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
public class ObjectChest extends Entity{

    public ObjectChest(GamePanel gamePanel){
        super(gamePanel);

        name = "Chest";
        down1 = setup("objects/chest_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }
        
}
