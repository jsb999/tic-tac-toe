package org.example;

import java.util.ArrayList;

public  class TTTAISystem{
  // 1-9 = empty, -1 = X, 0 = O
  // 0 = computer, 1 = player
  public int getBestMove(Board boardGrid){ // first move
    if (boardGrid.isDefult()){
      int rand = (int)(Math.random() * 4) + 1;
      switch (rand){
        case 1:
          return 0;
        case 2:
          return 2;
        case 3:
          return 6;
        case 4:
          return 8;
      }
    } 
    if (countFilled(boardGrid.getGrid()) == 1 && boardGrid.getGrid()[4] == 5){ // second move 
      return 4;
    } 
    int winningMove = checkForWinOrLoss(boardGrid, 0); // check for win
    if (winningMove != -1){ // checks if there is a win condirion and takes it
      return winningMove;
    }

    int blockingMove = checkForWinOrLoss(boardGrid, -1); // check for loss
    if (blockingMove != -1) { // checks if there is a loss condirion and blocks it
        return blockingMove;
    }

    //the defult option
    if (boardGrid.checkWin() == 1){
      return getEmpty(boardGrid);
    }

    return -1; // no move found
  }

  public int checkForWinOrLoss(Board boardGrid, int check){ // check == 0 for win, check == -1 for loss
    Board TempBoard = new Board();

    //copy the board
    for (int i = 0; i < 9; i++){
      TempBoard.setGridSquare(i, boardGrid.getGrid()[i]);
    }
    
    ArrayList<Integer> list = new ArrayList<>();

    //check for spots to check
    for (int i = 0; i < 9; i++){
      if (TempBoard.getGrid()[i] > 0) {
        list.add(i);
      }
    }

    //check for win or loss
    for (int i = 0; i < list.size(); i++){
      TempBoard.setGridSquare(list.get(i), check);
      if (TempBoard.checkWin() == check){
        return list.get(i);
      }else{
        TempBoard.setGridSquare(list.get(i), boardGrid.getGrid()[i]);
      }
    }

    return -1;
  }

  private int getEmpty(Board boardGrid){
    int rand = (int)(Math.random() * 9);

    while (boardGrid.getGrid()[rand] != -1 && boardGrid.getGrid()[rand] != 0){
        rand = (int)(Math.random() * 9);
    }
    
    return rand;
  }
  
  private int countFilled(int[] grid) {
      int count = 0;
      for (int temp : grid) {
          if (temp == 0 || temp == -1){
            count++;
          }
      }
      return count;
  }
}