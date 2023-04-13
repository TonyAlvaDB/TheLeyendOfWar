/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class Player extends Entity{
    GamePanel gamePanel;
    KeyHandler keyH;
    
    public Player(GamePanel gamePanel, KeyHandler keyH){
        this.gamePanel = gamePanel;
        this.keyH = keyH;
        getPlayerImage();
        setDefaultValues();
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 1;
        direction = "down";
    }
    
    public void getPlayerImage(){
        try {
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_up_2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_up_3.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_down_2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_down_3.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_left_2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_left_3.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_right_2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("player/soldier_right_3.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void update(){
        if(keyH.upPressed){
            y-=speed;
            direction = "up";
        }
            
        if(keyH.downPressed){
            y+=speed;
            direction = "down";
        }
            
        if(keyH.leftPressed){
            x-=speed;
            direction = "left";
        }
            
        if(keyH.rightPressed){
            x+=speed;
            direction = "right";
        }
            
        spriteCounter++;
        
        spriteCounter++;
        if(spriteCounter ==100){
            spriteNum++;
            if(spriteNum > 4)
                spriteNum = 1;
            spriteCounter = 0;
        }
            
        
    }
    public void draw(Graphics g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1)
                    image = up1;
                if(spriteNum == 2)
                    image = up2;
                if(spriteNum == 3)
                    image = up3;
                if(spriteNum == 4)
                    image = up2;
                break;
            case "down":
                if(spriteNum ==1)
                    image = down1;
                if(spriteNum == 2)
                    image = down2;
                if(spriteNum == 3)
                    image = down3;
                if(spriteNum == 4)
                    image = down2;
                break;
            case "left":
                if(spriteNum ==1)
                    image = left1;
                if(spriteNum == 2)
                    image = left2;
                if(spriteNum == 3)
                    image = left3;
                if(spriteNum == 4)
                    image = left2;
                break;
            case "right":
                if(spriteNum ==1)
                    image = right1;
                if(spriteNum == 2)
                    image = right2;
                if(spriteNum == 3)
                    image = right3;
                if(spriteNum == 4)
                    image = right2;
                break;                
        }
        g2.drawImage(image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
 
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
        
        
    }
}
