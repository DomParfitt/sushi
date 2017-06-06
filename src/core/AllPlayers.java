package core;

import java.util.ArrayList;

public class AllPlayers {

	private ArrayList<Player> players;
	
	public AllPlayers() {
		this.players = new ArrayList<Player>();
	}
	
	public void addPlayer(Player player) {
		this.players.add(player);
	}
	
	public int getPlayerCount() {
		return this.players.size();
	}
	
	public Score[] getScores() {
		Score[] scores = new Score[getPlayerCount()];
		for (int i = 0; i < getPlayerCount(); i++) {
			scores[i] = this.players.get(i).getScore();
		}
		
		return scores;
	}
	
	public ArrayList<Score> getScoresList() {
		ArrayList<Score> scores = new ArrayList<Score>();
		
		for (int i = 0; i < getPlayerCount(); i++) {
			scores.add(this.players.get(i).getScore());
		}
		
		return scores;
	}
	
}
