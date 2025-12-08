package org.example;

public class Board{
  private int[] grid = {1,2,3,
                        4,5,6,
                        7,8,9}; // 1-9 = empty, -1 = X, 0 = O

  public int checkWin(){// 1 = noWin, -1 = X, 0 = O
    int winCondition = 1;
    // Check diagonals
    if (grid[0] == grid[4] && grid[4] == grid[8]) {
      winCondition = grid[0];
    }

    if (grid[2] == grid[4] && grid[4] == grid[6]) {
      winCondition = grid[2];
    }

    // Check rows and columns
    for (int row = 0; row < 9; row+=3) {
      if (grid[row] == grid[row + 1] && grid[row + 1] == grid[row + 2]){
        winCondition = grid[row];
      }
    }

    for (int col = 0; col < 3; col++){
      if (grid[col] == grid[col + 3] && grid[col + 3] == grid[col + 6]){
        winCondition = grid[col];
      }
    }
    
    return winCondition;
  }

  public boolean isDefult(){
    int[] defaultGrid = {1,2,3,
       4,5,6,
       7,8,9};

    for (int i = 0; i < 9; i++){
      if (grid[i] != defaultGrid[i]){
        return false;
      }
    }
    return true;
  }
  
  public int[] getGrid(){
    return grid;
  }

  public void setGridSquare(int place, int value){
    grid[place] = value;
  }

  public String toString(){
    String output = "";
    String[] gridString = new String[9];
    
    // Convert grid to string
    for (int i = 0; i < 9; i++){
      if (grid[i] == -1){
        gridString[i] = "X";
      } else if(grid[i]==0){
        gridString[i] = "O";
      }else{
        gridString[i] = Integer.toString(grid[i]);
      }
    }

    //print grid to string
    output += "         |         |         \n";
    output += "   [" + gridString[0] + "]   |   [" + gridString[1] + "]   |   [" + gridString[2] + "]   \n";
    output += "         |         |         \n";
    output += "-----------------------------\n";
    output += "         |         |         \n";
    output += "   [" + gridString[3] + "]   |   [" + gridString[4] + "]   |   [" + gridString[5] + "]   \n";
    output += "         |         |         \n";
    output += "-----------------------------\n";
    output += "         |         |         \n";
    output += "   [" + gridString[6] + "]   |   [" + gridString[7] + "]   |   [" + gridString[8] + "]   \n";
    output += "         |         |         \n";
    return output;
  }
}