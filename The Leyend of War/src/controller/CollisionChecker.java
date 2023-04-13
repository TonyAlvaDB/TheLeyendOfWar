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
    
    public int checkObject(Entity entity, boolean player){
    
        int index = 999;
        
        for (int i = 0; i < gamePanel.obj.length; i++) {
            if(gamePanel.obj[i] != null){
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;
                
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].worldX + gamePanel.obj[i].solidArea.x;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].worldY + gamePanel.obj[i].solidArea.y;
                
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if(gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }    
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if(gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }    
                            if(player == true){
                                index = i;
                            } 
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if(gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }    
                            if(player == true){
                                index = i;
                            } 
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gamePanel.obj[i].solidArea)){
                            if(gamePanel.obj[i].collision == true){
                                entity.collisionOn = true;
                            }    
                            if(player == true){
                                index = i;
                            } 
                        }
                        break;
                    
                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gamePanel.obj[i].solidArea.x = gamePanel.obj[i].solidAreaDefaultX;
                gamePanel.obj[i].solidArea.y = gamePanel.obj[i].solidAreaDefaultY;
            }
        }
        
        return index;
    }
}
