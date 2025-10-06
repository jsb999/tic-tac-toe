package org.example;

public class Board{
  private int[] grid = {1,2,3,
                        4,5,6,
                        7,8,9}; // 1-9 = empty, -1 = X, 0 = O

  public int checkWin(){// Returns: 1 = no win, -1 = X wins, 0 = O wins
    // Check diagonals
    if (grid[0] == grid[4] && grid[4] == grid[8] && (grid[0] == -1 || grid[0] == 0)) {
      return grid[0];
    }

    if (grid[2] == grid[4] && grid[4] == grid[6] && (grid[2] == -1 || grid[2] == 0)) {
      return grid[2];
    }

    // Check rows
    for (int row = 0; row < 9; row+=3) {
      if (grid[row] == grid[row + 1] && grid[row + 1] == grid[row + 2] && (grid[row] == -1 || grid[row] == 0)){
        return grid[row];
      }
    }

    // Check columns
    for (int col = 0; col < 3; col++){
      if (grid[col] == grid[col + 3] && grid[col + 3] == grid[col + 6] && (grid[col] == -1 || grid[col] == 0)){
        return grid[col];
      }
    }
    
    return 1; // No win (return 1 instead of 0 to avoid confusion with O wins)
  }
  
  public int[] getGrid(){
    return grid;
  }

  public void setGridSquare(int place, int value){
    grid[place] = value;
  }
  public void setGridSquare(int place, String value){
    if (value.toUpperCase().equals("X")){
      grid[place] = -1;
    } else if (value.toUpperCase().equals("O")){
      grid[place] = 0;
    } else{
      System.out.println("Invalid input. Please enter a valid value.");
    }
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