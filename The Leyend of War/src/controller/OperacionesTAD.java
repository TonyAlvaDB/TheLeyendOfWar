/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import view.GamePanel;

/**
 *
 * Program created by
 * @author Anthony Alvarez Delgado
 * Software Engeneer Student - UIA
 *
 */
public class OperacionesTAD {
    private TAD tad;

    public OperacionesTAD(){
        tad = new TAD();
    }
    
    
    private int calculoDireccionPantalla(){
        return tad.tile*tad.direction;
    }
    
    public int calculo (int tile, int direction){
        tad.tile = tile;
        tad.direction = direction;
        return calculoDireccionPantalla();
    }
    
}

