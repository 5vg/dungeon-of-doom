package com.alex;
import java.util.Scanner;

public class Game {
    //creates a map reference
    private Map map;

    //initializer function takes in an integer of user's map choice
    public Game(int choice){
        //creates new strings
        String thisMap = null;
        //this stores the file path of the maps. change this to allow for map choice functionality
        String filePath = "src/com/alex/";
        //checks what the user's choice was and ses the map accordingly
        if(choice == 1){
            System.out.print("You have selected the small map: ");
            thisMap = filePath + "small_map.txt";
        }else if(choice == 2){
            System.out.print("You have selected the medium map: ");
            thisMap = filePath + "medium_map.txt";
        }else if(choice == 3){
            System.out.print("You have selected the large map: ");
            thisMap = filePath + "large_map.txt";
        }
        //creates new map and passes in the filepath to the map selected
        map = new Map(thisMap);
    }

    //is called by main after class Game is initialized
    public void playGame() {
        //creates variables
        String userInput;
        int turnCounter=0;
        int botCounter=0;

        //creates new human player and places them in a random location
        HumanPlayer human = new HumanPlayer(new Tile('P'));
        human.placePlayer();

        //creates new bot player and places them in a random location
        BotPlayer bot = new BotPlayer(new Tile('B'));
        bot.placePlayer();
        //makes sure that the starting location of the bot player and human player aren't the same
        while (bot.getX() == human.getX() && bot.getY() == human.getY()) {
            bot.placePlayer();
        }
        //creates a new scanner to allow for user input
        Scanner input = new Scanner(System.in);
        //notifies the user that the game has begun
        System.out.println("You can now begin entering operations");
        //while(true) loop allows for constant input
        while (true) {
            //checks if bot wins at the start of every turn
            map.checkBotWin();
            //turn counter keeps track of whose turn it is
            turnCounter++;
            //turn selected by taking remainder of a division by 2
            //user always goes first
            if(turnCounter%2 == 1){
                //takes input and puts it into an array which is split by whitespaces
                userInput = input.nextLine();
                String[] userArr;
                userArr = userInput.split(" ");
                //checks what the user ahs entered and runs the appropriate function from Map
                if (userArr[0].equals("HELLO")) {
                    human.humanHello();
                }else if(userArr[0].equals("GOLD")){
                    human.humanGold();
                }else if(userArr[0].equals("MOVE")){
                    //makes sure there was a direction entered after MOVE
                    try{
                        human.move(userArr[1].charAt(0));
                    }catch(Exception e){
                        System.out.println("FAIL.");
                    }
                }else if(userArr[0].equals("PICKUP")){
                    human.humanPickup();
                }else if(userArr[0].equals("LOOK")){
                    human.humanLook();
                }else if(userArr[0].equals("QUIT")){
                    human.humanExit();
                    // if action not found, prints FAIL.
                }else{
                    System.out.println("FAIL.");
                }
                //bot's turn
            }else{
                //bot counter keeps track of which action the bot is to perform
                botCounter++;
                if(botCounter%2 == 1){
                    //every other turn bot moves
                    bot.botLook();
                }else{
                    //and every other turn bot looks
                    bot.botMove();
                }

            }

        }
    }
}
