package domain;

import java.util.Random;

public class Dice {
	
	private int number;

	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public int rollDice () {
		Random random = new Random();
		number = random.nextInt(6) + 1;
		return number;
	}	

}
