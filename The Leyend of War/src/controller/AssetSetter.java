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
}
