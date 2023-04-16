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
public class ObjectCoin extends Entity{

    GamePanel gamePanel;
    
    public ObjectCoin(GamePanel gamePanel) {
        super(gamePanel);
        this.gamePanel = gamePanel;
        
        type = PICK;
        name = "Moneda";
        value = 1;
        down1 =  setup("objects/coin.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
            
    }
    public void use(Entity entity){
        gamePanel.playSFX(12);
        gamePanel.ui.addMessage("Moneda + " + value);
        gamePanel.player.coin += value;
    }
}
