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
public class AssetSetter {
    GamePanel gamePanel;
    
    public AssetSetter(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void setObject(){
        
    
    }
    
    public void setNpc(){
        gamePanel.npc[0] = new NpcMage(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.TILE_SIZE*21;
        gamePanel.npc[0].worldY = gamePanel.TILE_SIZE*21;  
    }
    public void setMonster(){
        gamePanel.monster[0] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[0].worldX = gamePanel.TILE_SIZE * 20;
        gamePanel.monster[0].worldY = gamePanel.TILE_SIZE * 23;
    
        gamePanel.monster[1] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[1].worldX = gamePanel.TILE_SIZE * 4;
        gamePanel.monster[1].worldY = gamePanel.TILE_SIZE * 15;
    
        gamePanel.monster[2] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[2].worldX = gamePanel.TILE_SIZE * 4;
        gamePanel.monster[2].worldY = gamePanel.TILE_SIZE * 16;
    
        gamePanel.monster[3] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[3].worldX = gamePanel.TILE_SIZE * 44;
        gamePanel.monster[3].worldY = gamePanel.TILE_SIZE * 22;
    
        gamePanel.monster[4] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[4].worldX = gamePanel.TILE_SIZE * 43;
        gamePanel.monster[4].worldY = gamePanel.TILE_SIZE * 22;
       
        gamePanel.monster[5] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[5].worldX = gamePanel.TILE_SIZE * 43;
        gamePanel.monster[5].worldY = gamePanel.TILE_SIZE * 21;
    
    }
}
