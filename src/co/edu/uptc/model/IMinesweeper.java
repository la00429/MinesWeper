package co.edu.uptc.model;

import java.util.List;

interface IMinesweeper {
	public void loadPlayDefault(int rows, int columns, int numberMines);
	public void loadLevel(List<Object> levelFile);
	public List<String> unclogClue(String point);
	public boolean gameOver(String point);
}
