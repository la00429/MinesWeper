package co.edu.uptc.model;

public class Box {
	private int number;
	private boolean state;
	private String label;
	private boolean bomb;
	private int column;
	private int row;

	public Box(int column, int row) {
		this.column = column;
		this.row = row;
		this.number = 0;
		this.state = false;
		this.label = new String();
		this.bomb = false;
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isBomb() {
		return bomb;
	}

	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Box [number=" + number + ", state=" + state + ", label=" + label + ", bomb=" + bomb + ", column="
				+ column + ", row=" + row + "]";
	}
	
	

}
