package Application;

import java.util.ArrayList;
import java.util.List;
import Keyboard.*;
import domain.Board;
import domain.Dice;
import domain.Player;

public class SnakesAndLadders {
	
	public static void main(String[] args) throws InterruptedException {
		
		Board board;
		Dice dice= new Dice();
		List<Player> players = new ArrayList<Player>();
		int numberPlayers;
	
		numberPlayers = initialGame();
		initialPlayers(players, numberPlayers);
		board = initialLevel();
		
		while(board.getWinner()==null) {
			play(board, dice, players);
		}
		
	}

	private static int initialGame() {
		int numberPlayers;
		System.out.println("Welcome to de Snakes and Ladders game!!");
		System.out.println("***************************************");
		System.out.println("First of all: How many players will play?");
		numberPlayers = Keyboard.readInt();
		return numberPlayers;
	}
	
	private static void initialPlayers(List<Player> players, int numberPlayers) {
		for (int i = 1; i <= numberPlayers;i++) {
			System.out.println("Nice! Please tell me the name of the player "+i+":");
			String namePlayer = Keyboard.readString();
			players.add(new Player(namePlayer));
		}
	}
	
	private static Board initialLevel() {
		Board board;
		int level;
		System.out.println("What level do you want to play? (Easy (1) / Medium (2) / Hard (3))");
		level = Keyboard.readInt();
		board = new Board(level);
		System.out.println("Loading the board ..");
		System.out.println("Play!!");
		return board;
	}
	
	private static void play(Board board, Dice dice, List<Player> players)
			throws InterruptedException {
		for(Player player: players) {
			System.out.println("Play "+player.getName()+",current position:"+player.getPosition());
			System.out.println("Roll the dice and come out ... "+ dice.rollDice()+"!");
			if(player.movePosition(dice.getNumber(),board) != null) break;
			Thread.sleep(1000);
			}
	}

}
