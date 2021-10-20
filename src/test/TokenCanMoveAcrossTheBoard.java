package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Utilities.typeBox;
import domain.Board;
import domain.Dice;
import domain.Player;

public class TokenCanMoveAcrossTheBoard {
	private Player player1;
	private Board board;
	private Dice dice;
	
	@Before
    public void setUp() throws Exception {
		player1 = new Player("Kevin");
		dice = new Dice();
		board = new Board();
		board.getBoxes().get(3).updateParams(typeBox.ESPECIAL, 3, 20);
		board.getBoxes().get(20).updateParams(typeBox.ESPECIAL, 20, 3);
    }
	
	@Test
    public void tokenShouldStartOnSquareOne() throws Exception {
        int expectedBoxLocation = 1;
        assertEquals(expectedBoxLocation,player1.getPosition());
  
    }
	
	@Test
    public void tokenCanMoveToNewPlace() throws Exception {
		dice.setNumber(2);
		player1.movePosition(dice.getNumber(),board);
        assertEquals(3,player1.getPosition());
  
    }
	
	@Test
    public void tokenCanJumpToNewPlace() throws Exception {
		dice.setNumber(3);
		player1.movePosition(dice.getNumber(),board);
        assertEquals(21,player1.getPosition());
  
    }
	
	
	

}
