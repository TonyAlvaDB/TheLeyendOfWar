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
public class ObjectKey extends Entity {
    

    public ObjectKey(GamePanel gamePanel){
        super(gamePanel);
        name = "Key";
        
        down1 = setup("objects/key_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        description = "[" + name + "] \nNadie sabe que abre";
    }
}
