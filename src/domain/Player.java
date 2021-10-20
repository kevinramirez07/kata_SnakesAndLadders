package domain;

public class Player {
	
	private String name;
	private int position;
	
	public Player(String name) {
		this.name = name;
		this.position = 1;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public Player movePosition(int incrementPosition, Board board) {
		Player winner = null;
		if(this.position + incrementPosition <= 100) {
			this.position = this.position + incrementPosition;
		} else {
			System.out.println("You almost won !! Invalid movement. Keep playing.");
		}
		if(getPosition()==100) {
			System.out.println("You have landed in the final square. Your final position is: "+getPosition());
			System.out.println("You've won "+getName()+" Congratulations!");
			winner = this;
			board.setWinner(winner);
			return winner;
		}
		else {
		Box currentbox = board.getBox(getPosition());
		if(currentbox.getTypeBox()==0) {
			System.out.println("You have landed on a normal square. Your final position is: "+getPosition());
		} else {
			System.out.println("You have landed in a special square!!  "
					+ "Your final position jumps out of the "+ getPosition()+" to "+(currentbox.getLastPosition()+1));
			setPosition((currentbox.getLastPosition()+1));
			if(getPosition()==100) {
				System.out.println("You've won "+getName()+" Congratulations!");
				winner = this;
				board.setWinner(winner);
				return winner;
			}
		}
		System.out.println("End of player's turn. Next player.");
		System.out.println();
		}
		return winner;
		
	}

}
