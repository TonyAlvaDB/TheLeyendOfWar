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
        
        mapTileNum = new int [gamePanel.MAX_WORLD_COL][gamePanel.MAX_WORLD_ROW];
        getTileImage();
        loadMap();
    }
    
    public void loadMap(){
        try {
            InputStream is = getClass().getResourceAsStream("/maps/world_map.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            
            int col = 0;
            int row = 0;
            
            while(col < gamePanel.MAX_WORLD_COL && row < gamePanel.MAX_WORLD_ROW){
                String line = br.readLine();
                
                while(col < gamePanel.MAX_WORLD_COL){
                    String numbers[] = line.split(" ");
                    int num = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = num;
                    col++;
                    
                    }
                    if(col == gamePanel.MAX_WORLD_COL){
                        col = 0;
                        row++;
                }
                
            }
            br.close();
            
            
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
            tile[4].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_1.png"));
            tile[4].collision = true;
            tile[5] = new Tile();
            tile[5].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_2.png"));
            tile[5].collision = true;
            tile[6] = new Tile();
            tile[6].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/wall_3.png"));
            tile[6].collision = true;
            tile[7] = new Tile();
            tile[7].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/water_1.png"));
            tile[7].collision = true;
            tile[8] = new Tile();
            tile[8].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_1.png"));
            tile[8].collision = true;
            tile[9] = new Tile();
            tile[9].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_2.png"));
            tile[9].collision = true;
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_3.png"));
            tile[10].collision = true;
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/cactu_4.png"));
            tile[11].collision = true;
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/veg_1.png"));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("tiles/veg_2.png"));
            tile[13].collision = true;
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void draw (Graphics2D g2){
        int worldCol = 0;
        int worldRow= 0;

        
        while(worldCol < gamePanel.MAX_WORLD_COL && worldRow < gamePanel.MAX_WORLD_ROW){
            
            int tileNum = mapTileNum[worldCol][worldRow];
            
            int worldX = worldCol * gamePanel.TILE_SIZE;
            int worldY = worldRow * gamePanel.TILE_SIZE;
            int screenX =  worldX - gamePanel.player.worldX + gamePanel.player.SCREEN_X;
            int screenY =  worldY - gamePanel.player.worldY + gamePanel.player.SCREEN_Y;
            
            if(worldX > gamePanel.player.worldX - gamePanel.player.SCREEN_X - gamePanel.TILE_SIZE*2 &&
                    worldX < gamePanel.player.worldX + gamePanel.player.SCREEN_X + gamePanel.TILE_SIZE*2 &&
                    worldY > gamePanel.player.worldY - gamePanel.player.SCREEN_Y - gamePanel.TILE_SIZE*2 &&
                    worldY < gamePanel.player.worldY + gamePanel.player.SCREEN_Y + gamePanel.TILE_SIZE*2){
                g2.drawImage(tile[tileNum].image, screenX, screenY,gamePanel.TILE_SIZE, gamePanel.TILE_SIZE, null);
            }
            
            
            worldCol++;

            if(worldCol == gamePanel.MAX_WORLD_COL){
                worldCol = 0;

                worldRow++;

            }
            
            
        }
                
        
        
    }
}
