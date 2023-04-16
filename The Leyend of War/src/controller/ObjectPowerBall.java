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
public class ObjectPowerBall extends ObjectProyectile{

    GamePanel gamePanel;
    
    public ObjectPowerBall(GamePanel gamePanel) {
        
        super(gamePanel);
        
        this.gamePanel = gamePanel;
        
        name = "Proyectil de energia";
        speed = 5;
        maxLife = 20;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }

    private void getImage() {
        down1 = setup("objects/power_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

}
