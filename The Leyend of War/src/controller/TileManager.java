/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class TileManager {
    GamePanel gamePanel;
    Tile[] tile;
    
    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new Tile[100];
        getTileImage();
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_1.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_2.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_3.png"));
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){
        g2.drawImage(tile[0].image, 0, 0,gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
    }
}
