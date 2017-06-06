package core;

import java.util.ArrayList;

public class PlayerList {

	private int maxPlayers;
	private ArrayList<Player> players;
	
	public PlayerList() {
		this.players = new ArrayList<Player>();
	}
	
	public PlayerList(int maxPlayers) {
		this();
		this.maxPlayers = maxPlayers;
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public int getPlayerCount() {
		return this.players.size();
	}
	
	public ArrayList<Player> getPlayers() {
		return this.players;
	}
	
	@Deprecated
	public Score[] getScoresArray() {
		Score[] scores = new Score[getPlayerCount()];
		for (int i = 0; i < getPlayerCount(); i++) {
			scores[i] = this.players.get(i).getScore();
		}
		
		return scores;
	}
	
	public ArrayList<Score> getScores() {
		ArrayList<Score> scores = new ArrayList<Score>();
		
		for (int i = 0; i < getPlayerCount(); i++) {
			scores.add(this.players.get(i).getScore());
		}
		
		return scores;
	}
	
}
