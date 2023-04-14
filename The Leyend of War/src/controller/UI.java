/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
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
public class UI {
    GamePanel gamePanel;
    Font arial_40, arial_80B;
    Graphics2D g2;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue = "";

    
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
        
        if(gamePanel.gameState == gamePanel.TITLE_STATE){
            drawTitleScreen(g2);
        }
        
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        if(gamePanel.gameState == gamePanel.PLAY_STATE){
            
        }
        if(gamePanel.gameState == gamePanel.PAUSE_STATE){
            drawPauseScreen();
        }
        if(gamePanel.gameState == gamePanel.DIALOGUE_STATE){
            drawDialogueScreen();
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

    private void drawDialogueScreen() {
        
        int x = gamePanel.TILE_SIZE *2;
        int y = gamePanel.TILE_SIZE /2;
        int width = gamePanel.SCREEN_WIDTH - (gamePanel.TILE_SIZE*4);
        int height = gamePanel.TILE_SIZE * 4;
        
        drawSubWindow(x, y, width, height);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN));
        x += gamePanel.TILE_SIZE;
        y += gamePanel.TILE_SIZE;
        
        for (String line : currentDialogue.split("\n")){
            g2.drawString(line, x, y);
            y +=40;
        }
    }
    
    public void drawSubWindow(int x, int y, int width, int height){
        Color c = new Color(0, 0, 0, 220);
        g2.setColor(c);
        g2.fillRoundRect(x, y, width, height, 35, 35);
        
        c = new Color(255, 255, 255);
        g2.setColor(c);
        g2.setStroke(new BasicStroke(5));
        g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
        
    }

    private void drawTitleScreen(Graphics2D g2) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("background/background.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g2.drawImage(image,0, 0,gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT + (gamePanel.TILE_SIZE*3), null);
        
    }
    
}
