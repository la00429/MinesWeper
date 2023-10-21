package co.edu.uptc.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.MenuBar;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class FrameApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private Login loginPanel;
	private MinesWeeper playBoard;
	private User userPanel;
	private JMenuBar menuBar;

	public FrameApp(ActionListener listener, MouseListener listenerMouse) {
		initComponents(listener, listenerMouse);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(getMaximumSize());
		this.setVisible(true);
	}

	private void initComponents(ActionListener listener, MouseListener listenerMouse) {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		startLogin(gbc, listener);
		starPlay(listener, listenerMouse);
	}

	private void startLogin(GridBagConstraints gbc, ActionListener listener) {
		loginPanel = new Login(listener);
		this.add(loginPanel, gbc);
	}

	private void starPlay(ActionListener listener, MouseListener listenerMouse) {
		playBoard = new MinesWeeper(listener, listenerMouse);
		playBoard.setBounds(WIDTH, HEIGHT, WIDTH, HEIGHT);
		this.add(playBoard);
	}

	public int setRows(int rows) {
		int rowsPlay = rows;
		return rowsPlay;
	}

	public int setColumns(int columns) {
		int columnsPlay = columns;
		return columnsPlay;
	}

	public void createMenu(ActionListener listener, ArrayList<Object> items) {

		menuBar = new JMenuBar();
		JMenu menuPlay = new JMenu("Play");
		JMenu menuUser = new JMenu("Level");

		for (Object object : items) {
			JMenuItem level = new JMenuItem(object.toString());
			level.addActionListener(listener);
			level.setActionCommand(object.toString());
			level.getText();
			menuUser.add(level);
		}

		menuPlay.add(menuUser);
		menuBar.add(menuPlay);

		JMenu menuHelp = new JMenu("Help");

		menuBar.add(menuHelp);

		this.setJMenuBar(menuBar);

	}

	public Login getLoginPanel() {
		return loginPanel;
	}

	public User getUserPanel() {
		return userPanel;
	}

	public MinesWeeper getPlayBoard() {
		return playBoard;
	}

}
