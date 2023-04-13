/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class KeyHandler implements KeyListener{

    
    GamePanel gamePanel;
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    
    public KeyHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = true;
        }
        if(code==KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = true;
        }
        if(code==KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = true;
        }
        if(code==KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = true;
        }
        if(code==KeyEvent.VK_P){
            if(gamePanel.gameState == gamePanel.PLAY_STATE)
                gamePanel.gameState = gamePanel.PAUSE_STATE;
            else if (gamePanel.gameState == gamePanel.PAUSE_STATE)
                gamePanel.gameState = gamePanel.PLAY_STATE;
        }
    }

    
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if(code==KeyEvent.VK_W || code == KeyEvent.VK_UP){
            upPressed = false;
        }
        if(code==KeyEvent.VK_S || code == KeyEvent.VK_DOWN){
            downPressed = false;
        }
        if(code==KeyEvent.VK_A || code == KeyEvent.VK_LEFT){
            leftPressed = false;
        }
        if(code==KeyEvent.VK_D || code == KeyEvent.VK_RIGHT){
            rightPressed = false;
        }
    }

}
