package core;

import java.util.ArrayList;

import cards.Card;

//TODO: Implement various scoring methods to work for collection of Players

/**
 * Class for holding various elements which contribute to the final score
 * 
 * @author Dom Parfitt
 *
 */
public class Score {

	private int score;
	private int puddingCount;
	private int makiScore;

	/**
	 * Public constructor for intialising starting score
	 */
	public Score() {
		this.score = 0;
		this.puddingCount = 0;
		this.makiScore = 0;
	}

	/**
	 * Private constructor for returning new score
	 * 
	 * @param score
	 *            numerical score
	 * @param puddingCount
	 *            count of puddings
	 */
	private Score(int score, int puddingCount, int makiScore) {
		this.score = score;
		this.puddingCount = puddingCount;
		this.makiScore = makiScore;
	}

	/**
	 * Get the numerical score
	 * 
	 * @return the numerical score
	 */
	public int getNumScore() {
		return this.score;
	}

	/**
	 * Get the count of puddings
	 * 
	 * @return the number of puddings
	 */
	public int getPuddingCount() {
		return this.puddingCount;
	}

	public int getMakiScore() {
		return this.makiScore;
	}

	/**
	 * Adds two scores together. Used to update scores between rounds
	 * 
	 * @param other
	 * @return
	 */
	public Score addScore(Score other) {
		int newScore = this.getNumScore() + other.getNumScore();
		int newPuddingCount = this.getPuddingCount() + other.getPuddingCount();
		return new Score(newScore, newPuddingCount, other.getMakiScore());
	}

	
	public static Score getScore(ArrayList<Card> cards) {
		int score = 0;
		int makiScore = 0;
		int tempuraCount = 0;
		int sashimiCount = 0;
		int puddingCount = 0;
		boolean wasabiFlag = false;

		// Handle each individual card
		for (Card card : cards) {
			switch (card.getType()) {
			case CHOPSTICKS:
				break;
			case MAKI:
				makiScore += card.getValue();
				break;
			case NIGIRI:
				if (wasabiFlag) {
					score += (card.getValue() * 3);
					wasabiFlag = false;
				} else {
					score += card.getValue();
				}
				break;
			case PUDDING:
				puddingCount++;
				break;
			case SASHIMI:
				sashimiCount++;
				break;
			case TEMPURA:
				tempuraCount++;
				break;
			case WASABI:
				wasabiFlag = true;
				break;
			default:
				break;
			}

		}

		// Check for tempura pairs
		score += ((tempuraCount / 2) * 5);

		// Check for sashimi triples
		score += ((sashimiCount / 3) * 10);

		return new Score(score, puddingCount, makiScore);
	}
	
	// TODO: Test this thoroughly
	// TODO: Allow handling of ties
	// TODO: Allow single winner (i.e. no second highest)
	public static ArrayList<Player> addMakis(ArrayList<Player> players) {

		int highIndex = 0;
		int highScore = 0;
		int secondIndex = 0;
		int secondScore = 0;

		for (int i = 0; i < players.size(); i++) {
			int score = players.get(i).getScore().getMakiScore();
			if (score > highScore) {
				// Set the second highest to the current max
				secondIndex = highIndex;
				secondScore = highScore;

				// Set the highest to the new one
				highIndex = i;
				highScore = score;
			} else if (score > secondScore) {
				// Set the second highest to the new one
				secondIndex = i;
				secondScore = score;
			}
		}

		players.get(highIndex).updateScore(new Score(6, 0, 0));
		players.get(secondIndex).updateScore(new Score(3, 0, 0));
		
		System.out.println(players.get(highIndex) + " scored +6 for most Makis with " + highScore);
		System.out.println(players.get(secondIndex) + " scored +3 for second most Makis with " + secondScore);
		
		return players;

	}

	/**
	 * Static method to calculate the bonus and reduction for the most
	 * and least puddings
	 * @param scores
	 * @return
	 */
	public static ArrayList<Player> addPuddings(ArrayList<Player> players) {
		int highIndex = 0;
		int highCount = 0;
		int lowIndex = 0;
		int lowCount = Integer.MAX_VALUE;

		for (int i = 0; i < players.size(); i++) {
			int puddingCount = players.get(i).getScore().getPuddingCount();
			if (puddingCount > highCount) {
				highCount = puddingCount;
				highIndex = i;
			} else if (puddingCount < lowCount) {
				lowCount = puddingCount;
				lowIndex = i;
			}
		}

		//Only give a bonus if someone has puddings
		if (highCount > 0) {
			players.get(highIndex).updateScore(new Score(6, 0, 0));
			System.out.println(players.get(highIndex) + " scored +6 for most Puddings with " + highCount);
		}
		
		players.get(lowIndex).updateScore(new Score(-6, 0, 0));
		System.out.println(players.get(lowIndex) + " scored -6 for least Puddings with " + lowCount);

		return players;
		
	}
	
	public static ArrayList<Player> getScores(ArrayList<Player> players) {
		for (Player player : players) {
			ArrayList<Card> playedCards = player.getPlayedCards();
			Score newScore = Score.getScore(playedCards);
			player.updateScore(newScore);
			System.out.println(player + " scored " + newScore.getNumScore() + " from Nigiris, Tempuras and Sashimis");
		}
		
		return players;
	}
	
	public static ArrayList<Player> getRoundScore(ArrayList<Player> players) {
		players = getScores(players);
		return addMakis(players);
		
	}
	
	public static void showScores(ArrayList<Player> players) {
		for(int i = 0; i < players.size(); i++) {
			System.out.println(players.get(i));
			players.get(i).showPlayed();
			System.out.println(players.get(i).getScore().getNumScore());
			
		}
	}
	
}
