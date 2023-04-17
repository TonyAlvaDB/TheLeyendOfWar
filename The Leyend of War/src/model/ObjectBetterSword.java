/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Entity;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class ObjectBetterSword extends Entity{

    public ObjectBetterSword(GamePanel gamePanel) {
        super(gamePanel);
        type = TYPE_SWORD;
        name = "Espadota";
        down1 = setup("objects/better_sword.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        attackValue = 3;
        attackArea.width = 40;
        attackArea.height = 40;
        description = "[Espadota] \nEs una espadota!";
    }

}
