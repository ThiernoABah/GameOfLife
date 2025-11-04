package org.example;


import javax.swing.*;
import java.awt.*;

public class GameOfLifePanel extends JPanel {

    private final World world;
    private char[][] grid;
    private final int cellSize = 20;

    public GameOfLifePanel(World world) {
        this.world = world;
        updateGridFromWorld();
    }

    private void updateGridFromWorld() {
        String[] lines = world.displayView().split("\n");
        world.getNextCycle();
        grid = new char[lines.length][lines[0].length()];

        for (int i = 0; i < lines.length; i++) {
            grid[i] = lines[i].toCharArray();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                g.setColor(grid[i][j] == '*' ? Color.BLACK : Color.WHITE);
                g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    public void nextGeneration() {
        updateGridFromWorld();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Jeu de la Vie - Intégration avec World");
        World world = new World("worlds/game_of_life_30x25.txt");
        GameOfLifePanel panel = new GameOfLifePanel(world);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(panel);
        frame.setVisible(true);

        new Timer(200, e -> panel.nextGeneration()).start();
    }
}