package co.edu.uptc.view;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public interface IView {
	public void loadNewPlay();
	public void loadDataPlay(int rows, int columns, ActionListener listener, MouseListener listenerMouse);
	public void unclogButtons();
	public void gameOver();
}
