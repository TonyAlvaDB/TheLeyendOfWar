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
        
        name = "YellowSlime";
        speed = 1;
        maxLife = 4;
        life = maxLife;
        
        solidArea.x = 3;
        solidArea.y = 18;
        solidArea.width = 42;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        getImage();
    }
    
    public void getImage(){
        up1 = setup("monster/slime_1.png");
        up2 = setup("monster/slime_2.png");
        up3 = setup("monster/slime_3.png");
        down1 = setup("monster/slime_1.png");
        down2 = setup("monster/slime_2.png");
        down3 = setup("monster/slime_3.png");
        left1 = setup("monster/slime_1.png");
        left2 = setup("monster/slime_2.png");
        left3 = setup("monster/slime_3.png");
        right1 = setup("monster/slime_1.png");
        right2 = setup("monster/slime_2.png");
        right3 = setup("monster/slime_3.png");
    }
    public void setAction(){
        actionLockCounter++;
        
        if(actionLockCounter == 400){
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
}
