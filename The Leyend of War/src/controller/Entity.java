/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import model.ObjectProyectile;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import model.EntityConstants;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class  Entity implements EntityConstants{

   public GamePanel gamePanel;

    //Hit Box matter
    public Rectangle solidArea = new Rectangle(0, 0, 48, 48);
    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;
    public int actionLockCounter= 0;
    public boolean collision = false;
    
    //Dialogues matter
    public String dialogues[] = new String[20];
    int dialogueIndex = 0;
    public BufferedImage image, image2, image3;
    public String name;
    
    UtilityTool uTool = new UtilityTool();

    
    //Player sprite drawing matter
    public BufferedImage up1, up2, up3, down1, down2, down3, left1, left2, left3, right1, right2, right3;
    public BufferedImage attackUp1, attackUp2, attackUp3, attackDown1, attackDown2, attackDown3, attackLeft1, attackLeft2, attackLeft3, attackRight1, attackRight2, attackRight3;
    public String direction = "down";
    public int spriteCounter = 0;
    public int spriteNum = 1;
    
    //Player and monster life
    public int invincibleCounter =0;
    boolean attacking = false;
    public boolean alive = true;
    public boolean dying = false;
    int dyingCounter = 0;
    boolean hpBarOn = false;
    int hpBarCounter = 0;
    
    //Player stats
    public int worldX, worldY;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int exp;
    public int nextLevelExp;
    public int coin;
    public int maxMana;
    public int mana;
    public int maxLife;
    public int life;
    public int speed;
    public boolean invincible = false;
    public Entity currentWeapon;
    public Entity currentShield;
    
    //Weapon stats
    public int attackValue;
    public int defenseValue;
    public String description = "";
    
    //Constants matter
    public int type;


    //Proyectile matter
    public ObjectProyectile proyectile;
    public int useCost;
    public int value;
    
    
    
            
    public Entity(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public void use(Entity entity){}

    public void setAction(){
    
    }
    public void checkDrop(){}
    //Este metodo hace que el item dropeado caiga donde muere el monstruo
    public void dropItem(Entity droppedItem){
        for (int i = 0; i < gamePanel.obj.length; i++) {
            if (gamePanel.obj[i] == null){
                gamePanel.obj[i] = droppedItem;
                gamePanel.obj[i].worldX = worldX;
                gamePanel.obj[i].worldY = worldY;
                break;
            }
            
        }
    }
    public void damageReaction(){}
    //Este metodo hace que cuando hablamos con un NPC nos vea
    public void speak(){
    if(dialogues[dialogueIndex] == null)
        dialogueIndex = 0;
        
        gamePanel.ui.currentDialogue = dialogues[dialogueIndex];
        dialogueIndex++;
    
        switch(gamePanel.player.direction){
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        
        }
    }
    //Update que se hace 60 veces por segundo (FPS)
    public void update(){
        setAction();
        collisionOn = false;
        gamePanel.cChecker.checkTile(this);
        gamePanel.cChecker.checkObject(this, false);
        gamePanel.cChecker.checkEntity(this, gamePanel.npc);
        gamePanel.cChecker.checkEntity(this, gamePanel.monster);
        boolean contactPlayer = gamePanel.cChecker.checkPlayer(this);
        
        if(this.type == TYPE_MONSTER && contactPlayer == true){
            damagePlayer(attack);
        }
        
        if (collisionOn == false) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }

            }

            spriteCounter++;
            if (spriteCounter == 30) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            
            if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 20) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
        
    }
    //Lo que pasa cuando se recibe un golpe de un monstruo
    public void damagePlayer(int attack){
        if(gamePanel.player.invincible == false){
                gamePanel.playSFX(4);
                int damage = attack - gamePanel.player.defense;
                if(damage < 0){
                    damage = 0;
                }
                gamePanel.player.life-= damage;
                gamePanel.player.invincible = true;
            }
    }
    //Este es el metodo que nos ayuda a meter las imagenes en variabes tipo BufferedImage
    public BufferedImage setup(String imageName, int width, int height){
        UtilityTool uTool = new UtilityTool();
        BufferedImage image = null;
        System.out.println(imageName);
        try {
            image = ImageIO.read(getClass().getClassLoader().getResourceAsStream(imageName));
            image = uTool.scaleImage(image, width, height);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    } 
    //Metodo que dibuja
    public void draw(Graphics2D g2){
        BufferedImage image = null;
        int screenX =  worldX - gamePanel.player.worldX + gamePanel.player.SCREEN_X;
        int screenY =  worldY - gamePanel.player.worldY + gamePanel.player.SCREEN_Y;
            
        if(worldX > gamePanel.player.worldX - gamePanel.player.SCREEN_X - gamePanel.TILE_SIZE*2 &&
            worldX < gamePanel.player.worldX + gamePanel.player.SCREEN_X + gamePanel.TILE_SIZE*2 &&
            worldY > gamePanel.player.worldY - gamePanel.player.SCREEN_Y - gamePanel.TILE_SIZE*2 &&
            worldY < gamePanel.player.worldY + gamePanel.player.SCREEN_Y + gamePanel.TILE_SIZE*2){
            
            switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right2;
                }
                break;
        }
            
            
            if(type == 2 && hpBarOn == true){
                double oneScale = (double)gamePanel.TILE_SIZE/maxLife;
                double hpBarValue = oneScale*life;
                
                g2.setColor(new Color(35, 35, 35));
                g2.fillRect(screenX-1, screenY - 16, gamePanel.TILE_SIZE+2, 12);
                g2.setColor(new Color(255, 0, 30));
                g2.fillRect(screenX, screenY - 15, (int)hpBarValue, 10);   
                hpBarCounter++;
                
                if(hpBarCounter > 600){
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
                
            }
            
            
            if (invincible == true){
                hpBarOn = true;
                hpBarCounter = 0;
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
            }
            if(dying == true)
                dyingAnimation(g2);
            g2.drawImage(image, screenX, screenY, null);
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        }
    }
    //Hace que el monstruo parpadee cuando muere. Tambien le implementa sonido
    private void dyingAnimation(Graphics2D g2) {
        dyingCounter++;
        int i = 5;
        
        if (dyingCounter <= i){
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i && dyingCounter <= i*2){
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i*2 && dyingCounter <= i*3){
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i*3 && dyingCounter <= i*4){
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i*4 && dyingCounter <= i*5){
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i*5 && dyingCounter <= i*6){
            changeAlpha(g2, 1f);
        }
        if (dyingCounter > i*6 && dyingCounter <= i*7){
            changeAlpha(g2, 0f);
        }
        if (dyingCounter > i*7 && dyingCounter <= i*8){
            changeAlpha(g2, 1f);
        }
        if(dyingCounter > i*8){
            alive = false;
        }
    }
    //Este metodo nos cambia la opacidad de la entidad
    private void changeAlpha(Graphics2D g2, float f) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, f));
    }
}
