package org.example;

public class Board{
  private int[][] grid = {{0,0,0},{0,0,0},{0,0,0}}; // 0 = empty, 1 = X, -1 = O

  public int checkWin(){// 0 = noWin, 1 = X, -1 = O
    int winCondition = 0;
    for(int row = 0; row < 3; row++){
      for(int collom = 0; collom < 3; collom++){
        if(grid[row][collom] == 1){
          
        }
      }
    }
    return winCondition;
  }
  
  public int[][] getGrid(){
    return grid;
  }
}