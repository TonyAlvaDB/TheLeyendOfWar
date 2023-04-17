/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.ObjectHeart;
import model.ObjectRedPotion;
import model.ObjectCoin;
import model.ObjectMana;
import model.ObjectBetterSword;
import model.ObjectBetterShield;
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
        gamePanel.obj[0] = new ObjectCoin(gamePanel);
        gamePanel.obj[0].worldX = gamePanel.TILE_SIZE*3;
        gamePanel.obj[0].worldY = gamePanel.TILE_SIZE*14;
        
        gamePanel.obj[1] = new ObjectCoin(gamePanel);
        gamePanel.obj[1].worldX = gamePanel.TILE_SIZE*2;
        gamePanel.obj[1].worldY = gamePanel.TILE_SIZE*30;
     
        gamePanel.obj[2] = new ObjectCoin(gamePanel);
        gamePanel.obj[2].worldX = gamePanel.TILE_SIZE*43;
        gamePanel.obj[2].worldY = gamePanel.TILE_SIZE*21;

        gamePanel.obj[3] = new ObjectBetterSword(gamePanel);
        gamePanel.obj[3].worldX = gamePanel.TILE_SIZE*22;
        gamePanel.obj[3].worldY = gamePanel.TILE_SIZE*34;

        gamePanel.obj[4] = new ObjectBetterShield(gamePanel);
        gamePanel.obj[4].worldX = gamePanel.TILE_SIZE*22;
        gamePanel.obj[4].worldY = gamePanel.TILE_SIZE*35;
     
        gamePanel.obj[5] = new ObjectRedPotion(gamePanel);
        gamePanel.obj[5].worldX = gamePanel.TILE_SIZE*20;
        gamePanel.obj[5].worldY = gamePanel.TILE_SIZE*35;
        
        gamePanel.obj[6] = new ObjectMana(gamePanel);
        gamePanel.obj[6].worldX = gamePanel.TILE_SIZE*24;
        gamePanel.obj[6].worldY = gamePanel.TILE_SIZE*24;
        
        gamePanel.obj[7] = new ObjectMana(gamePanel);
        gamePanel.obj[7].worldX = gamePanel.TILE_SIZE*24;
        gamePanel.obj[7].worldY = gamePanel.TILE_SIZE*34;
        
        gamePanel.obj[8] = new ObjectHeart(gamePanel);
        gamePanel.obj[8].worldX = gamePanel.TILE_SIZE*23;
        gamePanel.obj[8].worldY = gamePanel.TILE_SIZE*34;
        
    
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

        gamePanel.monster[6] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[6].worldX = gamePanel.TILE_SIZE * 2;
        gamePanel.monster[6].worldY = gamePanel.TILE_SIZE * 29;
    
    }
}
