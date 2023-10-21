package co.edu.uptc.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import co.edu.uptc.model.Minesweeper;
import co.edu.uptc.persistence.Persistence;
import co.edu.uptc.view.View;

public class Presenter implements ActionListener, MouseListener, IPresenter {
	private Minesweeper minesweeper;
	private Persistence persistence;
	private View view;

	public Presenter() {
		this.view = new View(this, this);
		this.minesweeper = new Minesweeper();
		this.persistence = new Persistence();
	}

	public void loadData() {
		minesweeper.loadLevel(this.persistence.readLevelInfo());
		view.getFrameWeeperPlay().getLoginPanel().loadComboBox(minesweeper.nameLevel());
		view.getFrameWeeperPlay().createMenu(this, minesweeper.nameLevel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String source = e.getActionCommand();

		if (source.equals("Start")) {
			if (!view.getFrameWeeperPlay().getLoginPanel().getLevelOption().contentEquals("Select level")
					&& !view.getFrameWeeperPlay().getLoginPanel().getInputNameUser().isEmpty()) {
				view.getFrameWeeperPlay().getLoginPanel().setVisible(false);
				for (int i = 0; i < minesweeper.getLevels().size(); i++) {
					if (minesweeper.getLevels().get(i).getName()
							.contentEquals(view.getFrameWeeperPlay().getLoginPanel().getLevelOption())) {
						loadPlayView(i);
					}
				}

			} else {
				view.showMessage("Please, complete fields");
			}
		}
		if (source.equals("Beginner")) {
			loadPlayView(0);
		}

		if (source.equals("Intermediate")) {
			loadPlayView(1);

		}

		if (source.equals("Expert")) {
			loadPlayView(2);
		}

		if (source.equals("Exit")) {
			System.exit(0);
		}

		if (minesweeper.gameOver(view.getFrameWeeperPlay().getPlayBoard().buttonClick(e))==false) {
			gameOver(minesweeper.getMines());
		} else {
			unclogBox(e);
		}

	}

	@Override
	public void loadPlayView(int level) {
		minesweeper.loadPlayDefault(0, 0, 0);
		view.cleanBoard();
		minesweeper.loadPlayDefault(dataPlay(level).get(0), dataPlay(level).get(1), dataPlay(level).get(2));
		view.loadDataPlay(dataPlay(level).get(0), dataPlay(level).get(1), this, this);
	}

	@Override
	public void unclogBox(ActionEvent e) {
		for (String point : minesweeper.unclogClue(view.getFrameWeeperPlay().getPlayBoard().buttonClick(e))) {
			view.unclogButtons(point, minesweeper.getClue(point));
		}
	}

	@Override
	public void gameOver(List<String> mines) {
		view.showMessage("Game over");
		for (String point : mines) {
			view.gameOver(point);
		}
	}

	@Override
	public List<Integer> dataPlay(int level) {
		List<Integer> dataPlay = new ArrayList<Integer>();
		dataPlay.add(minesweeper.getLevels().get(level).getRows());
		dataPlay.add(minesweeper.getLevels().get(level).getColumns());
		dataPlay.add(minesweeper.getLevels().get(level).getNumberMines());
		return dataPlay;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
