/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package model;

import controller.Entity;
import controller.LinkedList;
import controller.Nodo;
import java.util.Random;
import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class NpcMage extends Entity{
    
    public NpcMage(GamePanel gamePanel){
        super(gamePanel);
        
        direction = "down";
        speed = 1;
        getNpcImage();
        
        setDialogue(0);
        
    }
    //Cargamos las imagenes en variables del tipo BufferedImage
    public void getNpcImage() {
       
        up1 = setup("npc/mage_up_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up2 = setup("npc/mage_up_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        up3 = setup("npc/mage_up_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down1 = setup("npc/mage_down_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down2 = setup("npc/mage_down_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        down3 = setup("npc/mage_down_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left1 = setup("npc/mage_left_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left2 = setup("npc/mage_left_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        left3 = setup("npc/mage_left_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right1 = setup("npc/mage_right_1.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right2 = setup("npc/mage_right_2.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
        right3 = setup("npc/mage_right_3.png", gamePanel.TILE_SIZE, gamePanel.TILE_SIZE);
    }
    //Este es un tipo de AI donde el npc tiene 25% de posibilidades de moverse para x sitio (los 4 lados)
    public void setAction(){
        
        //Listas y busqueda secuencial
        actionLockCounter++;
        LinkedList linkedList = new LinkedList();

        // Generar una lista aleatoria de números del 1 al 100
        int[] numbers = new int[100];
        for (int i = 0; i < 100; i++) {
            numbers[i] = i + 1;
        }
        shuffleArray(numbers);

        // Agregar los nodos con los números aleatorios a la lista enlazada
        for (int number : numbers) {
            linkedList.addNode(number);
        }

        // Generar un número aleatorio como índice a buscar
        Random random = new Random();
        int randomIndex = random.nextInt(100);

        // Buscar el nodo en el índice generado aleatoriamente
        Nodo node = linkedList.getNode(randomIndex);

        // Verificar si se encontró el nodo en el índice
        if (node != null) {
            if(actionLockCounter > 100){
                if (node.value <= 25) {
                    direction = "up";
                } else if (node.value <= 50) {
                    direction = "down";
                } else if (node.value <= 75) {
                    direction = "left";
                } else {
                    direction = "right";
                }
                actionLockCounter = 0;
            }
            // Determinar la dirección del NPC basada en el valor del nodo
            
            
            
        
        }
    }
        
       public static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            if (index != i) {
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
     
        
    }

    //Recursividad
    private void setDialogue(int index) {
        if (index < dialogues.length) {
            dialogues[index] = getDialogue(index);
            setDialogue(index + 1);
        }
    }
    //Recursividad
    private String getDialogue(int index) {
        switch (index) {
            case 0:
                return "No puedo creerlo \n... \nEres War!";
            case 1:
                return "El miedo se apodera del \ndesierto, como de ti al ver \nun arbol binario.";
            case 2:
                return "Ayudanos a salvar el desierto, \nWar.";
            case 3:
                return "Porfi xd.";
            default:
                return null;
        }
    }
    //Con este el NPC habla
    public void speak(){
        
        super.speak();
    }
}
