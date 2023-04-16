/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.Random;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class MonsterGreenSlime extends Entity{

    public MonsterGreenSlime(GamePanel gamePanel) {
        super(gamePanel);
        type = TYPE_MONSTER;
        name = "Slime Amarillo";
        speed = 1;
        maxLife = 8;
        life = maxLife;
        attack = 5;
        defense = 0;
        exp = 2;
        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }
    
    public void getImage(){
        up1 = setup("monster/slime_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("monster/slime_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up3 = setup("monster/slime_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("monster/slime_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("monster/slime_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down3 = setup("monster/slime_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("monster/slime_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("monster/slime_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left3 = setup("monster/slime_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("monster/slime_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("monster/slime_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right3 = setup("monster/slime_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }
    public void setAction(){
        actionLockCounter++;
        
        if(actionLockCounter == 100){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
                
    }
    public void damageReaction(){
        actionLockCounter = 0;
        direction = gamePanel.player.direction;
    }
}
