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
public class ObjectEnemyBall extends Entity{
    
    GamePanel gamePanel;
    
    public ObjectEnemyBall(GamePanel gamePanel) {
        super(gamePanel);
        name = "Proyectil de enemigo";
        speed = 8;
        maxLife = 80;
        life = maxLife;
        attack = 2;
        useCost = 1;
        alive = false;
        getImage();
    }
    private void getImage() {
        
        up1 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("objects/enemy_ball.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
    }

}
