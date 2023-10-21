package co.edu.uptc.model;

public class Level {
	private String name;
	private int rows;
	private int columns;
	private int numberMines;
	
	public Level(String name, int rows, int columns, int numberMines) {
		super();
		this.name = name;
		this.rows = rows;
		this.columns = columns;
		this.numberMines = numberMines;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

	public int getNumberMines() {
		return numberMines;
	}

	public void setNumberMines(int numberMines) {
		this.numberMines = numberMines;
	}

	@Override
	public String toString() {
		return "Level [name=" + name + ", rows=" + rows + ", columns=" + columns + ", numberMines=" + numberMines + "]";
	}
	
	
	
}
