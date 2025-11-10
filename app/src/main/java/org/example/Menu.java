package org.example;

import java.util.Scanner;

public class Menu{ 
  private Scanner input = new Scanner(System.in);

  boolean autosaveEnabled = true;

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
    boolean playAgain = true;
    boolean firstTime = true;

    boolean whosTurn = true; // true = X, false = O
    while(playAgain){
      Board board = new Board();

      FileSystemsManager manager = new FileSystemsManager();
      String fileName = "";
      if (firstTime){
        fileName = "gameSave" + manager.getFileNames().length + ".txt";
        manager.createFile(fileName);
        //check if file is empty
        if (manager.fileToString(fileName).isEmpty()){
          manager.fileWrite(fileName, "X:0\nO:0\nTie:0\nLW:T", false);
        }
          firstTime = false;
      } else{
        fileName = "gameSave" + (manager.getFileNames().length-1) + ".txt";
      }

      int turn = 1;

      while (board.checkWin() == 1 && turn < 10){
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

        //System.out.println(board.checkWin());
      }

      String tempstring = manager.fileToString(fileName);

      System.out.println(board.toString());
      if (board.checkWin() == -1){
        System.out.println("X wins!");
        if (autosaveEnabled){
          int wincount = 0;
          wincount = Integer.parseInt(tempstring.substring(tempstring.indexOf('X')+2, tempstring.indexOf('\n')) + "");

          manager.fileWrite(fileName, "X:" + (wincount+1) + "\n" + tempstring.substring(tempstring.indexOf('O'),tempstring.indexOf("LW"))+ "LW:X", false);
        }
      } else if (board.checkWin() == 0){
        System.out.println("O wins!");
        if (autosaveEnabled){
          int wincount = 0;
          
          wincount = Integer.parseInt(tempstring.substring(tempstring.indexOf('O')+2, tempstring.indexOf("\nT")) + "");

          manager.fileWrite(fileName, tempstring.substring(0, tempstring.indexOf('X')+3) + "\n" + "O:" + (wincount+1) + tempstring.substring(tempstring.indexOf('T'))+ "\nLW:O", false);
        }
      } else {
        System.out.println("It's a tie!");
        if (autosaveEnabled){
          int wincount = 0;
          wincount = Integer.parseInt(tempstring.charAt(tempstring.indexOf('T')+4) + "");

          manager.fileWrite(fileName, tempstring.substring(0, tempstring.indexOf('T')+4) + (wincount+1) + "\nLW:T", false);
        }
      }

      //the current game stats
      System.out.println("Current game stats:");
      System.out.println(manager.fileToString(fileName));
      
      //play again loop
      input.nextLine();
      boolean temploop = true;
      while (temploop){
        temploop = false;
        System.out.println("Would you like to play again?(y/n)");
        String userInput = input.nextLine();  
        if (userInput.equalsIgnoreCase("y")){
          playAgain = true;
        } else if(userInput.equalsIgnoreCase("n")){
          playAgain = false;
        } else{
          System.out.println("Invalid input. Please enter a valid number.");
          temploop = true;
        }
      }

      //who last won check
      if(manager.fileToString(fileName).charAt(manager.fileToString(fileName).indexOf("LW:")+3) == 'X'){
        whosTurn = false;
      }
    }
  }

  public void optionsMenu(){
    FileSystemsManager TempManager = new FileSystemsManager();
    TempManager.createFile("options.txt");                   
    String tempstring = TempManager.fileToString("options.txt"); 

    //search through the string for the options
    String target = "autosave";
    for (int i = 0; i <= tempstring.length() - target.length(); i++) {
      if (tempstring.substring(i, i + target.length()).equalsIgnoreCase(target)) {
        // When found, check the character right before the colon
        char value = tempstring.charAt(i - 2); // the '1' or '0'

        if (value == '1') {
          autosaveEnabled = true;
        } else if (value == '0') {
          autosaveEnabled = false;
        }

        System.out.println("Autosave found. Enabled = " + autosaveEnabled);
      }
    }
  }

  public void rulesMenu(){
    System.out.println();
    System.out.println("The rules of Tic-Tac-Toe are simple:");
    System.out.println("The game is played on a 3x3 grid.");
    System.out.println("Players take turns placing their marks in empty squares.");
    System.out.println("The first player to get 3 of their marks in a row (up, down, across, or diagonally) wins the game.");
    System.out.println("If all 9 squares are full and neither player has 3 marks in a row, the game ends in a tie.");
    System.out.println("Type the number of the square you want to place your mark in.");
    System.out.println("Good luck and have fun!");
    System.out.println();
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