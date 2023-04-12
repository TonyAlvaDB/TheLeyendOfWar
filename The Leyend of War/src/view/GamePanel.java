/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.KeyHandler;
import controller.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class GamePanel extends JPanel implements Runnable{
    
    final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    
    final int TILE_SIZE = ORIGINAL_TILE_SIZE * SCALE;
    final int MAX_SCREEN_COL = 16;
    final int MAX_SCREEN_ROW = 12;
    
    final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COL;
    final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROW;
    
    final int FPS = 60;
    final int UPS = 200;
    
    KeyHandler keyH = new KeyHandler(this);
    Thread gameThread;
    Player player = new Player(this, keyH);
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        
        startGameThread();
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update(){
        player.update();
    }
    
    public void draw(Graphics2D g2){
        player.draw(g2);
    }

    public void run() {
        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
        
    }

}
