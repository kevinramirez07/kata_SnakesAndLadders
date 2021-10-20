package domain;


public class Box {
	
	private int typeBox;
	private int startPosition;
	private int lastPosition;
	
	
	public Box() {
		this.typeBox = Utilities.typeBox.NORMAL;
	}


	public int getTypeBox() {
		return typeBox;
	}


	public void setTypeBox(int typeBox) {
		this.typeBox = typeBox;
	}


	public int getStartPosition() {
		return startPosition;
	}


	public void setStartPosition(int startPosition) {
		this.startPosition = startPosition;
	}


	public int getLastPosition() {
		return lastPosition;
	}


	public void setLastPosition(int lastPosition) {
		this.lastPosition = lastPosition;
	}

	
	public void updateParams(int typeBox, int startPosition, int lastPosition) {
		this.typeBox = typeBox;
		this.startPosition = startPosition;		
		this.lastPosition = lastPosition;
	}	

}
