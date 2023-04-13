/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class UI {
    GamePanel gamePanel;
    Font arial_40, arial_80B;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime;
    DecimalFormat dFormat = new DecimalFormat("#0.00");
    
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    
    public void draw(Graphics2D g2){
        
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        if(gamePanel.gameState == gamePanel.PLAY_STATE){
            
        }
        if(gamePanel.gameState == gamePanel.PAUSE_STATE){
            drawPauseScreen();
        }
        
    }
    public void drawPauseScreen(){
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80f));
        String text = "JUEGO EN PAUSA";
        
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = getXforCenteredText(text);
        int y = gamePanel.SCREEN_HEIGHT/2;
        
        
        g2.drawString(text, x, y);
        
    }
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = (gamePanel.SCREEN_WIDTH/2) - (length/2);
        return x;

    }
    
}
