package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import domain.Board;
import domain.Dice;
import domain.Player;


public class ThePlayerCanWinTheGame {
	private Player player1;
	private Board board;
	private Dice dice;
	
	@Before
    public void setUp() throws Exception {
		player1 = new Player("Kevin");
		dice = new Dice();
		board = new Board();
		player1.setPosition(99);
    }
	
	@Test
    public void playerCanWin() throws Exception {
		dice.setNumber(1);
		player1.movePosition(dice.getNumber(),board);
        assertEquals(board.getWinner(),player1);
  
    }
	
	@Test
    public void playerCantMoveIfExceeds() throws Exception {
		dice.setNumber(4);
		player1.movePosition(dice.getNumber(),board);
        assertEquals(99,player1.getPosition());
  
    }
}
