package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.util.List;

public interface IPresenter {
	public void loadPlayView(int level);
	public void unclogBox(ActionEvent e);
	public void gameOver(List<String> mines);
	public List<Integer> dataPlay(int level);
}
