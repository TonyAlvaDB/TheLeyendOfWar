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
    public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed, shotKeyPressed;
    
    public KeyHandler(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    
    public void keyTyped(KeyEvent e) {
    }

    
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        if(gamePanel.gameState == gamePanel.PLAY_STATE){
            playState(code);
        }
        
        else if(gamePanel.gameState == gamePanel.DIALOGUE_STATE){
            dialogueState(code);
            
        }
        else if(gamePanel.gameState == gamePanel.PAUSE_STATE){
            pauseState(code);
        }
        else if(gamePanel.gameState == gamePanel.TITLE_STATE){
            titleState(code);
            
        }
        else if (gamePanel.gameState == gamePanel.CHARACTER_STATE){ 
            characterState(code);
        }
        
    }

    public void playState (int code){

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
                gamePanel.gameState = gamePanel.PAUSE_STATE; 
            }        
            if(code==KeyEvent.VK_C){
                gamePanel.gameState = gamePanel.CHARACTER_STATE; 
            }        
            if(code == KeyEvent.VK_ENTER){
                enterPressed = true;
            }
            if(code == KeyEvent.VK_F){
                shotKeyPressed = true;
            }
    }
    public void pauseState (int code){
        if(code==KeyEvent.VK_P)
            gamePanel.gameState = gamePanel.PLAY_STATE;
    }
    public void dialogueState (int code){
        if (code == KeyEvent.VK_ENTER)
            gamePanel.gameState = gamePanel.PLAY_STATE;
    }
    public void characterState (int code){
        if(code==KeyEvent.VK_C)
            gamePanel.gameState = gamePanel.PLAY_STATE;
        if(code==KeyEvent.VK_W){
            if(gamePanel.ui.slotRow!=0){
                gamePanel.ui.slotRow--;
                gamePanel.playSFX(12);
            }
            
        }
        if(code==KeyEvent.VK_S){
            if(gamePanel.ui.slotRow != 3){
                gamePanel.ui.slotRow++;
                gamePanel.playSFX(12);
            }
            
        }
        if(code==KeyEvent.VK_A){
            if(gamePanel.ui.slotCol !=0){
                gamePanel.ui.slotCol--;
                gamePanel.playSFX(12);
            }
            
        }
        if(code==KeyEvent.VK_D){
            if(gamePanel.ui.slotCol != 4){
                gamePanel.ui.slotCol++;
                gamePanel.playSFX(12);
            }
            
        }
        if (code == KeyEvent.VK_ENTER){
            gamePanel.player.selectItem();
        }
        
        
        
    }
    public void titleState(int code){
        if(code==KeyEvent.VK_ENTER)
            gamePanel.gameState = gamePanel.PLAY_STATE;
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
        if(code == KeyEvent.VK_F){
            shotKeyPressed = false;
        }
    }

}
