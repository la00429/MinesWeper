package co.edu.uptc.model;

import java.util.List;
import java.util.ArrayList;

public class Minesweeper implements IMinesweeper {
	private Box[][] board;
	private int rows;
	private int columns;
	private int numberMines;
	private ArrayList<Level> levels;
	private boolean playState;
	private List<String> mines;

	public Minesweeper() {
		super();
		this.rows = 0;
		this.columns = 0;
		this.numberMines = 0;
		this.board = new Box[0][0];
		this.levels = new ArrayList<Level>();
		this.mines = new ArrayList<String>();

	}

	public void loadPlayDefault(int rows, int columns, int numberMines) {
		setRows(rows);
		setColumns(columns);
		setNumberMines(numberMines);
		setBoard();
		createBoardBox();
		createMines();
		updateNumberBoxClue();
	}

	private void createBoardBox() {
		for (int i = 0; i < this.columns; i++) {
			for (int j = 0; j < this.rows; j++) {
				board[i][j] = new Box(i, j);
			}
		}
	}
	
	private void createMines() {
		setMines(new ArrayList<String>());
		int minesCreate = 0;
		int rowTemp = 0;
		int columnTemp = 0;
		while (minesCreate != this.numberMines) {
			rowTemp = (int) (Math.random() * this.board.length);
			columnTemp = (int) (Math.random() * this.board[0].length);
			if (!this.board[rowTemp][columnTemp].isBomb()) {
				this.board[rowTemp][columnTemp].setBomb(true);
				mines.add(rowTemp + "," + columnTemp);
				minesCreate++;
			}
		}
	}
	
	private void updateNumberBoxClue() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j].isBomb()) {
					List<Box> bombAround = boxAround(i, j);
					for (Box box : bombAround) {
						box.setNumber(box.getNumber() + 1);
					}
				}
			}
		}
	}

	private List<Box> boxAround(int rowBomb, int columnBomb) {
		List<Box> boxAround = new ArrayList<Box>();

		for (int i = 0; i < 8; i++) {
			int rowTemp = rowBomb;
			int columnTemp = columnBomb;
			switch (i) {
			case 1:
				rowTemp--;
				break;
			case 2:
				rowTemp--;
				columnTemp++;
				break;
			case 3:
				columnTemp++;
				break;
			case 4:
				rowTemp++;
				columnTemp++;
				break;
			case 5:
				rowTemp++;
				break;
			case 6:
				rowTemp++;
				columnTemp--;
				break;
			case 7:
				columnTemp--;
				break;
			case 0:
				rowTemp--;
				columnTemp--;
				break;
			default:
				break;
			}

			if (rowTemp >= 0 && rowTemp < this.board.length && columnTemp >= 0 && columnTemp < this.board[0].length
					&& this.board[rowTemp][columnTemp].isBomb() == false) {
				boxAround.add(this.board[rowTemp][columnTemp]);
			}
		}
		return boxAround;
	}
	
	@Override
	public void loadLevel(List<Object> levelFile) {
		for (int i = 0; i < levelFile.size(); i++) {
			if (i % 4 == 0) {
				Level level = new Level((String) levelFile.get(i), Integer.parseInt((String) levelFile.get(i + 1)),
						Integer.parseInt((String) levelFile.get(i + 2)),
						Integer.parseInt((String) levelFile.get(i + 3)));
				levels.add(level);
			}
		}
	}

	public ArrayList<Object> nameLevel() {
		ArrayList<Object> namesLevel = new ArrayList<Object>();
		for (Level level : levels) {
			namesLevel.add(level.getName());
		}
		return namesLevel;
	}

	private void unclogBombs() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j].isBomb()) {
					board[i][j].setState(true);
				}
			}
		}
	}

	@Override
	public List<String> unclogClue(String point) {
		List<String> uncoveredTiles = new ArrayList<>();

		if (!point.isEmpty()) {
			String[] pointCoordinates = point.split(",");
			int[] pointSelect = new int[pointCoordinates.length];
			for (int i = 0; i < pointCoordinates.length; i++) {
				pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
			}
			List<Box> boxAround = boxAround(pointSelect[0], pointSelect[1]);

			for (Box box : boxAround) {
				if (box.isBomb() == true) {
					boxAround.remove(box);
				}

				if (box.isBomb() == false) {
					uncoveredTiles.add(point);
					box.setState(true);
					uncoveredTiles.add(box.getRow() + "," + box.getColumn());
				}

			}
		}
		return uncoveredTiles;
	}
	@Override
	public boolean gameOver(String point) {
		String[] pointCoordinates = point.split(",");
		int[] pointSelect = new int[pointCoordinates.length];
		for (int i = 0; i < pointCoordinates.length; i++) {
			pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
		}
		if (this.board[pointSelect[0]][pointSelect[1]].isBomb()) {
			this.playState = false;
			unclogBombs();
		} else {
			if (this.board[pointSelect[0]][pointSelect[1]].getNumber() != 0) {
				this.playState = true;
				unclogClue(point);
			} else {
				this.playState = true;
				unclogClue(point);
			}
		}
		return this.playState;

	}

	public String getClue(String point) {
		String clue = new String();
		String[] pointCoordinates = point.split(",");
		int[] pointSelect = new int[pointCoordinates.length];
		for (int i = 0; i < pointCoordinates.length; i++) {
			pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
		}
		if (board[pointSelect[0]][pointSelect[1]].getNumber() != 0) {
			clue = String.valueOf(board[pointSelect[0]][pointSelect[1]].getNumber());
		}

		return clue;
	}

	public Box[][] getBoard() {
		return board;
	}

	public void setBoard() {
		this.board = new Box[this.rows][this.columns];
	}

	public ArrayList<Level> getLevels() {
		return levels;
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

	public List<String> getMines() {
		return mines;
	}

	public void setMines(List<String> mines) {
		this.mines = mines;
	}

	public void setPlayState(boolean playState) {
		this.playState = playState;
	}

	public boolean isPlayState() {
		return playState;
	}

}
