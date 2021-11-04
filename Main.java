package com.alex;
//imports things which are used in the code
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.*;

//main class
public class Main {

    public static void main(String[] args) {
        //creates a new scanner
        Scanner input = new Scanner(System.in);

        //creates integers including number of maps
        int numberOfMaps = 3;
        int choice = 0;

        //prints instructions and a welcome message
        System.out.println("Welcome to DoD");
        System.out.println("Please enter an integer corresponding to your choice of map");
        System.out.println("Small: 1");
        System.out.println("Medium: 2");
        System.out.println("Large: 3");

        //tells the user what they have to type in
        System.out.print("Enter a number between 1 and " + numberOfMaps + ": ");
        while (true) {
            //makes sure the user's input falls in line with what is expected. If not, causes the input to loop
            //and allow the user multiple attempts at entering the map number
            String strChoice = input.next();
            try{
                choice = Integer.parseInt(strChoice);
                if(choice>=1 && choice<=numberOfMaps) {
                    break;
                }else{
                    System.out.print("Please enter a number between 1 and " + numberOfMaps + ": ");
                }
            }catch(Exception e) {
                System.out.print("Please enter a number between 1 and " + numberOfMaps + ": ");
            }
        }
        //creates new game and calls playGame()
	    Game game = new Game(choice);
	    game.playGame();
    }
}
