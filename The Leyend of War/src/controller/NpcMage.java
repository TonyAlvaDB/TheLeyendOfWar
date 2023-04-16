/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.Random;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class NpcMage extends Entity{
    
    public NpcMage(GamePanel gamePanel){
        super(gamePanel);
        
        direction = "down";
        speed = 1;
        getNpcImage();
        
        setDialogue(0);
        
    }
    
    public void getNpcImage() {
       
        up1 = setup("npc/mage_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("npc/mage_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up3 = setup("npc/mage_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("npc/mage_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("npc/mage_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down3 = setup("npc/mage_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("npc/mage_left_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("npc/mage_left_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left3 = setup("npc/mage_left_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("npc/mage_right_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("npc/mage_right_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right3 = setup("npc/mage_right_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

    public void setAction(){
        actionLockCounter++;
        
        if(actionLockCounter == 100){
            Random random = new Random();
            int i = random.nextInt(100)+1;
            if(i <= 25){
                direction = "up";
            }
            if(i > 25 && i <= 50){
                direction = "down";
            }
            if(i > 50 && i <= 75){
                direction = "left";
            }
            if(i > 75 && i <= 100){
                direction = "right";
            }
            actionLockCounter = 0;
        }
        
        
        
    }

    //Recursividad
    private void setDialogue(int index) {
        if (index < dialogues.length) {
            dialogues[index] = getDialogue(index);
            setDialogue(index + 1);
        }
    }

    private String getDialogue(int index) {
        switch (index) {
            case 0:
                return "No puedo creerlo \n... \nEres War!";
            case 1:
                return "El miedo se apodera del \ndesierto, como de ti al ver \nun arbol binario.";
            case 2:
                return "Ayudanos a salvar el desierto, \nWar.";
            case 3:
                return "Porfi xd.";
            default:
                return null;
        }
    }
    public void speak(){
        
        super.speak();
    }
}
