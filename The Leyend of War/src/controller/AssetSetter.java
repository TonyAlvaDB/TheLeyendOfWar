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
        gamePanel.obj[0] = new ObjectKey();
        gamePanel.obj[0].worldX = 20 * gamePanel.TILE_SIZE;
        gamePanel.obj[0].worldY = 20 * gamePanel.TILE_SIZE;
    
        gamePanel.obj[1] = new ObjectKey();
        gamePanel.obj[1].worldX = 19 * gamePanel.TILE_SIZE;
        gamePanel.obj[1].worldY = 18 * gamePanel.TILE_SIZE;
    
    }
}
