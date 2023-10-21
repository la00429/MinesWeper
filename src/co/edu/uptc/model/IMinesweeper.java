package co.edu.uptc.model;

import java.util.List;

interface IMinesweeper {
	public void loadPlayDefault(int rows, int columns, int numberMines);
	public void createMines();
	public void loadLevel(List<Object> levelFile);
}
