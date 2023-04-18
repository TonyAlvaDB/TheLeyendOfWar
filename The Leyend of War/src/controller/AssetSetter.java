/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.MonsterGreenSlime;
import model.NpcMage;
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
    
    //Coloca los objetos dentro del mapa
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
    //Coloca los NPC en el mapa
    public void setNpc(){
        gamePanel.npc[0] = new NpcMage(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.TILE_SIZE*21;
        gamePanel.npc[0].worldY = gamePanel.TILE_SIZE*21;  
    }
    //Coloca los monstruos dentro del mapa
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
        
        gamePanel.monster[7] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[7].worldX = gamePanel.TILE_SIZE * 2;
        gamePanel.monster[7].worldY = gamePanel.TILE_SIZE * 30;
        
        gamePanel.monster[8] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[8].worldX = gamePanel.TILE_SIZE * 10;
        gamePanel.monster[8].worldY = gamePanel.TILE_SIZE * 40;
        
        gamePanel.monster[9] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[9].worldX = gamePanel.TILE_SIZE * 10;
        gamePanel.monster[9].worldY = gamePanel.TILE_SIZE * 41;
        
        gamePanel.monster[10] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[10].worldX = gamePanel.TILE_SIZE * 9;
        gamePanel.monster[10].worldY = gamePanel.TILE_SIZE * 41;
        
        gamePanel.monster[11] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[11].worldX = gamePanel.TILE_SIZE * 40;
        gamePanel.monster[11].worldY = gamePanel.TILE_SIZE * 46;
        
        gamePanel.monster[12] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[12].worldX = gamePanel.TILE_SIZE * 39;
        gamePanel.monster[12].worldY = gamePanel.TILE_SIZE * 46;
        
        gamePanel.monster[13] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[13].worldX = gamePanel.TILE_SIZE * 25;
        gamePanel.monster[13].worldY = gamePanel.TILE_SIZE * 4;
        gamePanel.monster[13].attack = 7;
        gamePanel.monster[13].speed = 2;
        gamePanel.monster[13].defense = 2;
        
        gamePanel.monster[14] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[14].worldX = gamePanel.TILE_SIZE * 24;
        gamePanel.monster[14].worldY = gamePanel.TILE_SIZE * 4;
        gamePanel.monster[14].attack = 7;
        gamePanel.monster[14].speed = 2;
        gamePanel.monster[14].defense = 2;
        
        gamePanel.monster[15] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[15].worldX = gamePanel.TILE_SIZE * 24;
        gamePanel.monster[15].worldY = gamePanel.TILE_SIZE * 3;
        gamePanel.monster[15].attack = 7;
        gamePanel.monster[15].speed = 2;
        gamePanel.monster[15].defense = 2;
        
        gamePanel.monster[16] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[16].worldX = gamePanel.TILE_SIZE *24;
        gamePanel.monster[16].worldY = gamePanel.TILE_SIZE * 5;
        gamePanel.monster[16].attack = 7;
        gamePanel.monster[16].speed = 2;
        gamePanel.monster[16].defense = 2;
        
        gamePanel.monster[17] = new MonsterGreenSlime(gamePanel);
        gamePanel.monster[17].worldX = gamePanel.TILE_SIZE *25;
        gamePanel.monster[17].worldY = gamePanel.TILE_SIZE * 5;
        gamePanel.monster[17].attack = 7;
        gamePanel.monster[17].speed = 2;
        gamePanel.monster[17].defense = 2;
    }
}
