/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class ObjectSword extends Entity{
    
    public ObjectSword(GamePanel gamePanel) {
        super(gamePanel);
        type = TYPE_SWORD;
        name = "Sword";
        down1 = setup("objects/sword.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        attackValue = 1;
        attackArea.width = 36; 
        attackArea.height = 36; 
        description = "[" + name + "] \nHecha en no se sabe";

    }
    
}
