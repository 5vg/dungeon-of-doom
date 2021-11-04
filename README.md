# Dungeon of Doom

Dungeon of Doom (DoD) is a dungeon based game where you, the player, has to get a certain amount of gold before leaving the dungeon.
There is a computer-controlled player trying to actively find and catch you at which point you lose the game - try to avoid them.
To win - you must collect enough gold and get to an exit square where you will be able to leave.

Run the game by launching Main.java.

To pick a map, you must go through a selection screen. 
In order for maps to be loadable - please update the file path on line 13 in Game.java acording to your current setup.
In order to add your own map please update the following: thisMap declaration between lines 15 and 23 in Game.java, 
and/or the choice screen in Main.java between the lines 19 and 23. 

Board representation:
	Empty Floor - represented by a .
	Player - represented by a P
	Bot - represented by a B
	Gold - represented as a G (once picked up - convered to an empty floor tile)
	Exit - represented as an E
	Wall - represented as a # (cannot walk through)

Controls:
	HELLO - Tells you how much gold you need to escape the dungeon
	GOLD - Tells you how much gold you currently have
	MOVE <direction> - Allows you to move in a specified direction
		- directions are N, E, S, W and you will be notified if you move was a success or not by either a SUCCESS or FAIL message
	PICKUP - Picks up gold at your location if there is any
	LOOK - Allows you to see a 5x5 grid around you which shows any of the board tiles
	QUIT - Quits the game at a loss if you're not on the exit tile or you don't have enough gold to win
		- Quits the game at a win if you do have enough gold to win and are on the exit tile
	ALL COMMANDS TAKE UP A PLAYER'S TURN REGARDLESS OF WHETHER THEY WERE SUCCESSFUL OR NOT

The board was implemented as a 2D array of characters each of which can be changed depending on what is happening in the game. 

The bot's behaviour pattern is as follows - it randomly makes a move until it sees a player in which case it tries to catch them. 

The bot alternates between random MOVE and LOOK until it locates a player. At that point it moves towards the player at every turn updating the
player's location as it goes.

Neither the bot, nor the player can spawn in the walls or on a gold tile. The bot not spawning on a gold tile allows that tile to not be covered at the beginning of the game.

I hope you enjoy the game.