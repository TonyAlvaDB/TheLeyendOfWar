/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class SuperObject {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    
    public void draw(Graphics2D g2, GamePanel gamePanel){
        int screenX =  worldX - gamePanel.player.worldX + gamePanel.player.SCREEN_X;
        int screenY =  worldY - gamePanel.player.worldY + gamePanel.player.SCREEN_Y;
            
        if(worldX > gamePanel.player.worldX - gamePanel.player.SCREEN_X - gamePanel.TILE_SIZE*2 &&
            worldX < gamePanel.player.worldX + gamePanel.player.SCREEN_X + gamePanel.TILE_SIZE*2 &&
            worldY > gamePanel.player.worldY - gamePanel.player.SCREEN_Y - gamePanel.TILE_SIZE*2 &&
            worldY < gamePanel.player.worldY + gamePanel.player.SCREEN_Y + gamePanel.TILE_SIZE*2){
            g2.drawImage(image, screenX, screenY,gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
        }
    }
}
