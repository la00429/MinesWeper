package co.edu.uptc.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MinesWeeper extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonMinesWeeper[][] board;
	private int rows;
	private int columns;

	public MinesWeeper(ActionListener listener, MouseListener listenerMouse) {

		initComponents(listener, listenerMouse);
		this.setSize(getMaximumSize());
		this.setVisible(false);
	}

	private void initComponents(ActionListener listener, MouseListener listenerMouse) {
		loadPlayToBoard(listener, listenerMouse);
	}

	public void loadPlayToBoard(ActionListener listener, MouseListener listenerMouse) {
		board = new ButtonMinesWeeper[rows][columns];
		if (rows != 0 && columns != 0) {
			this.setLayout(new GridLayout(rows, columns));
			for (int i = 0; i < this.rows; i++) {
				for (int j = 0; j < this.columns; j++) {
					board[i][j] = new ButtonMinesWeeper();
					board[i][j].addActionListener(listener);
					board[i][j].addMouseListener(listenerMouse);
					board[i][j].setPreferredSize(new Dimension(40, 40));
					this.add(board[i][j]);
				}

			}
		}

	}

	public String buttonClick(ActionEvent e) {
		Object buttonClick = e.getSource();
		String point = new String();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == buttonClick) {
					point = i + "," + j;
					System.out.println(i + "." + j);
				}
			}
		}
		return point;
	}

	public void buttonFalse(String point) {
		String[] pointCoordinates = point.split(",");
		int[] pointSelect = new int[pointCoordinates.length];
		for (int i = 0; i < pointCoordinates.length; i++) {
			pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
		}
		board[pointSelect[0]][pointSelect[1]].setEnabled(false);
	}

	public void buttonFalseBomb(String point, String text) {
		String[] pointCoordinates = point.split(",");
		int[] pointSelect = new int[pointCoordinates.length];
		for (int i = 0; i < pointCoordinates.length; i++) {
			pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
		}
		board[pointSelect[0]][pointSelect[1]].setBackground(Color.RED);
		board[pointSelect[0]][pointSelect[1]].setText(text);
		board[pointSelect[0]][pointSelect[1]].setEnabled(false);
	}

	public void buttonClue(String point, String text) {
		String[] pointCoordinates = point.split(",");
		int[] pointSelect = new int[pointCoordinates.length];
		for (int i = 0; i < pointCoordinates.length; i++) {
			pointSelect[i] = Integer.parseInt(pointCoordinates[i]);
		}
		board[pointSelect[0]][pointSelect[1]].setFont(new Font("Arial", Font.PLAIN, 10));
		board[pointSelect[0]][pointSelect[1]].setBackground(Color.GRAY);
		board[pointSelect[0]][pointSelect[1]].setText(text);
	}

	public JButton[][] getBoard() {
		return board;
	}

	public void loadDataPlay(int rows, int columns) {
		setRows(rows);
		setColumns(columns);
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}

}
