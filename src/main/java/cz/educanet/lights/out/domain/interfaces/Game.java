package cz.educanet.lights.out.domain.interfaces;

import java.util.Random;

public class Game implements ILightsOut {

    private int count = 0;
    private Random rd = new Random();
    private boolean [][] grid = new boolean[5][5];

    public Game(){
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

        return false;
    }

    @Override
    public boolean[][] getGrid() {

        return grid;
    }

    @Override
    public void makeMove(int x, int y) {
        isInField(x,y);

    }

    public boolean isInField(int x, int y){
        if(x - 1 > 0 && y - 1 > 0 ){
            return true;
        }
        return false;
    }
}
