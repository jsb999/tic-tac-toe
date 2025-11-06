package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class FileSystemsManager{
  // load file systems manager
  public FileSystemsManager(){
    // Create a new folder for saves if it doesn't exist
    new File("gamesaves").mkdirs();
  }

  
  // Create a new file function
  public void createFile(String fileName) {
    try{
      // Check if the file already exists
      if (new File("gamesaves/" + fileName).exists()){
        System.out.println("File already exists.");
      } else{
        // Create a new file
        BufferedWriter writer = new BufferedWriter(new FileWriter("gamesaves/" + fileName));
        writer.close();
      }
    } catch (IOException e){
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  // Write to a file function
  public void fileWrite(String fileName, String text, boolean append){
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("gamesaves/" + fileName, append))) {
      writer.write(text);
      System.out.println("Data successfully written to file.");
    } catch (IOException e) {
      System.out.println("Error writing to file.");
      e.printStackTrace();
    }
  }

  // delete a file function
  public void deleteFile(String fileName) {
      File file = new File("gamesaves/" + fileName);

      if (file.exists()) {
          if (file.delete()) {
              System.out.println("File deleted: " + fileName);
          } else {
              System.out.println("Failed to delete file.");
          }
      } else {
          System.out.println("File does not exist.");
      }
  }

  // return a list of file names in the gamesaves folder with the file ids
  public String[] getFileNames(){
    File folder = new File("gamesaves");
    File[] listOfFiles = folder.listFiles();
    String[] fileNames = new String[listOfFiles.length];
    for (int i = 0; i < listOfFiles.length; i++){
      fileNames[i] = listOfFiles[i].getName();
    }

    //remove the file extension
    for (int i = 0; i < fileNames.length; i++){
      fileNames[i] = fileNames[i].substring(0, fileNames[i].lastIndexOf('.'));
    }

    //return the list of file names
    return fileNames;
  }

  // file names to string
  public String fileNamesToString(){
    String output = "";
    String[] fileNames = getFileNames();
    for (int i = 0; i < fileNames.length; i++){
      output += fileNames[i] + "\n";
    }
    return output;
  }
}