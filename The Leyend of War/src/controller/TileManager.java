/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
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

            
        setup(0, "tiles/dessert_floor_1.png", false);
        setup(1, "tiles/dessert_floor_2.png", false);
        setup(2, "tiles/dessert_floor_3.png", false);
        setup(3, "tiles/road_1.png", false);
        setup(4, "tiles/wall_1.png", true);
        setup(5, "tiles/wall_2.png", true);
        setup(6, "tiles/wall_3.png", true);
        setup(7, "tiles/water_1.png", true);
        setup(8, "tiles/cactu_1.png", true);
        setup(9, "tiles/cactu_2.png", true);
        setup(10, "tiles/cactu_3.png", true);
        setup(11, "tiles/cactu_4.png", true);
        setup(12, "tiles/veg_1.png", false);
        setup(13, "tiles/veg_2.png", true);

    }
    
    public void setup(int index, String imageName, boolean collision){
        UtilityTool uTool = new UtilityTool();
    
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageName));
            tile[index].image = uTool.scaleImage(tile[index].image, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
            tile[index].collision = collision;
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
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }
            
            
            worldCol++;

            if(worldCol == gamePanel.MAX_WORLD_COL){
                worldCol = 0;

                worldRow++;

            }
            
            
        }
                
        
        
    }
}
