/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class UtilityTool {
    //Utilizamos el UtilityTool para escalar las imagenes y colocarlas del tamanio deseado en la pantalla (por rendimiento)
    public BufferedImage scaleImage(BufferedImage original, int width, int hight){
        BufferedImage scaledImage = new BufferedImage(width, hight, original.getType());
        Graphics2D g2 = scaledImage.createGraphics();
        g2.drawImage(original,0, 0, width, hight, null);
        g2.dispose();
            
        return scaledImage;
    }
}
