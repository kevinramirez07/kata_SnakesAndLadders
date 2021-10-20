package domain;

import java.util.ArrayList;
import java.util.List;

import Keyboard.Keyboard;
import Utilities.typeBox;

public class Board {

	private List<Box> boxes;
	private int numberSnakesAndLadders;
	private Player winner;

	public Board(int level) {
		this.boxes = new ArrayList<Box>(100);
		for(int i =0; i<100;i++) boxes.add(new Box());
		while(level!=1 && level!=2 && level!=3) {
			System.out.print("Error: Choose a valid level please (1, 2 or 3)");
			level = Keyboard.readInt();
		}
		if(level==1) this.numberSnakesAndLadders = 4;
		else if (level==2) this.numberSnakesAndLadders = 8;
		else  this.numberSnakesAndLadders = 12;
		setSnakesAndLadders();
		winner = null;
	}
	
	public Board() {
		this.boxes = new ArrayList<Box>(100);
		for(int i =0; i<100;i++) boxes.add(new Box());
		winner = null;
	}

	public void setSnakesAndLadders() {
		int numbersDone = 0;

		while (numbersDone <= this.numberSnakesAndLadders) {
			int startNumber = (int) (1 + (Math.random() * ((this.boxes.size()-1) - 1))); //[1,98]
			int finalNumber = (int) ((startNumber+1) + (Math.random() * (this.boxes.size() - (startNumber+1))));//[min+1,
			
			if (this.boxes.get(startNumber).getTypeBox() == typeBox.NORMAL && 
					this.boxes.get(finalNumber).getTypeBox() == typeBox.NORMAL) {
				this.boxes.get(startNumber).updateParams(typeBox.ESPECIAL, startNumber, finalNumber);
				this.boxes.get(finalNumber).updateParams(typeBox.ESPECIAL, finalNumber, startNumber);
				numbersDone ++;
			} 

		}
	}

	public List<Box> getBoxes() {
		return boxes;
	}

	public void setList(List<Box> boxes) {
		this.boxes = boxes;
	}

	public int getNumberSnakesAndLadders() {
		return numberSnakesAndLadders;
	}

	public void setNumberSnakesAndLadders(int numberSnakesAndLadders) {
		this.numberSnakesAndLadders = numberSnakesAndLadders;
	}
	
	public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Box getBox(int position) {		
		return this.boxes.get(position-1);
	}
	
	

}
