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
    EventRect eventRect[][];
    
    int previousEventX, previousEventY;
    boolean canTouchEvent = true;
    
    
    public EventHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        eventRect = new EventRect[gamePanel.MAX_WORLD_COL][gamePanel.MAX_WORLD_ROW];
        int col = 0;
        int row = 0;
        while(col < gamePanel.MAX_WORLD_COL && row < gamePanel.MAX_WORLD_ROW){
            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 23;
            eventRect[col][row].y = 23;
            eventRect[col][row].width = 2;
            eventRect[col][row].height = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].y;
            col++;
            if(col == gamePanel.MAX_WORLD_COL){
                col = 0;
                row++;
            }
        }
        
    }

    public void checkEvent(){
        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX);
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);
        if(distance > gamePanel.TILE_SIZE)
            canTouchEvent = true;
        
        if(hit(21,25, "any") == true){
            damagePit(21, 25, gamePanel.DIALOGUE_STATE);
        }
    }
    public boolean hit(int col, int row, String reqDirection){
        boolean hit = false;
        
        gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
        eventRect[col][row].x = col*gamePanel.TILE_SIZE+eventRect[col][row].x;
        eventRect[col][row].y = row*gamePanel.TILE_SIZE+eventRect[col][row].y;
        
        if(gamePanel.player.solidArea.intersects(eventRect[col][row]) && eventRect[col][row].eventDone==false){
            if(gamePanel.player.direction.equals(reqDirection) || reqDirection.contentEquals("any")){
                hit = true;
                previousEventX = gamePanel.player.worldX;
                previousEventY = gamePanel.player.worldY;
            }
            
        }
        gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;
        
        return hit;
    }

    private void damagePit(int col, int row, int gameState) {
        gamePanel.gameState = gameState;
        gamePanel.ui.currentDialogue = "Caiste en un pozo \nEl pozo se lleno de tierra";
        gamePanel.playSFX(4);
        gamePanel.player.life -= 1;
        eventRect[col][row].eventDone = true;
        canTouchEvent = false;
    }
}
