package org.example;

public class Board{
  private int[][] grid = {{0,0,0},{0,0,0},{0,0,0}}; // 0 = empty, 1 = X, -1 = O

  public int checkWin(){// 0 = noWin, 1 = X, -1 = O
    // Check rows
    for(int row = 0; row < 3; row++){
      if(grid[row][0] != 0 && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]){
        return grid[row][0];
      }
    }
    
    // Check columns
    for(int col = 0; col < 3; col++){
      if(grid[0][col] != 0 && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]){
        return grid[0][col];
      }
    }
    
    // Check diagonal (top-left to bottom-right)
    if(grid[0][0] != 0 && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]){
      return grid[0][0];
    }
    
    // Check diagonal (top-right to bottom-left)
    if(grid[0][2] != 0 && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]){
      return grid[0][2];
    }
    
    return 0; // No win
  }
  
  public int[][] getGrid(){
    return grid;
  }
}