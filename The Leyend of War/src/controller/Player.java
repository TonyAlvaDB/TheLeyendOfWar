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
        
        
        getPlayerAttackImage();
        getPlayerImage();
        setDefaultValues();
        

    }

    public void setDefaultValues() {

        worldX = gamePanel.TILE_SIZE * 24;
        worldY = gamePanel.TILE_SIZE * 25;
        speed = 3;
        direction = "down";
        maxLife = 6;
        life = maxLife;

    }

    public void getPlayerImage() {

        up1 = setup("player/soldier_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("player/soldier_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up3 = setup("player/soldier_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("player/soldier_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("player/soldier_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down3 = setup("player/soldier_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("player/soldier_left_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("player/soldier_left_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left3 = setup("player/soldier_left_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("player/soldier_right_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("player/soldier_right_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right3 = setup("player/soldier_right_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

    public void getPlayerAttackImage() {

        attackUp1 = setup("player/attack_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackUp2 = setup("player/attack_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackUp3 = setup("player/attack_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown1 = setup("player/attack_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown2 = setup("player/attack_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown3 = setup("player/attack_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackLeft1 = setup("player/attack_left_1.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackLeft2 = setup("player/attack_left_2.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackLeft3 = setup("player/attack_left_3.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight1 = setup("player/attack_right_1.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight2 = setup("player/attack_right_2.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight3 = setup("player/attack_right_3.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);

    }

    public void update() {
        if (attacking == true) {
            attacking();
        } else if (keyH.upPressed == true
                || keyH.downPressed == true
                || keyH.leftPressed == true
                || keyH.rightPressed == true
                || keyH.enterPressed == true) {
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

            int monsterIndex = gamePanel.cChecker.checkEntity(this, gamePanel.monster);
            contactMonster(monsterIndex);

            gamePanel.eHander.checkEvent();

            if (collisionOn == false && keyH.enterPressed == false) {
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
            
            gamePanel.keyH.enterPressed = false;
            gamePanel.keyH.spacePressed = false;
            
            spriteCounter++;
            if (spriteCounter == 15) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 90) {
                invincible = false;
                invincibleCounter = 0;
            }
        }

    }

    public void pickupObject(int i) {
        if (i != 999) {

        }
    }

    private void interactNpc(int i) {
        if (gamePanel.keyH.enterPressed == true) {
            if (i != 999) {
                gamePanel.gameState = gamePanel.DIALOGUE_STATE;
                gamePanel.npc[i].speak();
            } else {
                if (gamePanel.keyH.spacePressed == true) {
                    attacking = true;
                }
            }
        }
    }

    public void draw(Graphics g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (attacking == false) {
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
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackUp1;
                    }
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                    if (spriteNum == 3) {
                        image = attackUp3;
                    }
                    if (spriteNum == 4) {
                        image = attackUp3;
                    }
                }
                break;
            case "down":
                if (attacking == false) {
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
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackDown1;
                    }
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                    if (spriteNum == 3) {
                        image = attackDown3;
                    }
                    if (spriteNum == 4) {
                        image = attackDown3;
                    }
                }
                break;
            case "left":
                if (attacking == false) {
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
                }
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackLeft1;
                    }
                    if (spriteNum == 2) {
                        image = attackLeft2;
                    }
                    if (spriteNum == 3) {
                        image = attackLeft3;
                    }
                    if (spriteNum == 4) {
                        image = attackLeft3;
                    }
                }
                break;
            case "right":
                if (attacking == false) {
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
                }

                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackRight1;
                    }
                    if (spriteNum == 2) {
                        image = attackRight2;
                    }
                    if (spriteNum == 3) {
                        image = attackRight3;
                    }
                    if (spriteNum == 4) {
                        image = attackRight3;
                    }
                }
                break;

        }
        g2.drawImage(image, SCREEN_X, SCREEN_Y, null);

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

    private void contactMonster(int i) {
        if (i != 999) {
            if (invincible == false) {
                life -= 1;
                invincible = true;
            }

        }
    }

    private void attacking() {
        spriteCounter++;
        if(spriteCounter <=5){
            spriteNum = 1;
        }
        if (spriteCounter > 5 && spriteCounter <=25){
            spriteNum = 2;
        }
        if(spriteCounter > 25){
            spriteNum = 1;
            spriteCounter = 0;
            attacking=false;
        }
    }

}
