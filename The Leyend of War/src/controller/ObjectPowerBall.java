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
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }

    private void getImage() {
        
        up1 = setup("objects/power_ball_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("objects/power_ball_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("objects/power_ball_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("objects/power_ball_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("objects/power_ball_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("objects/power_ball_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("objects/power_ball_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("objects/power_ball_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
    }
    
    public boolean haveResource(Entity user){
        boolean haveResource = false;
        if(user.mana >= useCost){
            haveResource = true;
        }
        return haveResource;
        
        
    }
    
    public void subtractResource(Entity user){
        user.mana -= useCost;
    }

}
