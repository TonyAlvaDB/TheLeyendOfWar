/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;


import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import view.GamePanel;

/**
 *
 * Program created by
 *
 * @author Anthony Alvarez Delgado Software Engeneer Student - UIA
 *
 */
public class Player extends Entity {

    KeyHandler keyH;

    public final int SCREEN_X;
    public final int SCREEN_Y;
    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int INVENTORY_SIZE = 20;
    

    public Player(GamePanel gamePanel, KeyHandler keyH) {

        super(gamePanel);

        this.keyH = keyH;

        SCREEN_X = (gamePanel.SCREEN_WIDTH / 2) - (gamePanel.TILE_SIZE / 2);
        SCREEN_Y = (gamePanel.SCREEN_HEIGHT / 2) - (gamePanel.TILE_SIZE / 2);

        solidArea = new Rectangle();
        solidArea.x = 16;
        solidArea.y = 33;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 15;
        solidArea.height = 15;
        

        
        getPlayerAttackImage();
        getPlayerImage();
        setDefaultValues();
        setItems();
        

    }

    public void setDefaultValues() {

        worldX = gamePanel.TILE_SIZE * 24;
        worldY = gamePanel.TILE_SIZE * 25;
        speed = 3;
        direction = "down";
        maxLife = 6;
        life = maxLife;
        level = 1;
        strength = 1;
        dexterity = 1;
        exp = 0;
        nextLevelExp = 5;
        coin = 0;
        maxMana = 4;
        mana = maxMana;
        currentWeapon = new ObjectSword(gamePanel);
        currentShield = new ObjectShield(gamePanel);
        proyectile = new ObjectPowerBall(gamePanel);
        attack = getAttack();
        defense = getDefense();
        

    }
    public int getAttack(){
        attackArea = currentWeapon.attackArea;
        return attack = strength * currentWeapon.attackValue;
    }
    public int getDefense(){
        return defense = dexterity * currentShield.defenseValue;
    }

    public void getPlayerImage() {

        up1 = setup("player/soldier_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("player/soldier_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up3 = setup("player/soldier_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("player/soldier_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("player/soldier_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down3 = setup("player/soldier_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("player/soldier_left_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("player/soldier_left_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left3 = setup("player/soldier_left_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("player/soldier_right_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("player/soldier_right_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right3 = setup("player/soldier_right_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        
    }

    public void getPlayerAttackImage() {

        attackUp1 = setup("attack/attack_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackUp2 = setup("attack/attack_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackUp3 = setup("attack/attack_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown1 = setup("attack/attack_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown2 = setup("attack/attack_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackDown3 = setup("attack/attack_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE * 2);
        attackLeft1 = setup("attack/attack_left_1.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackLeft2 = setup("attack/attack_left_2.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackLeft3 = setup("attack/attack_left_3.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight1 = setup("attack/attack_right_1.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight2 = setup("attack/attack_right_2.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);
        attackRight3 = setup("attack/attack_right_3.png", gamePanel.TILE_SIZE * 2, gamePanel.TILE_SIZE);

    }
    
    public void update() {
        if (attacking == true) {
            attacking();
        } 

        else if (keyH.upPressed == true
                || keyH.downPressed == true
                || keyH.leftPressed == true
                || keyH.rightPressed == true
                || keyH.enterPressed == true) {
            if (keyH.upPressed) {
                direction = "up";
            }
            if (keyH.downPressed) {
                direction = "down";
            }
            if (keyH.leftPressed) {
                direction = "left";
            }
            if (keyH.rightPressed) {
                direction = "right";
            }

            collisionOn = false;
            gamePanel.cChecker.checkTile(this);

            int objectIndex = gamePanel.cChecker.checkObject(this, true);
            pickupObject(objectIndex);

            int npcIndex = gamePanel.cChecker.checkEntity(this, gamePanel.npc);
            interactNpc(npcIndex);

            int monsterIndex = gamePanel.cChecker.checkEntity(this, gamePanel.monster);
            contactMonster(monsterIndex);

            gamePanel.eHander.checkEvent();

            if (collisionOn == false && keyH.enterPressed == false) {
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
            
            gamePanel.keyH.enterPressed = false;

            spriteCounter++;
            if (spriteCounter == 15) {
                spriteNum++;
                if (spriteNum > 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }

        }
        if(gamePanel.keyH.shotKeyPressed == true && proyectile.alive == false && proyectile.haveResource(this) == true){
            proyectile.set(worldX, worldY, direction, true, this);
            
            proyectile.subtractResource(this);
            
            gamePanel.proyectileList.add(proyectile);
            gamePanel.playSFX(3);
        }

        if (invincible == true) {
            invincibleCounter++;
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
        }
        if(life > maxLife){
            life = maxLife;
        }
        if(mana > maxMana){
            mana = maxMana;
        }

    }

    public void pickupObject(int i) {
        if (i != 999) {
            
            if(gamePanel.obj[i].type == PICK){
                gamePanel.obj[i].use(this);
                gamePanel.obj[i] = null;
            }
            else{
                String text;
                if(inventory.size()!= INVENTORY_SIZE){
                    inventory.add(gamePanel.obj[i]);
                    gamePanel.playSFX(13);
                    text = "Conseguiste una "+ gamePanel.obj[i].name + "!";

                }
                else{
                    text = "No puedes llevar mas objetos";
                }
                gamePanel.ui.addMessage(text);
                gamePanel.obj[i] = null;    
            }
            
            
        }
    }

    private void interactNpc(int i) {
        if (gamePanel.keyH.enterPressed == true) {
            if (i != 999) {
                gamePanel.gameState = gamePanel.DIALOGUE_STATE;
                gamePanel.npc[i].speak();
            } else {
                if (gamePanel.keyH.enterPressed == true) {
                    gamePanel.playSFX(5);
                    attacking = true;
                }
            }
        }
    }

     public void draw(Graphics2D g2) {

        int tempScreenX = SCREEN_X;
        int tempScreenY = SCREEN_Y;
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (attacking == true) {
                    tempScreenY = SCREEN_Y - gamePanel.TILE_SIZE;
                    if (spriteNum == 1) {
                        image = attackUp1;
                    }
                    if (spriteNum == 2) {
                        image = attackUp2;
                    }
                    if (spriteNum == 3) {
                        image = attackUp3;
                    }
                    if (spriteNum == 4) {
                        image = attackUp3;
                    }
                }
                
                if (attacking == false) {
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
                }
                
                break;
            case "down":
                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackDown1;
                    }
                    if (spriteNum == 2) {
                        image = attackDown2;
                    }
                    if (spriteNum == 3) {
                        image = attackDown3;
                    }
                    if (spriteNum == 4) {
                        image = attackDown3;
                    }
                }
                if (attacking == false) {
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
                }
                
                break;
            case "left":
                if (attacking == true) {
                    tempScreenX = SCREEN_X - gamePanel.TILE_SIZE;
                    if (spriteNum == 1) {
                        image = attackLeft1;
                    }
                    if (spriteNum == 2) {
                        image = attackLeft2;
                    }
                    if (spriteNum == 3) {
                        image = attackLeft3;
                    }
                    if (spriteNum == 4) {
                        image = attackLeft3;
                    }
                }
                if (attacking == false) {
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
                }

                break;
            case "right":

                if (attacking == true) {
                    if (spriteNum == 1) {
                        image = attackRight1;
                    }
                    if (spriteNum == 2) {
                        image = attackRight2;
                    }
                    if (spriteNum == 3) {
                        image = attackRight3;
                    }
                    if (spriteNum == 4) {
                        image = attackRight3;
                    }
                }
                
                if (attacking == false) {
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
                }           
                break;

        }
        if (invincible == true){
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.4f));
        }
        g2.drawImage(image, tempScreenX, tempScreenY, null);
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));

//        g2.setColor(Color.white);
//        g2.fillRect(x, y, gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }

    private void contactMonster(int i) {
        if (i != 999) {
            if (invincible == false && gamePanel.monster[i].dying == false) {
                gamePanel.playSFX(4);
                int damage = gamePanel.monster[i].attack - defense;
                if(damage < 0){
                    damage = 0;
                }
                life -= damage;
                invincible = true;
            }

        }
    }

    private void attacking() {
        spriteCounter++;
        if(spriteCounter <=10){
            spriteNum = 1;
        }
        if (spriteCounter > 10 && spriteCounter <=30){
            spriteNum = 2;
            
            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;
            
            switch(direction){
            case"up":
                worldY -= attackArea.height;
                break;
            case"down":
                worldY += attackArea.height;
                break;
            case"left":
                worldX -= attackArea.width;
                break;
            case"right":
                worldX += attackArea.width;
                break;
            }
            
            solidArea.width = attackArea.width;
            solidArea.height = attackArea.height;
            
            int monsterIndex = gamePanel.cChecker.checkEntity(this, gamePanel.monster);
            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
            
            damageMonster(monsterIndex, attack);
            
            
        }
        if (spriteCounter > 30 && spriteCounter <=35){
            spriteNum = 3;
        }
        if(spriteCounter > 35){
            spriteNum = 1;
            spriteCounter = 0;
            attacking=false;
        }
    }

    void damageMonster(int i, int attack) {
        if(i != 999){
            if(gamePanel.monster[i].invincible == false){
                gamePanel.playSFX(14);
                int damage = attack - gamePanel.monster[i].defense;
                if(damage < 0){
                    damage = 0;
                }
                gamePanel.monster[i].life -= damage; 
                gamePanel.ui.addMessage(damage + " de daño!");
                gamePanel.monster[i].invincible = true;
                gamePanel.monster[i].damageReaction();
                
                if(gamePanel.monster[i].life <= 0){
                    gamePanel.playSFX(11);
                    gamePanel.monster[i].dying = true;
                    gamePanel.ui.addMessage("Mataste al " + gamePanel.monster[i].name + "!");
                    gamePanel.ui.addMessage("Experiencia +" + gamePanel.monster[i].exp + "!");
                    exp += gamePanel.monster[i].exp;
                    checkLevelUp();
                }
                
            }
        }
    }

    private void checkLevelUp() {
        if(exp >= nextLevelExp){
            level++;
            nextLevelExp = nextLevelExp * 2;
            maxLife += 2;
            strength ++;
            dexterity++;
            attack = getAttack();
            defense = getDefense();
            gamePanel.playSFX(7);
            gamePanel.gameState = gamePanel.DIALOGUE_STATE;
            gamePanel.ui.currentDialogue = "Ahora eres nivel " + level + " ahora!";
        }
    }
    public void selectItem(){
        int itemIndex = gamePanel.ui.getItemIndexOnSlot();
        
        if(itemIndex < inventory.size()){
            Entity selectedItem = inventory.get(itemIndex);
            if(selectedItem.type == TYPE_SWORD || selectedItem.type == TYPE_BETTER_SWORD){
                currentWeapon = selectedItem;
                attack = getAttack();
            }
            if(selectedItem.type == TYPE_SHIELD){
                currentShield = selectedItem;
                defense = getDefense();
            }
            if(selectedItem.type ==CONSUMABLE){
                selectedItem.use(this);
                inventory.remove(itemIndex);
            }
        }
    }
    public void setItems(){
        inventory.add(currentWeapon);
        inventory.add(currentShield);
        inventory.add(new ObjectKey(gamePanel));
   
    }
}
