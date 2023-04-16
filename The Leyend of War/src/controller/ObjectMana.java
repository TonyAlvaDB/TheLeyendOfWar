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
public class ObjectMana extends Entity{

    public ObjectMana(GamePanel gamePanel) {
        super(gamePanel);
    
        name = "Mana";
        image = setup("objects/mana_full.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        image2 = setup("objects/mana_empty.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
                
    }

}
