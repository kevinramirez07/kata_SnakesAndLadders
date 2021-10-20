package test;


import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import domain.Board;
import domain.Dice;
import domain.Player;

public class TheMovementsAreDeterminedByDiceRolls {
	
	
	private Player player1;
	private Board board;
	private Dice dice;
	
	@Before
    public void setUp() throws Exception {
		player1 = new Player("Kevin");
		dice = new Dice();
		board = new Board();
    }

	@Test
	public void randomRangeDice(){
	  int randomNumber = dice.rollDice();
	  assertTrue("Error, random is too high", 6 >= randomNumber);
	  assertTrue("Error, random is too low",  1  <= randomNumber);
	}
	
	@Test
	public void tokenMoveXPositionDice(){
	  int lastPosition = player1.getPosition();
	  int randomNumber = dice.rollDice();
	  player1.movePosition(dice.getNumber(),board);
	  assertTrue("Error, it's not the same", player1.getPosition() == (lastPosition+randomNumber));
	}
}
