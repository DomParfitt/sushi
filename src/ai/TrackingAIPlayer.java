package ai;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import cards.Card;
import core.Game;
import core.Player;
import core.Score;

public class TrackingAIPlayer extends AIPlayer {

	private Game game;
	private List<List<Card>> allHands;
	private List<List<Card>> allPlayed;
	private List<Score> scores;
	private boolean gameStarted;
	private int handTracker;
	
	
	public TrackingAIPlayer(String name, Game game) {
		super(name);
		this.game = game;
		this.allHands = new ArrayList<>();
		this.allPlayed = new ArrayList<>();
		this.scores = new ArrayList<Score>();
		this.gameStarted = false;
		this.handTracker = 0;
	}

	@Override
	public Card requestCard() {
		/*
		 * Some set up requires the game to have started (e.g. getting
		 * the AI's hand or number of players). Can assume when a card
		 * request call comes in from the game that the game has started
		 * so do this set up
		 */
		if(!gameStarted) {
			gameStarted = true;
			for (Player player: game.getPlayers()) {
				scores.add(player.getScore());
			}
			scores.sort(new Comparator<Score>() {

				@Override
				public int compare(Score s1, Score s2) {
					Integer s1Num = s1.getNumScore();
					Integer s1Maki = s1.getMakiScore();
					Integer s1Pud = s1.getPuddingCount();
					Integer s2Num = s2.getNumScore();
					Integer s2Maki = s2.getMakiScore();
					Integer s2Pud = s2.getPuddingCount();
					
					/*
					 * Forecast maki and pudding points assuming full spread,
					 * i.e. card with highest will get the best bonus and 
					 * other card will get worst forfeit
					 */
					if (s1Maki > s2Maki) {
						s1Num += 6; //3?
					} else if (s2Maki > s1Maki) {
						s2Num += 6;
					} 
					
					if (s1Pud > s2Pud) {
						s1Num += 12;
					} else if (s2Pud > s1Pud) {
						s2Num += 12;
					}
					
					return s1Num.compareTo(s2Num);
				}
			});
		}
		
		allHands.add(handTracker, game.getHand(this));
		
		handTracker++;
		handTracker %= game.getPlayers().size();

		return null;
	}
	

}
