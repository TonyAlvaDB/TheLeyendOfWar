/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import controller.AssetSetter;
import controller.CollisionChecker;
import controller.Entity;
import controller.EventHandler;
import controller.KeyHandler;
import controller.OperacionesTAD;
import controller.Player;
import controller.Sound;
import controller.TAD;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JPanel;
import model.GamePanelConstants;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class GamePanel extends JPanel implements Runnable, GamePanelConstants{
    //TAD
    private OperacionesTAD tad = new OperacionesTAD();
    
    public final int ORIGINAL_TILE_SIZE = 16;
    final int SCALE = 3;
    
    //TAD
    public final int TILE_SIZE = tad.calculo(SCALE, ORIGINAL_TILE_SIZE);
    public final int MAX_SCREEN_COL = 16;
    public final int MAX_SCREEN_ROW = 12;
    
    //TAD
    public final int SCREEN_WIDTH = tad.calculo(TILE_SIZE, MAX_SCREEN_COL);
    public final int SCREEN_HEIGHT = tad.calculo(TILE_SIZE, MAX_SCREEN_ROW);
    
    public final int MAX_WORLD_COL = 50;
    public final int MAX_WORLD_ROW = 50;
    
    
    final int FPS = 60;
    final int UPS = 60;

    
    public TileManager tileM = new TileManager(this);
    public KeyHandler keyH = new KeyHandler(this);
    public EventHandler eHander = new EventHandler(this);
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    public Sound soundMusic = new Sound();
    public Sound soundSFX = new Sound();
    public Player player = new Player(this, keyH);
    public Entity obj[] = new Entity[20];
    public Entity npc[] = new Entity[10];
    public Entity monster[] = new Entity[20];
    ArrayList<Entity> entityList = new ArrayList<>();
    public ArrayList<Entity> proyectileList = new ArrayList<>();
    
    
    public int gameState;

    
    
    
    
    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }
    
    public void setupGame(){
        aSetter.setObject();
        aSetter.setNpc();
        aSetter.setMonster();
        playMusic(1);
        gameState = TITLE_STATE;
        
    }
    
    public void retry(){
        player.setDefaultPositions();
        player.restoreLifeAndMana();
        aSetter.setNpc();
        aSetter.setMonster();
    }
    public void restart(){
        player.setDefaultPositions();
        player.setDefaultValues();
        player.restoreLifeAndMana();
        player.setItems();
        aSetter.setObject();
        aSetter.setNpc();
        aSetter.setMonster();
        
    }
    
    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void update(){
        if(gameState == PLAY_STATE){
            player.update();
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null)
                    npc[i].update();
            }
            
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null){
                    if(monster[i].alive == true && monster[i].dying == false){
                        monster[i].update();
                    }
                    if(monster[i].alive == false){
                        monster[i].checkDrop();
                        monster[i] = null;
                    }
                }       
            }
            
            for (int i = 0; i < proyectileList.size(); i++) {
                if(proyectileList.get(i) != null){
                    if(proyectileList.get(i).alive == true){
                        proyectileList.get(i).update();
                    }
                    if(proyectileList.get(i).alive == false){
                        proyectileList.remove(i);
                    }
                }       
            }
        }
            
        if(gameState == PAUSE_STATE){
            
        }
            
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        
        if(gameState == TITLE_STATE){
            ui.draw(g2);
        } else{
            tileM.draw(g2);

            entityList.add(player);
            for (int i = 0; i < npc.length; i++) {
                if(npc[i] != null)
                    entityList.add(npc[i]);
            }
            
            for (int i = 0; i < obj.length; i++) {
                if(obj[i] != null)
                    entityList.add(obj[i]);
            }
            
            for (int i = 0; i < monster.length; i++) {
                if(monster[i] != null)
                    entityList.add(monster[i]);
            }
            
            for (int i = 0; i < proyectileList.size(); i++) {
                if(proyectileList.get(i) != null)
                    entityList.add(proyectileList.get(i));
            }
            
            //Sort
            quickSort(entityList, 0, entityList.size() - 1);
            
            for (int i = 0; i < entityList.size(); i++) {
                entityList.get(i).draw(g2);
            }
            
            entityList.clear();
            
            
            ui.draw(g2);
            
            g2.dispose();    
        }
        
        
        
        
        
    }
    public void playMusic(int i){
        soundMusic.setFile(i);
        soundMusic.play();
        soundMusic.loop();
    }
    public void stopMusic(){
        soundMusic.stop();
    }
    public void playSFX(int i){
        soundSFX.setFile(i);
        soundSFX.play();
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
//                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;

            }
        }
        
    }
 
    public void quickSort(ArrayList<Entity> entityList, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(entityList, low, high);
            quickSort(entityList, low, pivotIndex - 1);
            quickSort(entityList, pivotIndex + 1, high);
        }
    }

    public int partition(ArrayList<Entity> entityList, int low, int high) {
        int pivotValue = entityList.get(high).worldX;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (entityList.get(j).worldX >= pivotValue) {
                i++;
                Collections.swap(entityList, i, j);
            }
        }

        Collections.swap(entityList, i + 1, high);
        return i + 1;
    }
}
