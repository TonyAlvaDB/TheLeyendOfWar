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
public class NpcMage extends Entity{
    
    public NpcMage(GamePanel gamePanel){
        super(gamePanel);
        
        direction = "down";
        speed = 1;
        getNpcImage();
    }
    
    public void getNpcImage() {
       
        up1 = setup("npc/mage_up_1.png");
        up2 = setup("npc/mage_up_2.png");
        up3 = setup("npc/mage_up_3.png");
        down1 = setup("npc/mage_down_1.png");
        down2 = setup("npc/mage_down_2.png");
        down3 = setup("npc/mage_down_3.png");
        left1 = setup("npc/mage_left_1.png");
        left2 = setup("npc/mage_left_2.png");
        left3 = setup("npc/mage_left_3.png");
        right1 = setup("npc/mage_right_1.png");
        right2 = setup("npc/mage_right_2.png");
        right3 = setup("npc/mage_right_3.png");
    }


}
