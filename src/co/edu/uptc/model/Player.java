package co.edu.uptc.model;


public class Player {
	private String userPlayerName;
	private String lastPlay;
	
	
	public Player(String userPlayerName, String lastPlay) {
		super();
		this.userPlayerName = userPlayerName;
		this.lastPlay = lastPlay;
	}
	public String getUserPlayerName() {
		return userPlayerName;
	}
	public void setUserPlayerName(String userPlayerName) {
		this.userPlayerName = userPlayerName;
	}
	public String getLastPlay() {
		return lastPlay;
	}
	public void setLastPlay(String lastPlay) {
		this.lastPlay = lastPlay;
	}

	

}
