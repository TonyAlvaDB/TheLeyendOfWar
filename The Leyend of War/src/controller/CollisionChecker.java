/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class CollisionChecker {
    
    GamePanel gamePanel;
    
    public CollisionChecker(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void checkTile(Entity entity){
        
        int entityLeftWorldX = entity.worldX + entity.solidArea.x;
        int entityRightWorldX = entity.worldX + entity.solidArea.x + entity.solidArea.width;
        int entityTopWorldY = entity.worldY + entity.solidArea.y;
        int entityBottomWorldY = entity.worldY + entity.solidArea.y + entity.solidArea.height;
        
        int entityLeftCol = entityLeftWorldX/gamePanel.TILE_SIZE;
        int entityRightCol = entityRightWorldX/gamePanel.TILE_SIZE;
        int entityTopRow = entityTopWorldY/gamePanel.TILE_SIZE;
        int entityBottomRow = entityBottomWorldY/gamePanel.TILE_SIZE;
        
        int tileNum1, tileNum2;
        
        switch(entity.direction){
            case "up":
                entityTopRow = (entityTopWorldY-entity.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gamePanel.tileM.tile[tileNum1].collision == true ||
                        gamePanel.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "down":
                entityBottomRow = (entityBottomWorldY + entity.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileM.tile[tileNum1].collision == true ||
                        gamePanel.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "left":
                entityLeftCol = (entityLeftWorldX-entity.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityLeftCol][entityBottomRow];
                if(gamePanel.tileM.tile[tileNum1].collision == true ||
                        gamePanel.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
            case "right":
                entityRightCol = (entityRightWorldX+entity.speed) / gamePanel.TILE_SIZE;
                tileNum1 = gamePanel.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gamePanel.tileM.mapTileNum[entityRightCol][entityBottomRow];
                if(gamePanel.tileM.tile[tileNum1].collision == true ||
                        gamePanel.tileM.tile[tileNum2].collision == true)
                    entity.collisionOn = true;
                break;
    
        }
    }
}
