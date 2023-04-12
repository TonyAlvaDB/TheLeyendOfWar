/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics2D;
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
    }

    public void setDefaultValues(){
        x = 100;
        y = 100;
        speed = 4;
    }
    
    public void update(){
        
    }
    public void draw(Graphics2D g2){
        
    }
}
