/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import view.GamePanel;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
public class Player extends Entity {

    KeyHandler keyH;

    public final int SCREEN_X;
    public final int SCREEN_Y;

    public Player(GamePanel gamePanel, KeyHandler keyH) {
        
        super(gamePanel);
        

        this.keyH = keyH;

        SCREEN_X = (gamePanel.SCREEN_WIDTH / 2) - (gamePanel.TILE_SIZE / 2);
        SCREEN_Y = (gamePanel.SCREEN_HEIGHT / 2) - (gamePanel.TILE_SIZE / 2);

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 33;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 15;
        solidArea.height = 15;

        getPlayerImage();
        setDefaultValues();
    }

    public void setDefaultValues() {
        
        worldX = gamePanel.TILE_SIZE * 24;
        worldY = gamePanel.TILE_SIZE * 25;
        speed = 1;
        direction = "down";
        maxLife = 6;
        life = maxLife;
        
    }

    public void getPlayerImage() {
       
        up1 = setup("player/soldier_up_1.png");
        up2 = setup("player/soldier_up_2.png");
        up3 = setup("player/soldier_up_3.png");
        down1 = setup("player/soldier_down_1.png");
        down2 = setup("player/soldier_down_2.png");
        down3 = setup("player/soldier_down_3.png");
        left1 = setup("player/soldier_left_1.png");
        left2 = setup("player/soldier_left_2.png");
        left3 = setup("player/soldier_left_3.png");
        right1 = setup("player/soldier_right_1.png");
        right2 = setup("player/soldier_right_2.png");
        right3 = setup("player/soldier_right_3.png");
    }

    
    public void update() {
        if (keyH.upPressed == true || keyH.downPressed == true || keyH.leftPressed == true || keyH.rightPressed == true) {
            if (keyH.upPressed) {

                direction = "up";
            }

            if (keyH.downPressed) {

                direction = "down";
            }

            if (keyH.leftPressed) {

                direction = "left";
            }

            if (keyH.rightPressed) {

                direction = "right";
            }

            collisionOn = false;
            gamePanel.cChecker.checkTile(this);
            
            int objectIndex = gamePanel.cChecker.checkObject(this, true);
            pickupObject(objectIndex);

            int npcIndex = gamePanel.cChecker.checkEntity(this, gamePanel.npc);
            interactNpc(npcIndex);
            
            gamePanel.eHander.checkEvent();
            
            gamePanel.keyH.enterPressed = false;
            
            if (collisionOn == false) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }

            }

            spriteCounter++;
            if (spriteCounter == 50) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

    }
    
    public void pickupObject(int i){
        if(i != 999){
            
        }
    }
    
    private void interactNpc(int i) {
        if(i != 999){
            if(gamePanel.keyH.enterPressed == true){
                gamePanel.gameState = gamePanel.DIALOGUE_STATE;
                gamePanel.npc[i].speak();
            }
            
        }
        
    }

    public void draw(Graphics g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right2;
                }
                break;
        }
        g2.drawImage(image, SCREEN_X, SCREEN_Y, null);

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

    
}
