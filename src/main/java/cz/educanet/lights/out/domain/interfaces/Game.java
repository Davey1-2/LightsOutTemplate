package cz.educanet.lights.out.domain.interfaces;

import java.util.Random;

public class Game implements ILightsOut {

    private int count = 0;
    private int win;
    private Random rd = new Random();
    private final boolean[][] grid = new boolean[5][5];

    public Game() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                boolean tile = rd.nextBoolean();

                grid[i][j] = tile;
            }
        }
    }

    @Override
    public int getMoveCount() {
        count++;

        return count;
    }

    @Override
    public boolean isGameOver() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == true) {
                    win++;
                }
            }
        }

        if (win == 25) {
            return true;
        } else return false;


    }

    @Override
    public boolean[][] getGrid() {

        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        grid[x][y] = !grid[x][y];

        if (x + 1 <= 4) {
            grid[x + 1][y] = !grid[x + 1][y];
        }
        if (x - 1 >= 0) {
            grid[x - 1][y] = !grid[x - 1][y];
        }
        if (y + 1 <= 4) {
            grid[x][y + 1] = !grid[x][y + 1];
        }
        if (y - 1 >= 0) {
            grid[x][y - 1] = !grid[x][y - 1];
        }
    }

}
