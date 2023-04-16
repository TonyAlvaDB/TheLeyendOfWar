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
import java.util.ArrayList;
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
    BufferedImage full_heart, mid_heart, empty_heart, crystal_full, crystal_blank;
    public boolean messageOn = false;
    ArrayList<String>message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();
    public boolean gameFinished = false;
    public String currentDialogue = "";
    public int slotCol = 0;
    public int slotRow = 0;
    int subState = 0;
    public int commandNum = 0;

    
    public UI(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80B = new Font("Arial", Font.BOLD, 80);
        
        Entity heart = new ObjectHeart(gamePanel);
        full_heart = heart.image;
        mid_heart = heart.image2;
        empty_heart = heart.image3;
        
        Entity crystal = new ObjectMana(gamePanel);
        crystal_full = crystal.image;
        crystal_blank = crystal.image2;
    }

    public void addMessage(String text){
        message.add(text);
        messageCounter.add(0);
    }
    
    public void draw(Graphics2D g2){
        
        if(gamePanel.gameState == gamePanel.TITLE_STATE){
            drawTitleScreen(g2);
        }
        
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        
        if(gamePanel.gameState == gamePanel.PLAY_STATE){
            drawPlayerLife();
            drawMessage();
        }
        if(gamePanel.gameState == gamePanel.PAUSE_STATE){
            drawPlayerLife();
            drawPauseScreen();
            
        }
        if(gamePanel.gameState == gamePanel.DIALOGUE_STATE){
            drawPlayerLife();
            drawDialogueScreen();
        }
        if(gamePanel.gameState == gamePanel.CHARACTER_STATE){
            drawCharacterScreen();
            drawInventory();
        }
        if(gamePanel.gameState == gamePanel.OPTIONS_STATE){
            drawOptionsScreen();
        }
        if(gamePanel.gameState == gamePanel.OVER_STATE){
            drawGameOverScreen();
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

    private void drawPlayerLife() {
        int x = gamePanel.TILE_SIZE/2;
        int y = gamePanel.TILE_SIZE/2;
        int i = 0;
        while(i < gamePanel.player.maxLife/2){
            g2.drawImage(empty_heart, x, y, null);
            i++;
            x += gamePanel.TILE_SIZE;
        }
        x = gamePanel.TILE_SIZE/2;
        y = gamePanel.TILE_SIZE/2;
        i = 0;
        while(i < gamePanel.player.life){
            g2.drawImage(mid_heart, x, y, null);
            i++;
            if(i < gamePanel.player.life){
                g2.drawImage(full_heart, x, y, null);
            }
            i++;
            x+= gamePanel.TILE_SIZE;
        }
        
        x = gamePanel.TILE_SIZE / 2;
        y = gamePanel.TILE_SIZE / 2;
        i = 0;
        while (i < gamePanel.player.maxMana){
            g2.drawImage(crystal_blank, x, y+50, null);
            i++;
            x += 35;
            
        }
        
        x = gamePanel.TILE_SIZE / 2;
        y = gamePanel.TILE_SIZE / 2;
        i = 0;
        
        while (i < gamePanel.player.mana){
            g2.drawImage(crystal_full, x, y+50, null);
            i++;
            x += 35;
        }
        
    }

    private void drawCharacterScreen() {
        final int FRAME_X = gamePanel.TILE_SIZE*2;
        final int FRAME_Y = gamePanel.TILE_SIZE;
        final int FRAME_WIDTH = gamePanel.TILE_SIZE*5;
        final int FRAME_HEIGHT = gamePanel.TILE_SIZE*10;
        
        drawSubWindow(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
        
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        
        int textX = FRAME_X+ 20;
        int textY = FRAME_Y + gamePanel.TILE_SIZE;
        final int lineHeight = 35;
        g2.drawString("Nivel", textX, textY);
        textY += lineHeight;
        g2.drawString("Vida", textX, textY);
        textY += lineHeight;
        g2.drawString("Mana", textX, textY);
        textY += lineHeight;
        g2.drawString("Fortaleza", textX, textY);
        textY += lineHeight;
        g2.drawString("Temple", textX, textY);
        textY += lineHeight;
        g2.drawString("Ataque", textX, textY);
        textY += lineHeight;
        g2.drawString("Defensa", textX, textY);
        textY += lineHeight;
        g2.drawString("Exp", textX, textY);
        textY += lineHeight;
        g2.drawString("Prox Nivel", textX, textY);
        textY += lineHeight;
        g2.drawString("Plata", textX, textY);
        textY += lineHeight + 20;
        g2.drawString("Arma", textX, textY);
        textY += lineHeight + 15;
        g2.drawString("Escudo", textX, textY);
        textY += lineHeight;
        
        
        int tailX = (FRAME_X + FRAME_WIDTH) - 30;
        textY = FRAME_Y + gamePanel.TILE_SIZE;
        
        String value;
        value = String.valueOf(gamePanel.player.level);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.life + "/" + gamePanel.player.maxLife);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.mana + "/" + gamePanel.player.maxMana);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.strength);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.dexterity);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.attack);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.defense);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.exp);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.nextLevelExp);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        value = String.valueOf(gamePanel.player.coin);
        textX = getXForAlignToRightText(value, tailX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;
        g2.drawImage(gamePanel.player.currentWeapon.down1, tailX-gamePanel.TILE_SIZE, textY-25, null);
        textY += 48;
        g2.drawImage(gamePanel.player.currentShield.down1, tailX-gamePanel.TILE_SIZE, textY-25, null);

    }
    
    public int getXForAlignToRightText(String text, int tailX){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = tailX - length;
        return x;
    }

    private void drawMessage() {
        int messageX = gamePanel.TILE_SIZE;
        int messageY = gamePanel.TILE_SIZE * 4;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 32F));
        for (int i = 0; i < message.size(); i++) {
            if(message.get(i) != null){
                g2.setColor(Color.white);
                g2.drawString(message.get(i), messageX, messageY);
                
                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += 50;
                if(messageCounter.get(i) > 180){
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
        }
        
    }

    private void drawInventory() {
        int frameX = gamePanel.TILE_SIZE * 9;
        int frameY = gamePanel.TILE_SIZE;
        int frameWidth = gamePanel.TILE_SIZE * 6;
        int frameHeight = gamePanel.TILE_SIZE * 5;
        
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        final int SLOT_X_START = frameX + 20;
        final int SLOT_Y_START = frameY + 20;
        int slotX = SLOT_X_START;
        int slotY = SLOT_Y_START;
        int slotSize = gamePanel.TILE_SIZE + 3;
        
        for (int i = 0; i < gamePanel.player.inventory.size(); i++) {
            
            if(gamePanel.player.inventory.get(i) == gamePanel.player.currentWeapon ||
                    gamePanel.player.inventory.get(i) == gamePanel.player.currentShield){
                g2.setColor(new Color(240, 190, 90));
                g2.fillRoundRect(slotX, slotY, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, 10, 10);
            }
            
            g2.drawImage(gamePanel.player.inventory.get(i).down1, slotX, slotY, null);
            slotX += slotSize;
            if(i == 4 || i == 9 || i == 14){
                slotX = SLOT_X_START;
                slotY += slotSize;
            }
        }
        
        int cursorX = SLOT_X_START + (slotSize*slotCol);
        int cursorY = SLOT_Y_START + (slotSize*slotRow);;
        int cursorWidth = gamePanel.TILE_SIZE;
        int cursorHeight = gamePanel.TILE_SIZE;
        
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(3));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);
        
        int dFrameX = frameX;
        int dFrameY = frameY + frameHeight;
        int dFrameWidht = frameWidth;
        int dFrameHeight = gamePanel.TILE_SIZE*3;
        
        
        int textX = dFrameX + 20;
        int textY = dFrameY + gamePanel.TILE_SIZE;
        g2.setFont(g2.getFont().deriveFont(20F));
        int itemIndex = getItemIndexOnSlot();
        if(itemIndex < gamePanel.player.inventory.size()){
            
            drawSubWindow(dFrameX, dFrameY, dFrameWidht, dFrameHeight);
            
            for(String line : gamePanel.player.inventory.get(itemIndex).description.split("\n")){
                g2.drawString(line, textX, textY);
                textY += 32;
            }
            
        }
        
        
        
    }
    int getItemIndexOnSlot(){
        int itemIndex = slotCol + (slotRow * 5);
        return itemIndex;
    }

    private void drawOptionsScreen() {
        g2.setColor(Color.white);
        g2.setFont(g2.getFont().deriveFont(32F));
        
        int frameX = gamePanel.TILE_SIZE*4;
        int frameY = gamePanel.TILE_SIZE;
        int frameWidth = gamePanel.TILE_SIZE*8;
        int frameHeight = gamePanel.TILE_SIZE*10;
        
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);
        switch(subState){
            case 0:
                optionTop(frameX, frameY);
                break;
            case 1:
                optionsControl(frameX, frameY);
                break;
            case 2:
                optionsEndGameConfirmation(frameX, frameY);
                break;
        }
        gamePanel.keyH.enterPressed = false;
                
        
    }
    public void optionTop(int frameX, int frameY){
        int textX;
        int textY;
        String text = "Options";
        textX = getXforCenteredText(text);
        textY = frameY + gamePanel.TILE_SIZE;
        g2.drawString(text, textX, textY);
        
        textX = frameX + gamePanel.TILE_SIZE;
        textY += gamePanel.TILE_SIZE*2;
        g2.drawString("Musica", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
        }
        
        textY += gamePanel.TILE_SIZE;
        g2.drawString("SFX", textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX-25, textY);
        }        
        
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Controles", textX, textY);
        if(commandNum == 2){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                subState = 1;
                commandNum = 0;
            }
        }        
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Salir", textX, textY);
        if(commandNum == 3){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                subState = 2;
                commandNum = 0;
            }
        }        
        textY += gamePanel.TILE_SIZE*2;
        g2.drawString("Atras", textX, textY);
        if(commandNum == 4){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                gamePanel.gameState = gamePanel.PLAY_STATE;
                commandNum = 0;
                
            } 
        }        
        textX = frameX + (int)(gamePanel.TILE_SIZE * 4.5);
        textY = frameY + gamePanel.TILE_SIZE * 2 + 24;
        g2.setStroke(new BasicStroke(3));
        g2.drawRect(textX, textY, 120, 24);
        int volumeWidth = 24 * gamePanel.soundMusic.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);
        
        textY += gamePanel.TILE_SIZE;
        g2.drawRect(textX, textY, 120, 24);
        volumeWidth = 24 * gamePanel.soundSFX.volumeScale;
        g2.fillRect(textX, textY, volumeWidth, 24);
        
    }
    private void optionsEndGameConfirmation(int frameX, int frameY) {
        int textX = frameX + gamePanel.TILE_SIZE;
        int textY = frameY + gamePanel.TILE_SIZE*3;
        
        currentDialogue = "Salir del juego \nRegresar";
        
        for (String line: currentDialogue.split("\n")){
            g2.drawString(line, textX, textY);
            textY +=40;
        }
        
        String text = "Yes";
        textX = getXforCenteredText(text);
        textY += gamePanel.TILE_SIZE * 3;
        g2.drawString(text, textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                subState = 0;
                gamePanel.gameState = gamePanel.TITLE_STATE;
            }
        }
        
        text = "No";
        textX = getXforCenteredText(text);
        textY += gamePanel.TILE_SIZE;
        g2.drawString(text, textX, textY);
        if(commandNum == 1){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                subState = 0;
                commandNum = 3;
            }
        }
        
    }
    public void optionsControl(int frameX, int frameY){
        int textX;
        int textY;
        
        String text = "Controles";
        textX = getXforCenteredText(text);
        textY = frameY + gamePanel.TILE_SIZE;
        g2.drawString(text, textX, textY);
        
        textX = frameX + gamePanel.TILE_SIZE;
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Moverse", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Atacar", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Disparar", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Personaje", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Pausa", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("Opciones", textX, textY);
        textY += gamePanel.TILE_SIZE;
        
        textX = frameX + gamePanel.TILE_SIZE * 5;
        textY = frameY + gamePanel.TILE_SIZE * 2;
        g2.drawString("WASD", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("ENTER", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("F", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("C", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("P", textX, textY);
        textY += gamePanel.TILE_SIZE;
        g2.drawString("ESCAPE", textX, textY);
        textY += gamePanel.TILE_SIZE;
                
        textX = frameX + gamePanel.TILE_SIZE;
        textY = frameY + gamePanel.TILE_SIZE * 9;
        g2.drawString("Back", textX, textY);
        if(commandNum == 0){
            g2.drawString(">", textX-25, textY);
            if(gamePanel.keyH.enterPressed == true){
                subState = 0;
                commandNum = 2;
            }
        }
    }

    private void drawGameOverScreen() {
        
        g2.setColor(new Color(0, 0, 0, 150));
        g2.fillRect(0, 0, gamePanel.SCREEN_WIDTH, gamePanel.SCREEN_HEIGHT);
        
        int x;
        int y;
        String text;
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110F));
        text = "GameOver";
        g2.setColor(Color.black);
        x = getXforCenteredText(text);
        y = gamePanel.TILE_SIZE * 4;
        g2.drawString(text, x, y);
        
        g2.setColor(Color.white);
        g2.drawString(text, x-4, y-4);
        
        g2.setFont(g2.getFont().deriveFont(50F));
        text = "Reintentar";
        x = getXforCenteredText(text);
        y += gamePanel.TILE_SIZE * 4;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">", x-40, y);
        }
        
        
        text = "Salir";
        x = getXforCenteredText(text);
        y += 55;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">", x-40, y);
        }
        
        
        
        
    }


        
}
