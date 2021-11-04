package com.alex;

//human player is a subclass of player
public class HumanPlayer extends Player{

    //sets tile
    public HumanPlayer(Tile tile) {
        super(tile);
    }

    //calls Map.humanQuit() when user types in QUIT
    public void humanExit(){
        Map.humanQuit();
        //exit
    }

    //calls Map.pickup when user types in PICKUP
    public void humanPickup(){
        Map.pickup();
        //gold pickup
    }

    //calls Map.getGoldToWin(), gets a number and tells the player how much gold they need to win on the map.
    //is called when user types in HELLO
    public void humanHello(){
        int gold = Map.getGoldToWin();
        System.out.println("Gold to win: "+ gold);
    }

    //calls Map.getGold to get the number of gold the user currently has. Then outputs that number
    public void humanGold(){
        int gold = Map.getGold();
        System.out.println("Gold owned: " + gold);
    }

    //calls Map.humanLook() with coordinates of user to allow the user to see their part of the map
    public void humanLook(){
        Map.humanLook(getX(), getY());
    }

}
