package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class View implements IView {
	private FrameApp frameWeeperPlay;

	public View(ActionListener listener, MouseListener listenerMouse) {
		frameWeeperPlay = new FrameApp(listener, listenerMouse);
	}

	public FrameApp getFrameWeeperPlay() {
		return frameWeeperPlay;
	}

	public void showMessage(String message) {
		JOptionPane.showMessageDialog(frameWeeperPlay, message);
	}

	@Override
	public void loadNewPlay() {
		this.getFrameWeeperPlay().getPlayBoard().setVisible(false);
		this.getFrameWeeperPlay().getPlayBoard().removeAll();
	}

	@Override
	public void loadDataPlay(int rows, int columns, ActionListener listener, MouseListener listenerMouse) {
		this.getFrameWeeperPlay().getPlayBoard().loadDataPlay(rows, columns);
		this.getFrameWeeperPlay().getPlayBoard().loadPlayToBoard(listener, listenerMouse);
		this.getFrameWeeperPlay().getPlayBoard().setVisible(true);
	}

	@Override
	public void unclogButtons() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void gameOver() {
		// TODO Auto-generated method stub
		
	}

}
