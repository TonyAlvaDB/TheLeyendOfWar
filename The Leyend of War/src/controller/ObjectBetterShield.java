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
public class ObjectBetterShield extends Entity{

    public ObjectBetterShield(GamePanel gamePanel) {
        super(gamePanel);
        type = TYPE_SHIELD;
        name = "Mejor Escudo";
        down1 = setup("objects/better_shield.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        defenseValue = 3;
        description = "[" + name + "] \nHecho por los mismos \narcangeles";
    }

}
