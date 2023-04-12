/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    int mapTileNum[][];
    
    public TileManager(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        tile = new Tile[100];
        getTileImage();
        mapTileNum = new int [gamePanel.MAX_SCREEN_COL][gamePanel.MAX_SCREEN_ROW];
    }
    
    public void loadMap(){
        try {
            
            InputStream is = getClass().getResourceAsStream("maps/map01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gamePanel.MAX_SCREEN_COL && row < gamePanel.MAX_SCREEN_ROW){
                String line = br.readLine();
                while(col < gamePanel.MAX_SCREEN_COL){
                    String numbers[] = line.split(" ");
                }
            }
            
        } catch (Exception e) {
        }
    }
    
    public void getTileImage(){
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_1.png"));
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_2.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/dessert_floor_3.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/road_1.png"));
            tile[4] = new Tile();
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_1.png"));
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_1.png"));
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_2.png"));
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_3.png"));
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_1.png"));
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_2.png"));
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_3.png"));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_4.png"));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/veg_1.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/veg_2.png"));
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        
        while(col < gamePanel.MAX_SCREEN_COL && row < gamePanel.MAX_SCREEN_ROW){
            g2.drawImage(tile[0].image, x, y,gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            col++;
            x+= gamePanel.TILE_SIZE;
            if(col == gamePanel.MAX_SCREEN_COL){
                col = 0;
                x = 0;
                row++;
                y += gamePanel.TILE_SIZE;
            }
            
            
        }
                
        
        
    }
}
