package org.example;

import java.util.Scanner;

public class Menu{
  private Scanner input = new Scanner(System.in);
  
  public void loadGame(){
    System.out.println("Welcome to Tic-Tac-Toe!\n");
    mainMenu();
  }
  
  public void mainMenu(){
    boolean exitLoop = false;

    while (!exitLoop){
      System.out.println("1. Play");
      System.out.println("2. Options");
      System.out.println("3. Rules");
      System.out.println("-1. Quit");
      int userInput = getIntInput("Enter the number of your choice: ");
      
      switch (userInput){
        case 1:
          playMenu();
          System.out.println("Do you want to play again?");
          break;
        case 2:
          optionsMenu();
          break;
        case 3:
          rulesMenu();
          break;
        case -1:
          System.out.println("Thanks for playing!");
          exitLoop = true;
          break;
        default:
          System.out.println("Invalid input. Please enter a valid number.");
      }
    }
  }

  public void playMenu(){
    boolean exitLoop = false;

    while (!exitLoop){
      System.out.println("Which mode would you like to play?\n");
      System.out.println("1. Player vs Player");
      //System.out.println("2. Player vs AI");
      //System.out.println("3. AI vs AI");
      System.out.println("-1. Back");
      int userInput = getIntInput("Enter the number of your choice: ");

      switch (userInput){
        case 1:
          playPvP();
          exitLoop = true;
          break;
        case 2:
          //playPvAI();
          //System.out.println("This feature is not yet implemented.");
          break;
        case 3:
          //playAIvAI();
          //System.out.println("This feature is not yet implemented.");
          break;
        case -1:
          mainMenu();
          break;
        default:
          System.out.println("Invalid input. Please enter a valid number.");
      }
    }
  }

  public void playPvP(){
    Board board = new Board();
    boolean whosTurn = true; // true = X, false = O
    int turn = 1;
    
    while (board.checkWin() == 1 && turn <= 9){
      System.out.println(board.toString());
      System.out.println("It is " + (whosTurn ? "X" : "O") + "'s turn.");
      int userInput = getIntInput("Enter the number of the square you would like to place your piece: ");
      
      if (userInput < 1 || userInput > 9){
        System.out.println("Invalid input. Please enter a valid number.");
      } else if (board.getGrid()[userInput - 1] != -1 && board.getGrid()[userInput - 1] != 0){
        if (whosTurn){
          board.setGridSquare(userInput - 1, -1);
        } else {
          board.setGridSquare(userInput - 1, 0);
        }
        whosTurn = !whosTurn;
        turn++;
      } else {
        System.out.println("That square is already taken. Please choose another.");
      }

      System.out.println(board.checkWin());
    }

    System.out.println(board.toString());
    if (board.checkWin() == -1){
      System.out.println("X wins!");
    } else if (board.checkWin() == 0){
      System.out.println("O wins!");
    } else {
      System.out.println("It's a tie!");
    }
  }

  public void optionsMenu(){
    
  }

  public void rulesMenu(){
    
  }
  
  public int getIntInput(String inputMessage){
    boolean isValid = false;
    int userInput = 0;

    while (!isValid){
      System.out.println(inputMessage);
      if (input.hasNextInt()){
        isValid = true;
        userInput = input.nextInt();
      } else {
        System.out.println("Invalid input. Please enter a valid integer.");
        input.next();
      }
    }
    
    return userInput;
  }
}