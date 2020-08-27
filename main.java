package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        // Question to open the Program
        System.out.println("Do you want to start the File Management?");

        // Creating the Input
        Scanner sc = new Scanner(System.in);
        String scanned = sc.next();

        // Answer Handling
        if (scanned.equals("Yes")) {
            System.out.println("Start a Command: ");
            System.out.println("Do !help to list the commands.");
            Scanner scans = new Scanner(System.in);
            String answer = scans.next();

            // Help Command
            if (answer.equals("!help")) {
                System.out.println("Do: !createFile  to create a File.");
                System.out.println("Do: !deleteFile to delete the File. ");
                System.out.println("Do: !write to write the File. ");
                System.out.println("Do: !read to read the File. ");

                System.out.println("Re-run the program choose a Command again");
            }

            if (answer.equals("!fileInformation")){
                try{
                File myObj = new File("filename.txt");
                if (myObj.exists()) {
                    System.out.println("File name: " + myObj.getName());
                    System.out.println("Absolute path: " + myObj.getAbsolutePath());
                    System.out.println("Writeable: " + myObj.canWrite());
                    System.out.println("Readable " + myObj.canRead());
                    System.out.println("File size in bytes " + myObj.length());
                } else {
                    System.out.println("The file does not exist.");
                }
            }
                catch (Exception e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            if (answer.equals("!createFile")) {
                //  File createFile = new File()
                System.out.println("SYSTEM: Created a new File.");
                try {
                    FileWriter newFile = new FileWriter("filename.txt");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            if (answer.equals("!write")) {
                // Write Command Here
                try {
                    System.out.println("Write your text below: ");
                    Scanner input = new Scanner(System.in);
                    String writes = input.next();
                    FileWriter newFile = new FileWriter("filename.txt");
                    newFile.write(writes);
                    newFile.close();
                    System.out.println("Successfully wrote to the file.");
                } catch (Exception e) {
                    System.out.println(e);
                }
            }

            if (answer.equals("!deleteFile")) {
                try {
                    File deleteFile = new File("filename.txt");
                    deleteFile.delete();
                    if (deleteFile.delete()) {
                        System.out.println("Successfully deleted the File.");
                    } else {
                        System.out.println("Failed deleted the File.");
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            if(answer.equals("!read")){
                try{
                    File currentFile = new File("filename.txt");
                    Scanner myReader = new Scanner(currentFile);
                    while(myReader.hasNextLine()){
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                }
                catch (FileNotFoundException e){
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }

            } else {
                System.out.println("System: The Management will not run. Re-run the Program to start the Management System.");
            }
        }
    }
}}
