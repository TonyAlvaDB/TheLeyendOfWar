/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Rectangle;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class EventHandler {
    GamePanel gamePanel;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;
    
    public EventHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        eventRect = new Rectangle();
        eventRect.x = 23;
        eventRect.y = 23;
        eventRect.width = 2;
        eventRect.height = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultX = eventRect.y;
    }

    public void checkEvent(){
        if(hit(21,25, "up") == true){
            damagePit(gamePanel.DIALOGUE_STATE);
        }
    }
    public boolean hit(int eventCol, int eventRow, String reqDirection){
        boolean hit = false;
        
        gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
        eventRect.x = eventCol*gamePanel.TILE_SIZE+eventRect.x;
        eventRect.y = eventRow*gamePanel.TILE_SIZE+eventRect.y;
        
        if(gamePanel.player.solidArea.intersects(eventRect)){
            if(gamePanel.player.direction.equals(reqDirection) || reqDirection.contentEquals("any"))
                hit = true;
        }
        gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;
        
        return hit;
    }

    private void damagePit(int gameState) {
        gamePanel.gameState = gameState;
        gamePanel.ui.currentDialogue = "Caiste en un pozo";
        gamePanel.player.life -= 1;
    }
}
