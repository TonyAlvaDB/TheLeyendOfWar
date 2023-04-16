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
public class ObjectShield extends Entity{

    public ObjectShield(GamePanel gamePanel) {
        super(gamePanel);
        name = "Shield";
        down1 = setup("objects/shield.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        defenseValue = 1;
    }

    
}
