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
            up1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_up_1.png"));
            up2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_up_2.png"));
            up3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_up_3.png"));
            down1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_down_1.png"));
            down2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_down_2.png"));
            down3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_down_3.png"));
            left1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_left_1.png"));
            left2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_left_2.png"));
            left3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_left_3.png"));
            right1 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_right_1.png"));
            right2 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_right_2.png"));
            right3 = ImageIO.read(getClass().getClassLoader().getResourceAsStream("/player/soldier_right_3.png"));
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
            
    }
    public void draw(Graphics g2){
        BufferedImage image = null;
        switch(direction){
            case "up":
                image = up1;
                break;
            case "down":
                image = down1;
                break;
            case "left":
                image = left1;
                break;
            case "right":
                image = right1;
                break;
        }
        g2.drawImage(image, x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE,);
 
//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
        
    }
}
