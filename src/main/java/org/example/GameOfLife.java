package org.example;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 *
 */
public class GameOfLife
{
    public static void main( String[] args )
    {
        World world = new World("worlds/game_of_life_30x25.txt");
        for (int i =0; i<100; i++) {
            afficherGrille(world);
            world.getNextCycle();
        }

    }

    public static void afficherGrille(World grille) {
        System.out.flush();
        // Nettoie la console


        System.out.println(grille.displayView());

        try {
            Thread.sleep(300); // Pause entre les générations

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }


}
