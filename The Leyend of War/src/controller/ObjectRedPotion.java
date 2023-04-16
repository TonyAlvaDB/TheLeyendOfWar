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
public class ObjectRedPotion extends Entity{
    GamePanel gamePanel;
    int value = 5;
    
    public ObjectRedPotion(GamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        type = CONSUMABLE;
        name = "Pocion Roja";
        down1= setup("objects/red_potion.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        description = "[Pocion Roja] \nte cura por " + value + ".";
    }
    public void use(Entity entity){
        gamePanel.gameState = gamePanel.DIALOGUE_STATE;
        gamePanel.ui.currentDialogue = "Bebiste la " + name + "! \nte recuperaste por " + value +".";
        entity.life += value;
        if (gamePanel.player.life > gamePanel.player.maxLife){
            gamePanel.player.life = gamePanel.player.maxLife;
        }
        gamePanel.playSFX(9);
    }

}
